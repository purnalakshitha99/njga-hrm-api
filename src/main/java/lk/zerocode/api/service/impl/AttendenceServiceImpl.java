package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.AttendenceRequest;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.*;
import lk.zerocode.api.repository.*;
import lk.zerocode.api.service.AttendenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttendenceServiceImpl implements AttendenceService {

    private FingerPrintRepository fingerPrintRepository;
    private AttendenceRepository attendenceRepository;
    private EmployeeRepository employeeRepository;
    private CurrentWorkDetailRepository currentWorkDetailRepository;
    private EmpCategoryRepository empCategoryRepository;


    @Override
    public ResponseEntity<String> addAttendenceCheckIn(AttendenceRequest attendenceRequest) throws EmployeeNotFoundException {

        LocalDate today = LocalDate.now();
        LocalTime requiredCheckInSTD = LocalTime.of(12, 00);
        LocalTime requiredCheckOutSTD = LocalTime.of(12, 05);
        LocalTime afterRequiredTimeSTD = LocalTime.of(12, 20);
        Duration lateTimeSTD = Duration.between(requiredCheckInSTD, LocalTime.now());

        LocalTime requiredCheckInPL = LocalTime.of(13, 0);
        LocalTime requiredCheckOutPL = LocalTime.of(16, 00);
        LocalTime afterRequiredTimePL = LocalTime.of(13, 45);
        Duration lateTimePL = Duration.between(requiredCheckInSTD, LocalTime.now());

        String fId = attendenceRequest.getFingerPrintId();

        System.out.println("fid" +attendenceRequest.getFingerPrintId());
        FingerPrint fingerPrint = fingerPrintRepository.findByFingerPrintId(fId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee fingerprint not found!"));
        System.out.println("empId" + fingerPrint.getEmployee().getId());

        Employee employee = employeeRepository.findById(fingerPrint.getEmployee().getId()).orElseThrow(
                () -> new EmployeeNotFoundException("employee not found!")
        );

        String empCategory = employee.getCurrentWorkDetails().getEmpCategory().getEmpCategory();

        Optional<Attendance> existingAttendance = attendenceRepository.findAttendanceByDateAndEmployee(today, fingerPrint.getEmployee());

        if (empCategory.equals("standard")) {

            if (LocalTime.now().isAfter(requiredCheckInSTD) && LocalTime.now().isBefore(afterRequiredTimeSTD)) {

                if (existingAttendance.isPresent()) {

                    Attendance attendance = existingAttendance.get();

                    if (attendance.getActualCheckOut() != null) {

                        throw new EmployeeNotFoundException("Attendance already marked!");
                    }
                    if (LocalTime.of(12,20).isBefore(existingAttendance.get().getRequiredCheckOut())) {

                        return ResponseEntity.status(HttpStatus.CREATED).body("Oyata Yanna denna be, "+"("+ empCategory+")" + fingerPrint.getEmployee().getFirstName());
                    } else {

                            attendance.setActualCheckOut(LocalTime.now());
                            attendance.setStatus(Status.APPROVED);
                            attendenceRepository.save(attendance);
                            return ResponseEntity.status(HttpStatus.CREATED).body("Goodbye, "+"("+ empCategory+")" + fingerPrint.getEmployee().getFirstName());
                    }

                } else {
                    Attendance attendanceLate = new Attendance();
                    attendanceLate.setDate(LocalDate.now());
                    attendanceLate.setActualCheckIn(LocalTime.now());
                    attendanceLate.setRequiredCheckIn(requiredCheckInSTD);
                    attendanceLate.setRequiredCheckOut(requiredCheckOutSTD.plus(lateTimeSTD));
                    attendanceLate.setEmployee(fingerPrint.getEmployee());
                    attendanceLate.setStatus(Status.PENDING);
                    attendenceRepository.save(attendanceLate);
                    throw new EmployeeNotFoundException("Sorry, you are late, "+"("+ empCategory+")" + fingerPrint.getEmployee().getFirstName());
                }

            }

            if (LocalTime.now().isAfter(afterRequiredTimeSTD)) {
                if (existingAttendance.isPresent()) {
                    Attendance attendance = existingAttendance.get();
                    if (attendance.getActualCheckOut() != null) {
                        throw new EmployeeNotFoundException("Attendance already marked!"+"("+ empCategory+")");
                    }
                    return ResponseEntity.status(HttpStatus.CREATED).body("standard You can't leave, Meet your head please , "+"("+ empCategory+")"  + fingerPrint.getEmployee().getFirstName());
                } else {
                    Attendance attendance = new Attendance();
                    attendance.setDate(today);
                    attendance.setActualCheckIn(LocalTime.now());
                    attendance.setRequiredCheckIn(requiredCheckInSTD);
                    attendance.setEmployee(fingerPrint.getEmployee());
                    attendance.setStatus(Status.PENDING);
                    attendenceRepository.save(attendance);
                    return ResponseEntity.status(HttpStatus.CREATED).body("Sorry, you are too late meet your head please,"+"("+empCategory+")" + fingerPrint.getEmployee().getFirstName());
                }
            }


            if (existingAttendance.isPresent()) {
                Attendance attendance = existingAttendance.get();
                if (attendance.getActualCheckOut() != null) {
                    throw new EmployeeNotFoundException("Attendance already marked!"+"("+ empCategory+")");
                }
                if (LocalTime.now().isBefore(existingAttendance.get().getRequiredCheckOut())){
                    attendance.setActualCheckOut(LocalTime.now());
                    attendance.setStatus(Status.PENDING);
                    attendenceRepository.save(attendance);
                    throw new EmployeeNotFoundException("You are trying to leave early!"+"("+ empCategory+")");
                }

            } else {
                Attendance attendance = new Attendance();
                attendance.setDate(today);
                attendance.setActualCheckIn(LocalTime.now());
                attendance.setRequiredCheckIn(requiredCheckInSTD);
                attendance.setRequiredCheckOut(requiredCheckOutSTD);
                attendance.setEmployee(fingerPrint.getEmployee());
                attendance.setStatus(Status.APPROVED);
                attendenceRepository.save(attendance);
                return ResponseEntity.status(HttpStatus.CREATED).body("Good Morning, "+"("+ empCategory+")" + fingerPrint.getEmployee().getFirstName());
            }
        } else if (empCategory.equals("pl")) {

            if (LocalTime.now().isAfter(requiredCheckInPL) && LocalTime.now().isBefore(afterRequiredTimePL)) {

                if (existingAttendance.isPresent()) {
                    Attendance attendance = existingAttendance.get();
                    if (attendance.getActualCheckOut() != null) {
                        throw new EmployeeNotFoundException("Attendance already marked!"+"("+ empCategory+")");
                    }
                    if (LocalTime.of(12,20).isBefore(existingAttendance.get().getRequiredCheckOut())) {
                        return ResponseEntity.status(HttpStatus.CREATED).body("Oyata Yanna denna be, "+"("+ empCategory+")" + fingerPrint.getEmployee().getFirstName());
                    } else {
                        attendance.setActualCheckOut(LocalTime.now());
                        attendance.setStatus(Status.APPROVED);
                        attendenceRepository.save(attendance);
                        return ResponseEntity.status(HttpStatus.CREATED).body("Goodbye, "+"("+ empCategory+")"  + fingerPrint.getEmployee().getFirstName());

                    }

                } else {
                    Attendance attendanceLate = new Attendance();
                    attendanceLate.setDate(LocalDate.now());
                    attendanceLate.setActualCheckIn(LocalTime.now());
                    attendanceLate.setRequiredCheckIn(requiredCheckInPL);
                    attendanceLate.setRequiredCheckOut(requiredCheckOutPL.plus(lateTimePL));
                    attendanceLate.setEmployee(fingerPrint.getEmployee());
                    attendanceLate.setStatus(Status.PENDING);
                    attendenceRepository.save(attendanceLate);
                    throw new EmployeeNotFoundException("Sorry, you are late, "+"("+ empCategory+")" + fingerPrint.getEmployee().getFirstName());
                }

            }

            if (LocalTime.now().isAfter(afterRequiredTimePL)) {
                if (existingAttendance.isPresent()) {
                    Attendance attendance = existingAttendance.get();
                    if (attendance.getActualCheckOut() != null) {
                        throw new EmployeeNotFoundException("Attendance already marked!"+"("+ empCategory+")");
                    }
                    return ResponseEntity.status(HttpStatus.CREATED).body("You can't leave, Meet your head please , "+"("+ empCategory+")" + fingerPrint.getEmployee().getFirstName());
                } else {
                    Attendance attendance = new Attendance();
                    attendance.setDate(today);
                    attendance.setActualCheckIn(LocalTime.now());
                    attendance.setRequiredCheckIn(requiredCheckInPL);
                    attendance.setEmployee(fingerPrint.getEmployee());
                    attendance.setStatus(Status.PENDING);
                    attendenceRepository.save(attendance);
                    return ResponseEntity.status(HttpStatus.CREATED).body("pl Sorry, you are too late meet your head please," + fingerPrint.getEmployee().getFirstName());
                }
            }


            if (existingAttendance.isPresent()) {
                Attendance attendance = existingAttendance.get();
                if (attendance.getActualCheckOut() != null) {
                    throw new EmployeeNotFoundException("Attendance already marked!"+"("+ empCategory+")");
                }
                if (LocalTime.now().isBefore(existingAttendance.get().getRequiredCheckOut())){
                    attendance.setStatus(Status.PENDING);
                    attendenceRepository.save(attendance);
                    throw new EmployeeNotFoundException("You are trying to leave early!"+"("+ empCategory+")");
                }

                return ResponseEntity.status(HttpStatus.CREATED).body("Goodbye, "+"("+ empCategory+")" + fingerPrint.getEmployee().getFirstName());
            } else {
                Attendance attendance = new Attendance();
                attendance.setDate(today);
                attendance.setActualCheckIn(LocalTime.now());
                attendance.setRequiredCheckIn(requiredCheckInPL);
                attendance.setRequiredCheckOut(requiredCheckOutPL);
                attendance.setEmployee(fingerPrint.getEmployee());
                attendance.setStatus(Status.APPROVED);
                attendenceRepository.save(attendance);
                return ResponseEntity.status(HttpStatus.CREATED).body("Good Morning, "+"("+ empCategory+")" + fingerPrint.getEmployee().getFirstName());
            }
        }
return null;
    }


    @Override
    public void delete() {

        attendenceRepository.deleteAll();
    }
}
