package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.AttendenceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AttendenceService {
    ResponseEntity<String> saveAttendence(AttendenceRequest attendenceRequest);
}
