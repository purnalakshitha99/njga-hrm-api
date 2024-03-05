package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface OtherLeavesService {
    List<OtherLeavesResponse> createLeave(Long empId,OtherLeavesRequest otherLeavesRequest) throws EmployeeNotFoundException;

//    List<OtherLeavesResponse> createStandardOtherLeaves(Long empId, OtherLeavesRequest otherLeavesRequest);

}
