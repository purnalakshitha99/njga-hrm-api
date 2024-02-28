package lk.zerocode.api.controller;

import lk.zerocode.api.model.CurrentWorkDetail;
import lk.zerocode.api.service.CurrentWorkDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrentWorkDetailController {

    private CurrentWorkDetailService currentWorkDetailService;
//    @PostMapping("/employees/{emp_id}/current_work_details")
//    public void saveWorkDetail(@PathVariable("emp_id")Long empId, @RequestBody CurrentWorkDetailRequest currentWorkDetailRequest, @RequestBody BranchRequest branchRequest, @RequestBody DepartmentRequest departmentRequest, @RequestBody EmpCategoryRequest empCategoryRequest){
//
//        currentWorkDetailService.saveWorkDetail(empId,currentWorkDetailRequest,branchRequest,departmentRequest,empCategoryRequest);
//    }

    @PostMapping("/employees/{emp_id}/current_work_details")
    public void saveWorkDetail(@PathVariable("emp_id")Long empId, @RequestBody CurrentWorkDetail currentWorkDetail){

        currentWorkDetailService.addCurrent(empId,currentWorkDetail);
    }
}
