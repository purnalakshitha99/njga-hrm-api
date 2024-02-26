package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.WorkDetailRequest;
import lk.zerocode.api.controller.response.WorkDetailResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;

public interface WorkDetailService {
    WorkDetailResponse save(String empId,WorkDetailRequest workDetailRequest)throws EmployeeNotFoundException;
}
