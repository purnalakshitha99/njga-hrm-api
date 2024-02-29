package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.Testrq;
import org.springframework.stereotype.Service;

@Service
public interface TestService {

    void testTime(Testrq testrq);
}
