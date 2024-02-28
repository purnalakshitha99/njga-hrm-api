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

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttendenceImpl implements AttendenceService {

    private FingerPrintRepository fingerPrintRepository;
    private AttendenceRepository attendenceRepository;


    @Override
    public ResponseEntity<String> addAttendenceCheckIn(AttendenceRequest attendenceRequest) throws EmployeeNotFoundException {

        LocalDate today = LocalDate.now();
        LocalTime requiredCheckIn = LocalTime.of(14, 00);
        LocalTime requiredCheckOut = LocalTime.of(15, 00);
        LocalTime afterRequiredTime = LocalTime.of(14, 30);

        FingerPrint fingerPrint = fingerPrintRepository.findByFingerPrintId(attendenceRequest.getFingerPrintId())
                .orElseThrow(() -> new EmployeeNotFoundException("Employee fingerprint not found!"));

        if (LocalTime.now().isAfter(requiredCheckIn)) {

            Duration lateTime = Duration.between(requiredCheckIn, LocalTime.now());

            Optional<Attendance> existingAttendance = attendenceRepository.findAttendanceByDateAndEmployee(today, fingerPrint.getEmployee());
            if (existingAttendance.isPresent()) {
                Attendance attendance = existingAttendance.get();
                if (attendance.getActualCheckOut() != null) {
                    throw new EmployeeNotFoundException("Attendance already marked!");
                }
                if (existingAttendance.get().getRequiredCheckOut().isAfter(LocalTime.of(18,00))){
                    return ResponseEntity.status(HttpStatus.CREATED).body("Oyata Yanna denna be, " + fingerPrint.getEmployee().getFirstName());
                }
                else {
                    attendance.setActualCheckOut(LocalTime.now());
                    attendance.setStatus(Status.APPROVED);
                    attendenceRepository.save(attendance);
                    return ResponseEntity.status(HttpStatus.CREATED).body("Goodbye, " + fingerPrint.getEmployee().getFirstName());

                }

            } else {
                Attendance attendanceLate = new Attendance();
                attendanceLate.setDate(LocalDate.now());
                attendanceLate.setActualCheckIn(LocalTime.now());
                attendanceLate.setRequiredCheckIn(requiredCheckIn);
                attendanceLate.setRequiredCheckOut(requiredCheckOut.plus(lateTime));
                attendanceLate.setEmployee(fingerPrint.getEmployee());
                attendanceLate.setStatus(Status.PENDING);
                attendenceRepository.save(attendanceLate);
                throw new EmployeeNotFoundException("Sorry, you are late, " + fingerPrint.getEmployee().getFirstName());
            }
        }

        Optional<Attendance> existingAttendance = attendenceRepository.findAttendanceByDateAndEmployee(today, fingerPrint.getEmployee());

        if (existingAttendance.isPresent()) {
            Attendance attendance = existingAttendance.get();
            if (attendance.getActualCheckOut() != null) {
                throw new EmployeeNotFoundException("Attendance already marked!");
            }
            attendance.setActualCheckOut(LocalTime.now());
            attendenceRepository.save(attendance);
            return ResponseEntity.status(HttpStatus.CREATED).body("Goodbye, " + fingerPrint.getEmployee().getFirstName());
        } else {
            Attendance attendance = new Attendance();
            attendance.setDate(today);
            attendance.setActualCheckIn(LocalTime.now());
            attendance.setRequiredCheckIn(requiredCheckIn);
            attendance.setRequiredCheckOut(requiredCheckOut);
            attendance.setEmployee(fingerPrint.getEmployee());
            attendance.setStatus(Status.APPROVED);
            attendenceRepository.save(attendance);
            return ResponseEntity.status(HttpStatus.CREATED).body("Good Morning, " + fingerPrint.getEmployee().getFirstName());
        }
    }


    @Override
    public void delete() {

        attendenceRepository.deleteAll();
    }
}
