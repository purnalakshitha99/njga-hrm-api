package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.EducationQualificationRequest;
import lk.zerocode.api.controller.response.EducationQualificationResponse;
import lk.zerocode.api.service.EducationQualificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EducationQualificationController {

    private EducationQualificationService educationQualificationService;

    @PostMapping(value = "/employees/{employee-id}/qualifications",headers ="X-API-VERSION=V1")
    public EducationQualificationResponse createQualification(@PathVariable("employee-id") Long id, @RequestBody EducationQualificationRequest educationQualificationRequest){
        return educationQualificationService.create(id,educationQualificationRequest);
    }
    @DeleteMapping(value = "/qualifications/{qualification-id}/{employee-id}",headers ="X-API-VERSION=V1")
    public void deleteQualification(@PathVariable("qualification-id")Long id,@PathVariable("employee-id")Long employeeId ){
        educationQualificationService.delete(id,employeeId);
    }
}
