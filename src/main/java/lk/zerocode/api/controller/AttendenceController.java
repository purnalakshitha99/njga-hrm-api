package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.AttendenceRequest;
import lk.zerocode.api.service.AttendenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AttendenceController {

    private AttendenceService attendenceService;
    public ResponseEntity<String> getAttendence(@RequestBody AttendenceRequest attendenceRequest){
        return attendenceService.saveAttendence(attendenceRequest);
    }
}
