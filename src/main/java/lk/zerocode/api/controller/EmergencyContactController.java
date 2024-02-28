package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.EmergencyContactRequest;
import lk.zerocode.api.controller.response.EmergencyResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.repository.EmergencyContactRepository;
import lk.zerocode.api.service.EmergencyContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmergencyContactController {

    EmergencyContactService emergencyContactService;

    EmergencyContactRepository emergencyContactRepository;

    @PostMapping(value = "/employees/{emp-id}/emergency-contacts", headers = "version=v1")
    public List<EmergencyResponse> addEmergencyContact(@PathVariable("emp-id") Long empId, @RequestBody List<EmergencyContactRequest> emergencyContactRequest) throws EmployeeNotFoundException{
        return emergencyContactService.addEmergencyContact(empId, emergencyContactRequest);
    }

    @GetMapping(value = "employees/{emp-id}/emergency-contacts",headers = "version=v1")
    public List<EmergencyResponse> findEmergencyContactByEmployeeId(@PathVariable("emp-id") Long id) throws EmployeeNotFoundException {
        return emergencyContactService.getEmergencyContactByEmployeeId(id);
    }

    @DeleteMapping(value = "employees/{emp-id}/emergency-contacts/{contact-id}",headers = "version=v1")
    public String deleteEmergencyContactById(@PathVariable("emp-id") Long empId, @PathVariable("contact-id") Long id) throws EmployeeNotFoundException {
        return emergencyContactService.deleteEmergencyContactById(empId,id);
    }
}
