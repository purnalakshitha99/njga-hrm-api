package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.CurrentWorkDetailRequest;
import lk.zerocode.api.controller.response.IdResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.CurrentWorkDetail;

public interface CurrentWorkDetailService {


    void saveWorkDetail(Long empId, CurrentWorkDetailRequest currentWorkDetailRequest)throws EmployeeNotFoundException;


}
