package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.DependentDetailRequest;
import lk.zerocode.api.controller.response.DependentDetailResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface DependentService{
    DependentDetailResponse saveDependentDetails(Long id, DependentDetailRequest dependentDetailRequest)throws EmployeeNotFoundException;
}
