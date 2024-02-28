package lk.zerocode.api.service.impl;

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

//    public void saveWorkDetail(Long empId, CurrentWorkDetailRequest currentWorkDetailRequest, BranchRequest branchRequest, DepartmentRequest departmentRequest, EmpCategoryRequest empCategoryRequest) {
//
//        String branchCode = branchRequest.getBCode();
//
//        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
//        Optional<Branch> branchOptional = branchesRepository.findBranchByBranchCode(branchCode);
//        Optional<Department> departmentOptional = departmentRepository.findDepartmentByDepId(departmentRequest.getDepId());
//        Optional<EmpCategory> empCategoryOptional = empCategoryRepository.findEmpCategoriesByEmpCategory(empCategoryRequest.getEmpCategory());
//
//
//        if (optionalEmployee.isPresent() && branchOptional.isPresent() && departmentOptional.isPresent() && empCategoryOptional.isPresent()){
//
//            Employee employee = optionalEmployee.get();
//            Branch branch = branchOptional.get();
//            Department department = departmentOptional.get();
//            EmpCategory empCategory = empCategoryOptional.get();
//
//
//            CurrentWorkDetail currentWorkDetail = new CurrentWorkDetail();
//
//
//
//
//
//            currentWorkDetail.setEmpCategory(empCategory);
//            currentWorkDetail.setEmployee(employee);
//            currentWorkDetail.setBranch(branch);
//            currentWorkDetail.setDepartment(department);
//            currentWorkDetail.setDesignation(currentWorkDetailRequest.getDesignation());
//            currentWorkDetail.setWorkTelephone(currentWorkDetailRequest.getWorkTelephone());
//            currentWorkDetail.setStartDate(currentWorkDetail.getStartDate());
//
//            currentWorkDetailRepository.save(currentWorkDetail);
//        }
//    }


    public void addCurrent(Long empId,CurrentWorkDetail currentWorkDetail){

       Optional<Employee> optionalEmployee = employeeRepository.findById(empId);

       if (optionalEmployee.isPresent()){

           currentWorkDetailRepository.save(currentWorkDetail);

       }



    }

}
