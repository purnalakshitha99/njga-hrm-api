package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.EmergencyContactRequest;
import lk.zerocode.api.controller.response.EmergencyResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.EmergencyContact;
import lk.zerocode.api.repository.EmergencyContactRepository;
import lk.zerocode.api.service.impl.EmergencyContactServiceIMPL;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class EmergencyContactController {

    EmergencyContactServiceIMPL emergencyContactServiceIMPL;

    EmergencyContactRepository emergencyContactRepository;

    @PostMapping("/emergency-contacts/{emp-id}")
    public List<EmergencyResponse> addEmergencyContact(@PathVariable("emp-id") Long empId, @RequestBody List<EmergencyContactRequest> emergencyContactRequest) {


        return emergencyContactServiceIMPL.addEmergencyContact(empId, emergencyContactRequest);
    }

    @GetMapping("emergency-contacts/{emp-id}")
    public List<EmergencyResponse> findEmergencyContactByEmployeeId(@PathVariable("emp-id") Long id) throws EmployeeNotFoundException {
        return emergencyContactServiceIMPL.getEmergencyContactByEmployeeId(id);
    }

    @DeleteMapping("emergency-contacts/{emp-id}/{contact-id}")
    public String deleteEmergencyContactById(@PathVariable("emp-id") Long empId, @PathVariable("contact-id") Long id) throws EmployeeNotFoundException {

        return emergencyContactServiceIMPL.deleteEmergencyContactById(empId,id);
    }
}
