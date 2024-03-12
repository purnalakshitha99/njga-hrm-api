package lk.zerocode.api.controller;

import lk.zerocode.api.controller.dto.AttandanceSearchDTO;
import lk.zerocode.api.controller.dto.AttendanceDTO;
import lk.zerocode.api.controller.dto.FingerPrintDTO;
import lk.zerocode.api.exceptions.AttendanceException;
import lk.zerocode.api.model.Attendance;
import lk.zerocode.api.service.AttendenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AttendenceController {

    private AttendenceService attendenceService;

    @PostMapping(value = "/attendance",headers ="VERSION=V1")

    public ResponseEntity<String> add(@RequestBody FingerPrintDTO fingerPrintDTO)throws AttendanceException {
        return attendenceService.addAttendenceCheckIn(fingerPrintDTO);
    }

    @GetMapping(value = "/attendance/{empId}",headers ="VERSION=V1")
    public AttendanceDTO getAllAttendanceByDate(@PathVariable ("empId")Long id) throws AttendanceException {
        return attendenceService.findByEmpId(id);
    }

    @GetMapping(value = "/attendances",headers ="VERSION=V1")
    public ResponseEntity<List<AttendanceDTO>> getAllAttendance()throws AttendanceException{
        List<AttendanceDTO> attendanceDTO = attendenceService.getAll();
        return new ResponseEntity<>(attendanceDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/attendance/date",headers ="VERSION=V1")
    public ResponseEntity<List<AttendanceDTO>> getAllAttendanceByDate(@RequestBody AttandanceSearchDTO attandanceSearchDTO)throws AttendanceException{
        List<AttendanceDTO> attendanceDTOList = attendenceService.findByDate(attandanceSearchDTO);
        return new ResponseEntity<>(attendanceDTOList, HttpStatus.OK);
    }

    //optional
    @DeleteMapping(value = "/delete/att",headers ="VERSION=V1")
    public void delete(){
         attendenceService.delete();
    }


    @DeleteMapping(value = "/delete/fullday",headers ="VERSION=V1")
    public void deletFullDay( ){
        attendenceService.deleteFullday();
    }

}
