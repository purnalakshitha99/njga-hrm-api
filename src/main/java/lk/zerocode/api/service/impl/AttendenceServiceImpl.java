package lk.zerocode.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lk.zerocode.api.controller.dto.AttandanceSearchDTO;
import lk.zerocode.api.controller.dto.AttendanceDTO;
import lk.zerocode.api.controller.dto.BasicDetailsDTO;
import lk.zerocode.api.controller.dto.FingerPrintDTO;
import lk.zerocode.api.exceptions.AttendanceException;
import lk.zerocode.api.model.*;
import lk.zerocode.api.repository.*;
import lk.zerocode.api.service.AttendenceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttendenceServiceImpl implements AttendenceService {

    private FingerPrintRepository fingerPrintRepository;
    private AttendenceRepository attendenceRepository;
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    private OtherLeavesRepository otherLeavesRepository;

    @Override
    public ResponseEntity<String> addAttendenceCheckIn(FingerPrintDTO fingerPrintDTO) throws AttendanceException {

        LocalDate today = LocalDate.now();
        LocalTime requiredCheckInSTD = LocalTime.of(17, 20);
        LocalTime requiredCheckOutSTD = LocalTime.of(18, 30);
        LocalTime afterRequiredTimeSTD = LocalTime.of(17, 30);
        LocalTime checkOutEarlySTD = LocalTime.of(18, 0);
        Duration lateTimeSTD = Duration.between(requiredCheckInSTD, LocalTime.now());

        LocalTime requiredCheckInPL = LocalTime.of(13, 40);
        LocalTime requiredCheckOutPL = LocalTime.of(15, 30);
        LocalTime afterRequiredTimePL = LocalTime.of(14, 0);
        LocalTime checkoutEarlyPL = LocalTime.of(15, 15);
        Duration lateTimePL = Duration.between(requiredCheckInPL, LocalTime.now());


        String fId = fingerPrintDTO.getFingerPrintId();

        FingerPrint fingerPrint = fingerPrintRepository.findByFingerPrintId(fId)
                .orElseThrow(() -> new AttendanceException("Employee fingerprint not found!"));

        Employee employee = employeeRepository.findById(fingerPrint.getEmployee().getId()).orElseThrow(
                () -> new AttendanceException("employee not found!")
        );

        String empCategory = employee.getCurrentWorkDetails().getEmpCategory().getEmpCategory();

        Optional<Attendance> existingAttendance = attendenceRepository.findAttendanceByDateAndEmployee(today, fingerPrint.getEmployee());

//        Attendance attendance = new Attendance();

        //checking employee standard or Pl
        if (empCategory.equals("standard")) {

            //checking required time with local.now time
            if (LocalTime.now().isAfter(requiredCheckInSTD) && LocalTime.now().isBefore(afterRequiredTimeSTD)) {
                //checking if attendance already marked
                if (existingAttendance.isPresent()) {

                    Attendance attendance = existingAttendance.get();

                    //check if employee already marked his checkout
                    if (attendance.getActualCheckOut() != null) {

                        throw new AttendanceException("Attendance already marked!");
                    }
                    //avoid employee leave early
                    if (LocalTime.of(18, 00).isBefore(existingAttendance.get().getRequiredCheckOut().minus(5, ChronoUnit.MINUTES))) {

                        return ResponseEntity.status(HttpStatus.CREATED).body("Oyata Yanna denna be, " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
                    }
                    //let employee leave at required checkout time
                    else {
                        attendance.setActualCheckOut(LocalTime.now());
                        attendance.setStatus(Status.APPROVED);

                        attendenceRepository.save(attendance);

                        return ResponseEntity.status(HttpStatus.CREATED).body("Goodbye 1, " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
                    }
                }
                //mark attendance late comers
                else {
                    Attendance attendanceLate = new Attendance();
                    attendanceLate.setDate(LocalDate.now());
                    attendanceLate.setActualCheckIn(LocalTime.now());
                    attendanceLate.setRequiredCheckIn(requiredCheckInSTD);
                    attendanceLate.setRequiredCheckOut(requiredCheckOutSTD.plus(lateTimeSTD));
                    attendanceLate.setEmployee(fingerPrint.getEmployee());
                    attendanceLate.setDayType(String.valueOf(LocalDate.now().getDayOfWeek()));
                    attendanceLate.setStatus(Status.PENDING);

                    attendenceRepository.save(attendanceLate);

                    throw new AttendanceException("Sorry, you are late, " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
                }
            }
            //check attendance too late comers (ex - after 8.30)
            if (LocalTime.now().isAfter(afterRequiredTimeSTD)) {

                if (existingAttendance.isPresent()) {

                    Attendance attendance = existingAttendance.get();

                    if (attendance.getActualCheckOut() != null) {

                        throw new AttendanceException("Attendance already marked!" + "(" + empCategory + ")");
                    }
                    return ResponseEntity.status(HttpStatus.CREATED).body("You can't leave, Meet your head please , " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
                } else {
                    Attendance attendance = new Attendance();
                    attendance.setDate(today);
                    attendance.setActualCheckIn(LocalTime.now());
                    attendance.setRequiredCheckIn(requiredCheckInSTD);
                    attendance.setEmployee(fingerPrint.getEmployee());
                    attendance.setDayType(String.valueOf(LocalDate.now().getDayOfWeek()));
                    attendance.setStatus(Status.PENDING);

                    attendenceRepository.save(attendance);

                    return ResponseEntity.status(HttpStatus.CREATED).body("Sorry, you are too late meet your head please," + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
                }
            }
            if (existingAttendance.isPresent()) {

                Attendance attendance = existingAttendance.get();

                if (attendance.getActualCheckOut() != null) {

                    throw new AttendanceException("Attendance already marked!" + "(" + empCategory + ")");
                }
                //employee can check out early when he comes early
                if (existingAttendance.get().getActualCheckIn().isBefore(requiredCheckInSTD) && LocalTime.of(15, 35).isAfter(checkOutEarlySTD)) {

                    attendance.setActualCheckOut(LocalTime.now());
                    attendance.setStatus(Status.APPROVED);

                    attendenceRepository.save(attendance);

                    return ResponseEntity.status(HttpStatus.CREATED).body("Goodbye2, " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
                } else {
//                    throw new AttendanceException("You are trying to leave early!" + "(" + empCategory + ")");
                    OtherLeave otherLeave = otherLeavesRepository.findByEmployee(employee).orElseThrow(
                            () -> new AttendanceException("muta leave ne")
                    );
                    System.out.println(otherLeave.getId());
                    OtherLeave existingOtherLeave = otherLeavesRepository.findById(otherLeave.getId()).orElseThrow(
                            () -> new AttendanceException("muta attendance id ekk ne")
                    );

                    if (existingOtherLeave.getActualCheckIn() == null) {
                        System.out.println("other leave ekk tynw");
                        existingOtherLeave.setActualCheckOut(LocalTime.now());
                        existingOtherLeave.setActualCheckIn(LocalTime.of(17, 15));

                        otherLeavesRepository.save(existingOtherLeave);

                        throw new AttendanceException("other leave eka set kala");
                    } else {
                        attendance.setActualCheckOut(LocalTime.now());
                        attendance.setStatus(Status.APPROVED);

                        attendenceRepository.save(attendance);

                        throw new AttendanceException("Goodbye other leave ek ethule, " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
                    }
                }


            } else {
                Attendance attendance = new Attendance();
                attendance.setDate(today);
                attendance.setActualCheckIn(LocalTime.now());
                attendance.setRequiredCheckIn(requiredCheckInSTD);
                attendance.setRequiredCheckOut(requiredCheckOutSTD);
                attendance.setEmployee(fingerPrint.getEmployee());
                attendance.setDayType(String.valueOf(LocalDate.now().getDayOfWeek()));
                attendance.setStatus(Status.APPROVED);

                attendenceRepository.save(attendance);

                return ResponseEntity.status(HttpStatus.CREATED).body("Good Morning 8, " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
            }
        } else if (empCategory.equals("pl")) {

            if (LocalTime.now().isAfter(requiredCheckInPL) && LocalTime.now().isBefore(afterRequiredTimePL)) {

                if (existingAttendance.isPresent()) {

                    Attendance attendance = existingAttendance.get();

                    if (attendance.getActualCheckOut() != null) {

                        throw new AttendanceException("Attendance already marked!" + "(" + empCategory + ")");
                    }
                    if (LocalTime.of(14, 35).isBefore(existingAttendance.get().getRequiredCheckOut().minusMinutes(5))) {

                        return ResponseEntity.status(HttpStatus.CREATED).body("Oyata Yanna denna be, " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
                    } else {

                        attendance.setActualCheckOut(LocalTime.now());
                        attendance.setStatus(Status.APPROVED);

                        attendenceRepository.save(attendance);

                        throw new AttendanceException("Goodbye, " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
                    }

                } else {
                    Attendance attendanceLate = new Attendance();
                    attendanceLate.setDate(LocalDate.now());
                    attendanceLate.setActualCheckIn(LocalTime.now());
                    attendanceLate.setRequiredCheckIn(requiredCheckInPL);
                    attendanceLate.setRequiredCheckOut(requiredCheckOutPL.plus(lateTimePL));
                    attendanceLate.setEmployee(fingerPrint.getEmployee());
                    attendanceLate.setDayType(String.valueOf(LocalDate.now().getDayOfWeek()));
                    attendanceLate.setStatus(Status.PENDING);

                    attendenceRepository.save(attendanceLate);

                    throw new AttendanceException("Sorry, you are late, " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
                }

            }
        }

        if (LocalTime.now().isAfter(afterRequiredTimePL)) {

            if (existingAttendance.isPresent()) {

                Attendance attendance = existingAttendance.get();

                if (attendance.getActualCheckOut() != null) {

                    throw new AttendanceException("Attendance already marked!" + "(" + empCategory + ")");
                }

                throw new AttendanceException("You can't leave, Meet your head please , " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
            } else {
                Attendance attendance = new Attendance();
                attendance.setDate(today);
                attendance.setActualCheckIn(LocalTime.now());
                attendance.setRequiredCheckIn(requiredCheckInPL);
                attendance.setEmployee(fingerPrint.getEmployee());
                attendance.setDayType(String.valueOf(LocalDate.now().getDayOfWeek()));
                attendance.setStatus(Status.PENDING);

                attendenceRepository.save(attendance);

                throw new AttendanceException("Sorry, you are too late meet your head please," + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
            }
        }

        if (existingAttendance.isPresent()) {
            Attendance attendance = existingAttendance.get();
            if (attendance.getActualCheckOut() != null) {
                throw new AttendanceException("Attendance already marked!" + "(" + empCategory + ")");
            }
            if (existingAttendance.get().getActualCheckIn().isBefore(requiredCheckInPL) && LocalTime.of(15, 35).isAfter(checkoutEarlyPL)) {
                attendance.setActualCheckOut(LocalTime.now());
                attendance.setStatus(Status.APPROVED);

                attendenceRepository.save(attendance);

                return ResponseEntity.status(HttpStatus.CREATED).body("Goodbye2, " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
            } else {

                throw new AttendanceException("You are trying to leave early!" + "(" + empCategory + ")");
            }
        } else {

            Attendance attendance = new Attendance();
            attendance.setDate(today);
            attendance.setActualCheckIn(LocalTime.now());
            attendance.setRequiredCheckIn(requiredCheckInPL);
            attendance.setRequiredCheckOut(requiredCheckOutPL);
            attendance.setEmployee(fingerPrint.getEmployee());
            attendance.setDayType(String.valueOf(LocalDate.now().getDayOfWeek()));
            attendance.setStatus(Status.APPROVED);

            attendenceRepository.save(attendance);

            throw new AttendanceException("Good Morning, " + "(" + empCategory + ")" + fingerPrint.getEmployee().getFirstName());
        }

    }


    @Override
    public void delete() {

        attendenceRepository.deleteAll();
    }

//    @Override
//    public ResponseEntity<List<Attendance>> getAllByDate(AttandanceSearchDTO attandanceSearchDTO) throws AttendanceException {
//
//        LocalDate date = LocalDate.parse(attandanceSearchDTO.getDate());
//        List<Attendance> attendanceList = attendenceRepository.findByDate(date);
//        if (attendanceList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if no records found
//        }
//        return new ResponseEntity<>(attendanceList, HttpStatus.OK);
//    }

    @Override
    public AttendanceDTO findByEmpId(Long id) throws AttendanceException {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new AttendanceException("employee ne")
        );
        Attendance attendance = attendenceRepository.findAttendanceByEmployee(employee).orElseThrow(
                () -> new AttendanceException("attendance ek ne")
        );

        AttendanceDTO attendanceDTO = modelMapper.map(attendance, AttendanceDTO.class);
        System.out.println(attendanceDTO.getDate());
        return attendanceDTO;
    }

    @Override
    public List<AttendanceDTO> getAll() throws AttendanceException {
        List<Attendance> attendanceDTOList = attendenceRepository.findAll();
        if (attendanceDTOList.isEmpty()) {
            throw new AttendanceException("attendance ne");
        }
        return modelMapper.map(attendanceDTOList, new TypeToken<List<AttendanceDTO>>() {
        }.getType());
    }

    @Override
    public List<AttendanceDTO> findByDate(AttandanceSearchDTO attandanceSearchDTO) throws AttendanceException {

        List<Attendance> attendanceList = attendenceRepository.findByDate(attandanceSearchDTO.getDate());

        if (attendanceList.isEmpty()) {
            throw new AttendanceException("attendance eka ne");
        }
        return modelMapper.map(attendanceList, new TypeToken<List<AttendanceDTO>>() {
        }.getType());
    }

    @Override
    public void deleteFullday() {
        otherLeavesRepository.deleteAll();
    }


}
