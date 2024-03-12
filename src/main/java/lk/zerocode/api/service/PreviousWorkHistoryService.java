package lk.zerocode.api.service;


import lk.zerocode.api.controller.request.PreviousWorkHistoryRequest;

import lk.zerocode.api.controller.response.PreviousWorkHistoryIdResponse;
import lk.zerocode.api.controller.response.PreviousWorkHistoryResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.exceptions.PreviousWorkHistoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PreviousWorkHistoryService {

    List<PreviousWorkHistoryResponse> createPreviousWorkHistoryDetails(Long empId, List<PreviousWorkHistoryRequest> previousWorkHistoryRequests) throws EmployeeNotFoundException;

    List<PreviousWorkHistoryResponse> getPreviousWorkHistoryByEmpId(Long empId)throws EmployeeNotFoundException;

    PreviousWorkHistoryIdResponse updatePreviousWorkHistoryDetails(Long empId, Long previousWorkHistoryId, PreviousWorkHistoryRequest updatedHistoryRequest)throws EmployeeNotFoundException,PreviousWorkHistoryNotFoundException;

    String deletePreviousWorkHistoryDetailsById(Long empId, Long previousWorkHistoryId)throws EmployeeNotFoundException,PreviousWorkHistoryNotFoundException;
}
