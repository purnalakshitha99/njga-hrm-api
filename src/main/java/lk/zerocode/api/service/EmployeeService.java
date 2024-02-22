package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.DependentDetailReq;

public interface EmployeeService {
    void addDependent(DependentDetailReq dependentDetailReq,Long id);
}
