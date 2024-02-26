package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.AttendenceRequest;
import lk.zerocode.api.model.Attendance;
import lk.zerocode.api.model.FingerPrint;
import lk.zerocode.api.service.AttendenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class AttendenceImpl implements AttendenceService {

    private

    private LocalTime stCheckIng = LocalTime.of(8,00);
    private LocalTime stCheckOut = LocalTime.of(16,15);
    private LocalTime plCheckIng = LocalTime.of(8,00);
    private LocalTime plCheckOut = LocalTime.of(16,45);
    @Override
    public ResponseEntity<String> saveAttendence(AttendenceRequest attendenceRequest) {

        FingerPrint fingerPrint =

        Attendance attendance = new Attendance();
        attendance.setDate(LocalDate.now());
        attendance.setActualCheckIn(LocalTime.now());

    }
}
