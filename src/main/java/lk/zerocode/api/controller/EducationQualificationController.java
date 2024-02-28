package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.EducationQualificationRequest;
import lk.zerocode.api.controller.response.EducationQualificationResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.service.EducationQualificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EducationQualificationController {

    private EducationQualificationService educationQualificationService;

    @PostMapping(value = "/employees/{employee-id}/qualifications",headers ="X-API-VERSION=V1")
    public EducationQualificationResponse createQualification(@PathVariable("employee-id") Long id, @RequestBody EducationQualificationRequest educationQualificationRequest)
    throws EmployeeNotFoundException {
        return educationQualificationService.create(id,educationQualificationRequest);
    }
    @DeleteMapping(value = "/employees/{employee-id}/qualifications/{qualification-id}",headers ="X-API-VERSION=V1")
    public void deleteQualification(@PathVariable("employee-id")Long employeeId,@PathVariable("qualification-id")Long id )
    throws EmployeeNotFoundException{
        educationQualificationService.delete(employeeId,id);
    }
    @GetMapping(value = "/employees/{employee-id}/qualifications",headers ="X-API-VERSION=V1")
    public List<EducationQualificationResponse> getSpecificQualifications(@PathVariable("employee-id")Long id)
    throws EmployeeNotFoundException{
        return educationQualificationService.getSpecific(id);
    }
}
