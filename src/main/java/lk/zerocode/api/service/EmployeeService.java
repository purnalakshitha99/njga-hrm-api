package lk.zerocode.api.service;

import lk.zerocode.api.controller.response.BasicDetailsResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    BasicDetailsResponse saveBasicDetails(Employee employee) throws EmployeeNotFoundException;}
