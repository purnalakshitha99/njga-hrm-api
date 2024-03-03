package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.Testrq;
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

    @PostMapping("/time/test")
    public void testinTime(@RequestBody Testrq testrq){
        testService.testTime(testrq);
    }

    @GetMapping("/time/display")
    public void getDay(){
        testService.getDayByMonth();
    }
}
