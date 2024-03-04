package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface StandardOtherLeavesHalfDayService {

    List<OtherLeavesResponse> createStandardHalfDayLeaves(Long empId, Long wId , OtherLeavesRequest otherLeavesRequest) throws EmployeeNotFoundException;
}
