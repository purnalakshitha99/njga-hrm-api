package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.FullDayLeavesRequest;
import lk.zerocode.api.controller.response.FullDayLeavesResponse;
import lk.zerocode.api.exceptions.CannotCreateLeaveException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FullDayLeaveService {

    FullDayLeavesResponse create(Long empId, FullDayLeavesRequest fullDayLeavesRequest) throws EmployeeNotFoundException, CannotCreateLeaveException;
    void leaveStatus(Long id, FullDayLeavesRequest fullDayLeavesRequest);

    List<FullDayLeavesResponse> getSpecific(Long empId)throws EmployeeNotFoundException;
}
