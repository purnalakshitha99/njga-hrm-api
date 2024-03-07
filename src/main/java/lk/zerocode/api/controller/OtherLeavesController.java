package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.exceptions.CannotCreateLeaveException;
import lk.zerocode.api.exceptions.EmpCategoryNotFoundException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.service.OtherLeavesService;
import lk.zerocode.api.service.StandardOtherLeavesHalfDayService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class OtherLeavesController {


    private OtherLeavesService otherLeavesService;



    @PostMapping("/employees/{emp_id}/other_leaves")
    public OtherLeavesResponse createLeave(@PathVariable("emp_id")Long empId,@RequestBody OtherLeavesRequest otherLeavesRequest)throws EmployeeNotFoundException, EmpCategoryNotFoundException, CannotCreateLeaveException {
        System.out.println("controller athule");
        System.out.println("controller eke hours : "+otherLeavesRequest.getHours());
      return  otherLeavesService.createLeave(empId,otherLeavesRequest);

    }

}
