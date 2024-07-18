package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.dto.CurrentWorkDetailsDTO;
import lk.zerocode.api.controller.response.CurrentWorkDetailResponse;
import lk.zerocode.api.controller.response.IdResponse;
import lk.zerocode.api.exceptions.*;
import lk.zerocode.api.model.*;
import lk.zerocode.api.repository.*;
import lk.zerocode.api.service.CurrentWorkDetailService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrentWorkDetailServiceImpl implements CurrentWorkDetailService {

    private final EmployeeRepository employeeRepository;
    private final CurrentWorkDetailRepository currentWorkDetailRepository;
    private final BranchesRepository branchesRepository;
    private final DepartmentRepository departmentRepository;
    private final EmpCategoryRepository empCategoryRepository;

    private ModelMapper modelMapper;

    public CurrentWorkDetailsDTO saveWorkDetail(Long empId, CurrentWorkDetailsDTO currentWorkDetailsDTO) throws EmployeeNotFoundException,BranchNotFoundException ,DepartmentNotFoundException,EmpCategoryNotFoundException{

       Employee employee = employeeRepository.findById(empId).orElseThrow(
               () -> new EmployeeNotFoundException("Employee not found")
       );
//        System.out.println("category "+currentWorkDetailsDTO.getEmpCategoryId());
//        System.out.println("category type "+currentWorkDetailsDTO.getEmpCategoryId());
//        System.out.println("emp id "+empId);
//        System.out.println("branch code "+currentWorkDetailsDTO.getBranchId());
//        System.out.println("employee code "+currentWorkDetailsDTO.getEmpCode());

        Branch branch = branchesRepository.findById(currentWorkDetailsDTO.getBranchId()).orElseThrow(
                () -> new BranchNotFoundException("that branch not found")
        );

        Department department = departmentRepository.findById(currentWorkDetailsDTO.getDepId()).orElseThrow(
                ()-> new DepartmentNotFoundException("that department not in the database")
        );

        EmpCategory empCategory = empCategoryRepository.findById(currentWorkDetailsDTO.getEmpCategoryId()).orElseThrow(
                ()-> new EmpCategoryNotFoundException("that employee category not having database")
        );


//        CurrentWorkDetail currentWorkDetail = modelMapper.map(currentWorkDetailsDTO,CurrentWorkDetail.class);

        CurrentWorkDetail currentWorkDetail = new CurrentWorkDetail();
        currentWorkDetail.setWorkTelephone(currentWorkDetailsDTO.getWorkTelephone());
        currentWorkDetail.setStartDate(currentWorkDetailsDTO.getStartDate());
        currentWorkDetail.setDesignation(currentWorkDetailsDTO.getDesignation());
        currentWorkDetail.setEmpCode(currentWorkDetailsDTO.getEmpCode());
        currentWorkDetail.setBranch(branch);
        currentWorkDetail.setEmployee(employee);
        currentWorkDetail.setDepartment(department);
        currentWorkDetail.setEmpCategory(empCategory);


           currentWorkDetailRepository.save(currentWorkDetail);

           return currentWorkDetailsDTO;

//        return null;

    }





    public IdResponse deleteDetails(Long empId)throws EmployeeNotFoundException{

        Employee employee = employeeRepository.findById(empId).orElseThrow(
                ()-> new EmployeeNotFoundException("that employee not in the database")
        );

        CurrentWorkDetail currentWorkDetail = employee.getCurrentWorkDetails();
        currentWorkDetailRepository.delete(currentWorkDetail);

        return IdResponse.builder().id(empId).message("deleted").build();
    }

    @Override
    public CurrentWorkDetailResponse getDetails(Long empId)throws EmployeeNotFoundException{

        Employee employee = employeeRepository.findById(empId).orElseThrow(
                ()-> new EmployeeNotFoundException("That employee not in the database")
        );

        CurrentWorkDetail currentWorkDetail = employee.getCurrentWorkDetails();

        return CurrentWorkDetailResponse.builder()
                .id(currentWorkDetail.getId())
                .designation(currentWorkDetail.getDesignation())
                .startDate(currentWorkDetail.getStartDate())
                .workTelephone(currentWorkDetail.getWorkTelephone())
                .branchCode(currentWorkDetail.getBranch().getBranchCode())
                .depId(currentWorkDetail.getDepartment().getDepId())
                .empCategory(currentWorkDetail.getEmpCategory().getEmpCategory())
                .empCategoryType(currentWorkDetail.getEmpCategory().getEmpType())
                .empCode(currentWorkDetail.getEmpCode())
                .build();
    }

    @Override
    public void deleteAll() {
    currentWorkDetailRepository.deleteAll();
    }


}
