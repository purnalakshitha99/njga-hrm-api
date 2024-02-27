package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.AttendenceRequest;
import lk.zerocode.api.controller.response.Test;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

@Service
public interface AttendenceService {

    ResponseEntity<String> addAttendenceCheckIn(AttendenceRequest attendenceRequest)throws EmployeeNotFoundException;
    ResponseEntity<String> addAttendenceCheckOut(AttendenceRequest attendenceRequest)throws EmployeeNotFoundException;

    void delete();
}
