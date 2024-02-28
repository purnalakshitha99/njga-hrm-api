package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.CurrentWorkDetailRequest;
import lk.zerocode.api.controller.response.IdResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.CurrentWorkDetail;
import lk.zerocode.api.service.CurrentWorkDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CurrentWorkDetailController {

    private CurrentWorkDetailService currentWorkDetailService;


    @PostMapping("/employees/{emp_id}/current_work_details")
    public void saveWorkDetail(@PathVariable("emp_id")Long empId,@RequestBody CurrentWorkDetailRequest currentWorkDetailRequest)throws EmployeeNotFoundException {

        System.out.println("branch"+currentWorkDetailRequest.getBranchCode());
        System.out.println("category"+currentWorkDetailRequest.getEmpCategoryId());
        System.out.println("emp"+empId);
        System.out.println("depID"+currentWorkDetailRequest.getDepId());

        currentWorkDetailService.saveWorkDetail(empId,currentWorkDetailRequest);
    }


}
