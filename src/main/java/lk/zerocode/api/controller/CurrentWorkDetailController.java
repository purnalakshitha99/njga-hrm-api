package lk.zerocode.api.controller;

import lk.zerocode.api.controller.dto.CurrentWorkDetailsDTO;
import lk.zerocode.api.controller.request.CurrentWorkDetailRequest;
import lk.zerocode.api.controller.response.CurrentWorkDetailResponse;
import lk.zerocode.api.controller.response.IdResponse;
import lk.zerocode.api.exceptions.*;
import lk.zerocode.api.model.CurrentWorkDetail;
import lk.zerocode.api.service.CurrentWorkDetailService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CurrentWorkDetailController {

    private CurrentWorkDetailService currentWorkDetailService;
    private ModelMapper modelMapper;

    @PostMapping("/employees/{emp_id}/current_work_details")
    public ResponseEntity<CurrentWorkDetailsDTO> saveWorkDetail(@PathVariable("emp_id")Long empId, @RequestBody CurrentWorkDetailRequest currentWorkDetailRequest)throws EmployeeNotFoundException, BranchNotFoundException, DepartmentNotFoundException, EmpCategoryNotFoundException {

        CurrentWorkDetailsDTO currentWorkDetailsDTO = modelMapper.map(currentWorkDetailRequest,CurrentWorkDetailsDTO.class);
//        System.out.println("branchvvvvvvvvvvvvvvv"+currentWorkDetailsDTO.getWorkTelephone());
//        System.out.println("category"+currentWorkDetailsDTO.getEmpCategoryId());
//
//        System.out.println("emp"+empId);
//        System.out.println("empcode"+currentWorkDetailsDTO.getEmpCode());
//        System.out.println("depID"+currentWorkDetailsDTO.getDepId());
//        System.out.println("==========================");

         currentWorkDetailService.saveWorkDetail(empId,currentWorkDetailsDTO);

        return new ResponseEntity<>(currentWorkDetailsDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("/employees/{emp_id}/current_work_details")
    public IdResponse deleteDetails(@PathVariable("emp_id")Long empId)throws EmployeeNotFoundException {

      return   currentWorkDetailService.deleteDetails(empId);
    }

    @GetMapping("/employees/{emp_id}/current_work_details")
    public CurrentWorkDetailResponse getDetails(@PathVariable("emp_id")Long empId)throws EmployeeNotFoundException{

        return currentWorkDetailService.getDetails(empId);
    }

    @DeleteMapping("/work/delete")
    public void delete(){
        currentWorkDetailService.deleteAll();
    }


}
