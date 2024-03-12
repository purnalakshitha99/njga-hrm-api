package lk.zerocode.api.service;

import lk.zerocode.api.controller.dto.EducationQualificationRqDTO;
import lk.zerocode.api.controller.response.EducationQualificationResponse;
import lk.zerocode.api.exceptions.EducationNotFoundException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EducationQualificationService {

    EducationQualificationResponse create(Long id, EducationQualificationRqDTO educationQualificationRqDTO) throws EmployeeNotFoundException;
    ResponseEntity<String> delete(Long employeeId, Long id) throws EmployeeNotFoundException, EducationNotFoundException;
    List<EducationQualificationResponse> getSpecific(Long id) throws EmployeeNotFoundException;
}
