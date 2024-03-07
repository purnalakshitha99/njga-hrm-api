package lk.zerocode.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lk.zerocode.api.controller.request.AttendenceRequest;
import lk.zerocode.api.controller.request.Testrq;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.FingerPrint;
import lk.zerocode.api.model.Test;
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

@Service
@AllArgsConstructor
public class testimpl implements TestService {

    private TestRepository testRepository;
    private ModelMapper modelMapper;
    private FingerPrintRepository fingerPrintRepository;
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
}
