package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.Testrq;
import lk.zerocode.api.model.Test;
import lk.zerocode.api.repository.TestRepository;
import lk.zerocode.api.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class testimpl implements TestService {

    private TestRepository testRepository;
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
}
