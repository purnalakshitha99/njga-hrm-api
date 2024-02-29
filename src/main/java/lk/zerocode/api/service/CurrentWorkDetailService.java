package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.CurrentWorkDetailRequest;

import lk.zerocode.api.controller.response.CurrentWorkDetailResponse;
import lk.zerocode.api.controller.response.IdResponse;
import lk.zerocode.api.exceptions.*;


public interface CurrentWorkDetailService {


    void saveWorkDetail(Long empId, CurrentWorkDetailRequest currentWorkDetailRequest)throws EmployeeNotFoundException, BranchNotFoundException, DepartmentNotFoundException, EmpCategoryNotFoundException;


    IdResponse deleteDetails(Long empId)throws EmployeeNotFoundException;

    CurrentWorkDetailResponse getDetails(Long empId)throws EmployeeNotFoundException;

    void deleteAll();
}
