package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.CurrentWorkDetailRequest;
import lk.zerocode.api.controller.response.IdResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.*;
import lk.zerocode.api.repository.*;
import lk.zerocode.api.service.CurrentWorkDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CurrentWorkDetailServiceImpl implements CurrentWorkDetailService {

    private final EmployeeRepository employeeRepository;
    private final CurrentWorkDetailRepository currentWorkDetailRepository;
    private final BranchesRepository branchesRepository;
    private final DepartmentRepository departmentRepository;
    private final EmpCategoryRepository empCategoryRepository;




    public void saveWorkDetail(Long empId, CurrentWorkDetailRequest currentWorkDetailRequest) throws EmployeeNotFoundException{


       Employee employee = employeeRepository.findById(empId).orElseThrow(
               () -> new EmployeeNotFoundException("Employee not found")
       );
        System.out.println(currentWorkDetailRequest.getEmpCategoryId());
        System.out.println(empId);
        System.out.println(currentWorkDetailRequest.getBranchCode());

       Optional<Branch> branchOpt = branchesRepository.findBranchByBranchCode(currentWorkDetailRequest.getBranchCode());

       Optional<Department> departmentOpt = departmentRepository.findDepartmentByDepId(currentWorkDetailRequest.getDepId());
       Optional<EmpCategory> empCategoryOpt = empCategoryRepository.findById(currentWorkDetailRequest.getEmpCategoryId());



           Branch branch = branchOpt.get();
           Department department = departmentOpt.get();
           EmpCategory empCategory = empCategoryOpt.get();

           CurrentWorkDetail currentWorkDetail = new CurrentWorkDetail();

           currentWorkDetail.setEmployee(employee);
           currentWorkDetail.setBranch(branch);
           currentWorkDetail.setDepartment(department);
           currentWorkDetail.setEmpCategory(empCategory);

           currentWorkDetail.setWorkTelephone(currentWorkDetailRequest.getWorkTelephone());
           currentWorkDetail.setDesignation(currentWorkDetailRequest.getDesignation());
           currentWorkDetail.setStartDate(currentWorkDetailRequest.getStartDate());

           currentWorkDetailRepository.save(currentWorkDetail);
    }




}
