package lk.zerocode.api.controller;

import lk.zerocode.api.controller.dto.OtherLeavesDTO;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.exceptions.CannotCreateLeaveException;
import lk.zerocode.api.exceptions.EmpCategoryNotFoundException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.service.OtherLeavesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OtherLeavesController {


    private OtherLeavesService otherLeavesService;



    @PostMapping("/employees/{emp_id}/other_leaves")
    public OtherLeavesResponse createLeave(@PathVariable("emp_id")Long empId,@RequestBody OtherLeavesDTO otherLeavesDTO)throws EmployeeNotFoundException, EmpCategoryNotFoundException, CannotCreateLeaveException {

        System.out.println(otherLeavesDTO.getWantedTime());
      return  otherLeavesService.createLeave(empId,otherLeavesDTO);

    }

    @GetMapping("/employees/{emp_id}/other_leaves")
    public List <OtherLeavesResponse> getLeaves(@PathVariable("emp_id")Long empId)throws EmployeeNotFoundException{

        return otherLeavesService.getLeaves(empId);
    }

//    @GetMapping("/employees/{emp_id}/other_leaves/")
//   public List <OtherLeavesResponse> getSpecificLeaves(@PathVariable )

    @DeleteMapping("/other_leaves")
    public void deleteAll(){
        otherLeavesService.deleteAll();
    }

}
