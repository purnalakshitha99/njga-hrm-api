package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.WorkDetailRequest;
import lk.zerocode.api.controller.response.WorkDetailResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.service.WorkDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
//@RequestMapping("/employees")
public class WorkDetailController {

    private WorkDetailService workDetailService;
    @PostMapping("/employees/{emp_id}/work_details")
    public WorkDetailResponse save(@PathVariable("emp_id")String empId, @RequestBody WorkDetailRequest workDetailRequest)throws EmployeeNotFoundException {

        System.out.println("work details save");

        return workDetailService.save(empId,workDetailRequest);

    }




}
