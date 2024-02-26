package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.WorkDetailRequest;
import lk.zerocode.api.controller.response.WorkDetailResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.CurrentWorkDetail;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.BranchesRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.repository.WorkDetailRepository;
import lk.zerocode.api.service.WorkDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkDetailImpl implements WorkDetailService {
    private final EmployeeRepository employeeRepository;
    private final WorkDetailRepository workDetailRepository;
    private final BranchesRepository branchesRepository;

    public WorkDetailResponse save(@PathVariable String empId, @RequestBody WorkDetailRequest workDetailRequest)throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmpId(empId);

        if (!employeeOptional.isPresent()) {
            throw new EmployeeNotFoundException("That employee not in a Database");
        }else {

            Employee employee = employeeOptional.get();

            CurrentWorkDetail currentWorkDetail = new CurrentWorkDetail();

            currentWorkDetail.setBranch();
            currentWorkDetail.setDepartment();
            currentWorkDetail.setEmpCategory();
            currentWorkDetail.setDesignation(workDetailRequest.getDesignation());
            currentWorkDetail.setStartDate(workDetailRequest.getStartDate());
            currentWorkDetail.setWorkTelephone(workDetailRequest.getWorkTelephone());

            workDetailRepository.save(currentWorkDetail);

            return WorkDetailResponse.builder().id(currentWorkDetail.getId()).designation(currentWorkDetail.getDesignation()).startDate(currentWorkDetail.getStartDate()).workTelephone(currentWorkDetail.getWorkTelephone()).build();
        }
    }

    public WorkDetailResponse getSpecific(@PathVariable String empId)throws EmployeeNotFoundException{
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmpId(empId);

        if (!employeeOptional.isPresent()){

            throw new EmployeeNotFoundException("that employee not in the database");
        }
        else {

            Employee
        }
    }
}
