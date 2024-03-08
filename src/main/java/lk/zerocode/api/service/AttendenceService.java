package lk.zerocode.api.service;

import lk.zerocode.api.controller.dto.AttandanceSearchDTO;
import lk.zerocode.api.controller.dto.AttendanceDTO;
import lk.zerocode.api.controller.dto.FingerPrintDTO;
import lk.zerocode.api.exceptions.AttendanceException;
import lk.zerocode.api.model.Attendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendenceService {

    ResponseEntity<String> addAttendenceCheckIn(FingerPrintDTO fingerPrintDTO)throws AttendanceException;

    void delete();

//    ResponseEntity<List<Attendance>> getAllByDate(AttandanceSearchDTO attandanceSearchDTO)throws AttendanceException;

    AttendanceDTO findByEmpId(Long id) throws AttendanceException;

    List<AttendanceDTO> getAll() throws AttendanceException;

    List<AttendanceDTO> findByDate(AttandanceSearchDTO attandanceSearchDTO) throws AttendanceException;
}
