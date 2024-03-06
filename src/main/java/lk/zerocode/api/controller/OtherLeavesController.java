package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.service.OtherLeavesService;
import lk.zerocode.api.service.StandardOtherLeavesHalfDayService;
import lk.zerocode.api.service.impl.StandardOtherLeavesHalfDayServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OtherLeavesController {

    StandardOtherLeavesHalfDayService standardOtherLeavesHalfDayService;


    @PostMapping("employees/currentworks/{emp-id}/otherleaves")
    public String createStandardOtherLeave(@PathVariable("emp-id") Long empId,@RequestBody OtherLeavesRequest otherLeavesRequest) throws EmployeeNotFoundException {
        return standardOtherLeavesHalfDayService.createStandardHalfDayLeaves(empId,otherLeavesRequest);
    }

}
