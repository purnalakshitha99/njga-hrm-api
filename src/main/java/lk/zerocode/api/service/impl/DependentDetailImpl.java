package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.DependentDetailRequest;
import lk.zerocode.api.controller.response.DependentDetailResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.DependentDetail;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.DependentRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.DependentService;
import lk.zerocode.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DependentDetailImpl implements DependentService {
    private EmployeeRepository employeeRepository;
    private DependentRepository dependentRepository;
    @Override
    public DependentDetailResponse saveDependentDetails(Long id, DependentDetailRequest dependentDetailRequest) throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee employee = employeeOptional.get();
        if(employeeOptional.isPresent()){
            DependentDetail dependentDetail = new DependentDetail();
            dependentDetail.setDependentsName(dependentDetailRequest.getDependentName());
//            dependentDetail.setDob(dependentDetailRequest);
        }
        return null;

    }
}