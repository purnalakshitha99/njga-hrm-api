package lk.zerocode.api.service;

import lk.zerocode.api.model.CurrentWorkDetail;

public interface CurrentWorkDetailService {
//    void saveWorkDetail(Long empId, CurrentWorkDetailRequest currentWorkDetailRequest, BranchRequest branchRequest, DepartmentRequest departmentRequest, EmpCategoryRequest empCategoryRequest);

    void addCurrent(Long empId,CurrentWorkDetail currentWorkDetail);

}
