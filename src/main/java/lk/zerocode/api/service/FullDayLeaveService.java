package lk.zerocode.api.service;

import lk.zerocode.api.controller.dto.FullDayLeavesRequestDTO;
import lk.zerocode.api.controller.response.FullDayLeavesResponse;
import lk.zerocode.api.exceptions.CannotCreateLeaveException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.exceptions.FullDayLeavesNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FullDayLeaveService {

    FullDayLeavesResponse create(Long empId, FullDayLeavesRequestDTO fullDayLeavesRequestDTO) throws EmployeeNotFoundException, CannotCreateLeaveException;
    void leaveStatus(Long id, FullDayLeavesRequestDTO fullDayLeavesRequestDTO)throws FullDayLeavesNotFoundException;

    List<FullDayLeavesResponse> getSpecific(Long empId)throws EmployeeNotFoundException;
}
