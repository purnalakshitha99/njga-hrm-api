package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.EducationQualificationRequest;
import lk.zerocode.api.controller.response.EducationQualificationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EducationQualificationService {

    EducationQualificationResponse create(Long id, EducationQualificationRequest educationQualificationRequest);
    void delete(Long id, Long employeeId);
    List<EducationQualificationResponse> getSpecific(Long id);
}
