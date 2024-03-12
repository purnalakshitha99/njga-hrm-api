package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.AttendenceRequest;
import lk.zerocode.api.controller.request.Testrq;
import lk.zerocode.api.exceptions.AttendanceException;
import lk.zerocode.api.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {

    private TestService testService;

    @PostMapping("/test")
    public void testSave(@RequestBody Testrq testrq){
        testService.saveDate(testrq);
    }

    @GetMapping("/attendancecount")
    public void getCount(@RequestBody AttendenceRequest attendenceRequest) throws AttendanceException {
        testService.getAttCount(attendenceRequest);
    }
}
