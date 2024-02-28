package lk.zerocode.api.service;


import lk.zerocode.api.controller.request.PreviousWorkHistoryRequest;

import lk.zerocode.api.controller.response.PreviousWorkHistoryIdResponse;
import lk.zerocode.api.controller.response.PreviousWorkHistoryResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.exceptions.PreviousWorkHistoryNotFoundException;
import lk.zerocode.api.model.PreviousWorkHistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PreviousWorkHistoryService {
    PreviousWorkHistoryIdResponse savePreviousWorkHistoryDetails(Long eid, PreviousWorkHistoryRequest previousWorkHistoryRequest)throws EmployeeNotFoundException;

    List<PreviousWorkHistoryResponse> getPreviousWorkHistoryByEmpId(Long eid)throws EmployeeNotFoundException;

    PreviousWorkHistoryIdResponse updatePreviousWorkHistoryDetails(Long eid, Long previousWorkHistoryId, PreviousWorkHistoryRequest updatedHistoryRequest)throws EmployeeNotFoundException,PreviousWorkHistoryNotFoundException;

    String deletePreviousWorkHistoryDetailsById(Long empId, Long previousWorkHistoryId)throws EmployeeNotFoundException;
}