package lk.zerocode.api.service;

import lk.zerocode.api.controller.dto.OtherLeavesDTO;
import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.exceptions.CannotCreateLeaveException;
import lk.zerocode.api.exceptions.EmpCategoryNotFoundException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface OtherLeavesService {
    OtherLeavesResponse createLeave(Long empId, OtherLeavesDTO otherLeavesDTO) throws EmployeeNotFoundException, EmpCategoryNotFoundException, CannotCreateLeaveException;

    List<OtherLeavesResponse> getLeaves(Long empId)throws EmployeeNotFoundException;

    void deleteAll();


//    List<OtherLeavesResponse> createOtherLeaves(Long empId ,OtherLeavesRequest otherLeavesRequest);

}
