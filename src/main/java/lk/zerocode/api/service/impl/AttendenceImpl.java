package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.AttendenceRequest;
import lk.zerocode.api.controller.response.Test;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Attendance;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.FingerPrint;
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
        String fId = attendenceRequest.getFingerPrintId();
        LocalDate today = LocalDate.now();
        LocalTime requierdCheckIn = LocalTime.of(8,00);
        LocalTime requierdCheckOut = LocalTime.of(16,00);

        fingerPrintRepository.findByFingerPrintId(fId).orElseThrow(
                () -> new EmployeeNotFoundException("Employee finger print not found !")
        );

        Optional<FingerPrint> fingerPrintOpt = fingerPrintRepository.findByFingerPrintId(fId);
        FingerPrint fingerPrint = fingerPrintOpt.get();

        Optional<Attendance> attendanceOpt = attendenceRepository.findAttendanceByDateAndEmployee(LocalDate.now(),fingerPrint.getEmployee());
        if (!attendanceOpt.isPresent()){
            Attendance attendance = new Attendance();

            attendance.setDate(LocalDate.now());
            attendance.setActualCheckIn(LocalTime.now());
            attendance.setRequiredCheckIn(requierdCheckIn);
            attendance.setRequiredCheckOut(requierdCheckOut);
            attendance.setEmployee(fingerPrint.getEmployee());

            attendenceRepository.save(attendance);
        }else {
            throw new EmployeeNotFoundException("Attendance already marked!");
        }



        return ResponseEntity.status(HttpStatus.CREATED).body("Good Morning, " +fingerPrint.getEmployee().getFirstName());
    }
    @Override
    public ResponseEntity<String> addAttendenceCheckOut(AttendenceRequest attendenceRequest)throws EmployeeNotFoundException {
        String fId = attendenceRequest.getFingerPrintId();

        fingerPrintRepository.findByFingerPrintId(fId).orElseThrow(
                () -> new EmployeeNotFoundException("Employee finger print not found !")
        );

        Optional<FingerPrint> fingerPrintOpt = fingerPrintRepository.findByFingerPrintId(fId);
        FingerPrint fingerPrint = fingerPrintOpt.get();

        Optional<Attendance> attendanceOpt = attendenceRepository.findAttendanceByEmployee(fingerPrint.getEmployee());
        if (attendanceOpt.get().getActualCheckOut() == null){
            Attendance attendance = attendanceOpt.get();
            attendance.setActualCheckOut(LocalTime.now());

            attendenceRepository.save(attendance);
        }else {
            throw new EmployeeNotFoundException("Mu gihin yako");
        }


        return ResponseEntity.status(HttpStatus.CREATED).body("Good Bye, "+fingerPrint.getEmployee().getFirstName());
    }


    @Override
    public void delete() {

        attendenceRepository.deleteAll();
    }
}
