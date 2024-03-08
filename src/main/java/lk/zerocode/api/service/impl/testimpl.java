package lk.zerocode.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lk.zerocode.api.controller.dto.AttendanceDTO;
import lk.zerocode.api.controller.request.AttendenceRequest;
import lk.zerocode.api.controller.request.Testrq;
import lk.zerocode.api.exceptions.AttendanceException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Attendance;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.FingerPrint;
import lk.zerocode.api.model.Test;
import lk.zerocode.api.repository.AttendenceRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.repository.FingerPrintRepository;
import lk.zerocode.api.repository.TestRepository;
import lk.zerocode.api.service.TestService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class testimpl implements TestService {

    private TestRepository testRepository;
    private FingerPrintRepository fingerPrintRepository;
    private AttendenceRepository attendenceRepository;
    private EmployeeRepository employeeRepository;
    @Override
    public void testTime(Testrq testrq) {

        Test test = new Test();
        test.setDate(testrq.getDates());
        testRepository.save(test);


    }

    @Override
    public void getDayByMonth() {

        List<Test> allDates = testRepository.findAll();
        System.out.println(allDates);
        List<Test> results = new ArrayList<>();
        System.out.println(LocalDate.now().getMonth());
        LocalDate month ;

        for (Test test:allDates
             ) {
            if (allDates.equals("FEBRUARY")){
                results.add(test);
                System.out.println(results);
            }
        }

    }

    @Override
    public void getFid(AttendenceRequest attendenceRequest) {

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());

        String month = String.valueOf(LocalDate.now().getMonth());
        System.out.println(month);

        Integer day = Integer.valueOf(LocalDate.now().getDayOfMonth());
        System.out.println(day);

        LocalTime tomorow = LocalTime.of(14,50);

        Duration betweenNow = Duration.between(LocalTime.now(), tomorow);
        System.out.println(betweenNow);

    }

    public void testAttandance(AttendenceRequest attendenceRequest)throws AttendanceException {
        LocalDate today = LocalDate.now();
        LocalTime requiredCheckInSTD = LocalTime.of(13, 0);
        LocalTime requiredCheckOutSTD = LocalTime.of(14, 30);
        LocalTime afterRequiredTimeSTD = LocalTime.of(13, 30);
        LocalTime checkOutEarlySTD = LocalTime.of(14, 0);
        Duration lateTimeSTD = Duration.between(requiredCheckInSTD, LocalTime.now());

        LocalTime requiredCheckInPL = LocalTime.of(13, 40);
        LocalTime requiredCheckOutPL = LocalTime.of(15, 30);
        LocalTime afterRequiredTimePL = LocalTime.of(14, 0);
        LocalTime checkoutEarlyPL = LocalTime.of(15, 15);
        Duration lateTimePL = Duration.between(requiredCheckInPL, LocalTime.now());


        String fId = attendenceRequest.getFingerPrintId();

        FingerPrint fingerPrint = fingerPrintRepository.findByFingerPrintId(fId)
                .orElseThrow(() -> new AttendanceException("Employee fingerprint not found!"));

        Employee employee = employeeRepository.findById(fingerPrint.getEmployee().getId()).orElseThrow(
                () -> new AttendanceException("employee not found!")
        );

        String empCategory = employee.getCurrentWorkDetails().getEmpCategory().getEmpCategory();

        Optional<Attendance> existingAttendanceOpt = attendenceRepository.findAttendanceByDateAndEmployee(today, fingerPrint.getEmployee());

        Attendance attendance = new Attendance();

        //checking employee standard or Pl
        if (empCategory.equals("standard")) {
        }
    }
}
