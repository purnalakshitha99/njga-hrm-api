package lk.zerocode.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lk.zerocode.api.controller.response.BasicDetailsResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.BranchesRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasicDetailsImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private BranchesRepository branchesRepository;
    @Override
    public BasicDetailsResponse saveBasicDetails(Employee employee) throws EmployeeNotFoundException {



     return null;
    }
}
