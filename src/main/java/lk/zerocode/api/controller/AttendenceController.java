package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.AttendenceRequest;
import lk.zerocode.api.controller.response.Test;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.service.AttendenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@AllArgsConstructor
public class AttendenceController {

    private AttendenceService attendenceService;

    @PostMapping("/attendence/employee")
    public ResponseEntity<String> add(@RequestBody AttendenceRequest attendenceRequest)throws EmployeeNotFoundException{
        return attendenceService.addAttendenceCheckIn(attendenceRequest);
    }

    @PutMapping("/attendence")
    public ResponseEntity<String >update(@RequestBody AttendenceRequest attendenceRequest) throws EmployeeNotFoundException{
        return attendenceService.addAttendenceCheckOut(attendenceRequest);
    }

    @DeleteMapping("/delete/att")
    public void delete(){
         attendenceService.delete();
    }

}
