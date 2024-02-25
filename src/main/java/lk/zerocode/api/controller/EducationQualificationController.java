package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.EducationQualificationRequest;
import lk.zerocode.api.controller.response.EducationQualificationResponse;
import lk.zerocode.api.service.EducationQualificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EducationQualificationController {

    private EducationQualificationService educationQualificationService;

    @PostMapping(value = "/employees/{employee-id}",headers ="X-API-VERSION=V1")
    public EducationQualificationResponse createQualification(@PathVariable("employee-id") Long id, @RequestBody EducationQualificationRequest educationQualificationRequest){
    return educationQualificationService.create(id,educationQualificationRequest);
    }
}
