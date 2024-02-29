package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.CurrentWorkDetailRequest;

import lk.zerocode.api.exceptions.BranchNotFoundException;
import lk.zerocode.api.exceptions.DepartmentNotFoundException;
import lk.zerocode.api.exceptions.EmpCategoryNotFoundException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;


public interface CurrentWorkDetailService {


    void saveWorkDetail(Long empId, CurrentWorkDetailRequest currentWorkDetailRequest)throws EmployeeNotFoundException, BranchNotFoundException, DepartmentNotFoundException, EmpCategoryNotFoundException;


}
