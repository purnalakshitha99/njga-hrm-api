package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.AttendenceRequest;
import lk.zerocode.api.controller.request.Testrq;
import lk.zerocode.api.exceptions.AttendanceException;
import org.springframework.stereotype.Service;

@Service
public interface TestService {


    void saveDate(Testrq testrq);

    void getAttCount(AttendenceRequest attendenceRequest) throws AttendanceException;
}
