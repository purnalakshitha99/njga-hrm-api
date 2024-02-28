package lk.zerocode.api.service;

import lk.zerocode.api.controller.response.OtherLeavesResponse;

import java.util.List;

public interface StandardOtherLeavesHalfDayService {

    List<OtherLeavesResponse> createStandardHalfDayLeaves(Long empId);
}
