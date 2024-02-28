package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.AttendenceRequest;
import lk.zerocode.api.controller.response.Test;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.*;
import lk.zerocode.api.repository.AttendenceRepository;
import lk.zerocode.api.repository.FingerPrintRepository;
import lk.zerocode.api.service.AttendenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttendenceImpl implements AttendenceService {

    private FingerPrintRepository fingerPrintRepository;
    private AttendenceRepository attendenceRepository;


    @Override
    public ResponseEntity<String> addAttendenceCheckIn(AttendenceRequest attendenceRequest)throws EmployeeNotFoundException {

        LocalDate today = LocalDate.now();
        LocalTime requierdCheckIn = LocalTime.of(8,00);
        LocalTime requierdCheckOut = LocalTime.of(16,00);


        FingerPrint fingerPrint = fingerPrintRepository.findByFingerPrintId(attendenceRequest.getFingerPrintId()).orElseThrow(
                () -> new EmployeeNotFoundException("Employee finger print not found !")
        );

        if (LocalTime.now().isAfter(requierdCheckIn)){

            Attendance attendanceLate = new Attendance();

            attendanceLate.setDate(LocalDate.now());
            attendanceLate.setActualCheckIn(LocalTime.now());
            attendanceLate.setRequiredCheckIn(requierdCheckIn);
            attendanceLate.setRequiredCheckOut(requierdCheckOut);
            attendanceLate.setEmployee(fingerPrint.getEmployee());
            attendanceLate.setStatus(Status.PENDING);

            attendenceRepository.save(attendanceLate);
            throw new EmployeeNotFoundException("Sorry!, You are Late," +fingerPrint.getEmployee().getFirstName());
        }else {
            if (attendenceRepository.findAttendanceByDateAndEmployee(today, fingerPrint.getEmployee()).isPresent()) {
//                throw new EmployeeNotFoundException("Attendance already marked!");

                FingerPrint fingerPrintOut = fingerPrintRepository.findByFingerPrintId(attendenceRequest.getFingerPrintId()).orElseThrow(
                        () -> new EmployeeNotFoundException("Employee finger print not found !")
                );
                Attendance attendance = attendenceRepository.findAttendanceByEmployee(fingerPrint.getEmployee())
                        .orElseThrow(() -> new EmployeeNotFoundException("Attendance not found!"));


                if (attendance.getActualCheckOut() != null) {
                    throw new EmployeeNotFoundException("Attendance already marked!");
                }

                attendance.setActualCheckOut(LocalTime.now());
                attendenceRepository.save(attendance);

                return ResponseEntity.status(HttpStatus.CREATED).body("Good Bye, " + fingerPrintOut.getEmployee().getFirstName());
            }else
            {
                Attendance attendance = new Attendance();

                attendance.setDate(LocalDate.now());
                attendance.setActualCheckIn(LocalTime.now());
                attendance.setRequiredCheckIn(requierdCheckIn);
                attendance.setRequiredCheckOut(requierdCheckOut);
                attendance.setEmployee(fingerPrint.getEmployee());

                attendenceRepository.save(attendance);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Good Morning, " +fingerPrint.getEmployee().getFirstName());
        }


    }

    @Override
    public ResponseEntity<String> addAttendenceCheckOut(AttendenceRequest attendenceRequest)throws EmployeeNotFoundException {


        FingerPrint fingerPrint = fingerPrintRepository.findByFingerPrintId(attendenceRequest.getFingerPrintId()).orElseThrow(
                () -> new EmployeeNotFoundException("Employee finger print not found !")
        );
        Attendance attendance = attendenceRepository.findAttendanceByEmployee(fingerPrint.getEmployee())
                .orElseThrow(() -> new EmployeeNotFoundException("Attendance not found!"));


        if (attendance.getActualCheckOut() != null) {
            throw new EmployeeNotFoundException("Attendance already marked!");
        }

        attendance.setActualCheckOut(LocalTime.now());
        attendenceRepository.save(attendance);

        return ResponseEntity.status(HttpStatus.CREATED).body("Good Bye, " + fingerPrint.getEmployee().getFirstName());
    }


    @Override
    public void delete() {

        attendenceRepository.deleteAll();
    }
}
