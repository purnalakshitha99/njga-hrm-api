package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.DependentDetailRequest;
import lk.zerocode.api.controller.response.DependentDetailMsgResponse;
import lk.zerocode.api.controller.response.DependentDetailResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DependentService{
    DependentDetailMsgResponse saveDependentDetails(Long id, DependentDetailRequest dependentDetailRequest)throws EmployeeNotFoundException;
    List<DependentDetailResponse> getDependentByEmpId(Long id)throws EmployeeNotFoundException;
//    Optional<DependentDetailResponse> updateDependentDetail(Long id, DependentDetailRequest dependentDetailRequest)throws EmployeeNotFoundException;
    DependentDetailMsgResponse deleteDependentById(Long empId, Long DependentId) throws EmployeeNotFoundException;
}
