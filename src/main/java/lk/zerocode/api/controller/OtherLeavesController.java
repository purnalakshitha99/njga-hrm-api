package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.service.OtherLeavesService;
import lk.zerocode.api.service.StandardOtherLeavesHalfDayService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OtherLeavesController {

    StandardOtherLeavesHalfDayService standardOtherLeavesHalfDayService;

    @PostMapping("employees/{emp-id}/currentworks/{work-id}/otherleaves")
    public List<OtherLeavesResponse> createStandardOtherLeave(@PathVariable("emp-id") Long empId, @PathVariable("work-id") Long wId,@RequestBody OtherLeavesRequest otherLeavesRequest) throws EmployeeNotFoundException {
        return standardOtherLeavesHalfDayService.createStandardHalfDayLeaves(empId,wId,otherLeavesRequest);
    }

}
