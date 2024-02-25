package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.BasicDetailsRequest;
import lk.zerocode.api.controller.response.BasicDetailsResponse;
import lk.zerocode.api.controller.response.IdResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    IdResponse saveBasicDetails(BasicDetailsRequest basicDetailsRequest) throws EmployeeNotFoundException;
    BasicDetailsResponse getByEmpId(String id) throws EmployeeNotFoundException;
    BasicDetailsResponse getByEmpEmail(String email) throws EmployeeNotFoundException;

     List<BasicDetailsResponse> getAll() throws EmployeeNotFoundException;

    ResponseEntity<String> updateBasicDetails(String id, BasicDetailsRequest basicDetailsRequest) throws EmployeeNotFoundException;
}
