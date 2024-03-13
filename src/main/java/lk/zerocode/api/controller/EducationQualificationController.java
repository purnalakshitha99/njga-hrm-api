package lk.zerocode.api.controller;

import lk.zerocode.api.controller.dto.EducationQualificationRqDTO;
import lk.zerocode.api.controller.response.EducationQualificationResponse;
import lk.zerocode.api.exceptions.EducationNotFoundException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.service.EducationQualificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EducationQualificationController {

    private EducationQualificationService educationQualificationService;
    @PostMapping(value = "/employees/{employee-id}/qualifications",headers ="X-API-VERSION=V1")
    public EducationQualificationResponse createQualification(@PathVariable("employee-id") Long id, @RequestBody EducationQualificationRqDTO educationQualificationRqDTO) throws EmployeeNotFoundException {
        return educationQualificationService.create(id, educationQualificationRqDTO);
    }
    @DeleteMapping(value = "/employees/{employee-id}/qualifications/{qualification-id}",headers ="X-API-VERSION=V1")
    public ResponseEntity<String> deleteQualification(@PathVariable("employee-id")Long employeeId, @PathVariable("qualification-id")Long id ) throws EmployeeNotFoundException, EducationNotFoundException {
       return educationQualificationService.delete(employeeId,id);
    }
    @GetMapping(value = "/employees/{employee-id}/qualifications",headers ="X-API-VERSION=V1")
    public List<EducationQualificationResponse> getSpecificQualifications(@PathVariable("employee-id")Long id) throws EmployeeNotFoundException{
        return educationQualificationService.getSpecific(id);
    }
}
