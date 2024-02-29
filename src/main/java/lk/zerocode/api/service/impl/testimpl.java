package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.Testrq;
import lk.zerocode.api.service.TestService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Service
public class testimpl implements TestService {
    @Override
    public void testTime(Testrq testrq) {

        LocalTime requiredCheckOut = LocalTime.of(8,0);
//        LocalTime nowTime = LocalTime.of(8,5);

        if (requiredCheckOut.isBefore(testrq.getNowTime()) || testrq.getNowTime().isAfter(requiredCheckOut.minus(3, ChronoUnit.MINUTES)) ){
            System.out.println("you can leave");
        }else {
            System.out.println("cant leave");
        }
    }
}
