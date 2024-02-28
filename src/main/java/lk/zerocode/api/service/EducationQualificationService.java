package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.EducationQualificationRequest;
import lk.zerocode.api.controller.response.EducationQualificationResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EducationQualificationService {

    EducationQualificationResponse create(Long id, EducationQualificationRequest educationQualificationRequest) throws EmployeeNotFoundException;
    void delete(Long employeeId,Long id) throws EmployeeNotFoundException;
    List<EducationQualificationResponse> getSpecific(Long id) throws EmployeeNotFoundException;
}
