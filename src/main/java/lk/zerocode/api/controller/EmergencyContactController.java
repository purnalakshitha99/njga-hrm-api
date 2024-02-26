package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.EmergencyContactRequest;
import lk.zerocode.api.controller.response.EmergencyResponse;
import lk.zerocode.api.model.EmergencyContact;
import lk.zerocode.api.repository.EmergencyContactRepository;
import lk.zerocode.api.service.impl.EmergencyContactServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmergencyContactController {

    @Autowired
    EmergencyContactServiceIMPL emergencyContactServiceIMPL;

    @Autowired
    EmergencyContactRepository emergencyContactRepository;

    @PostMapping("/emergency-contacts/{emp-id}")
    public List<EmergencyResponse> addEmergencyContact(@PathVariable("emp-id") Long empId, @RequestBody List<EmergencyContactRequest> emergencyContactRequest) {

        return emergencyContactServiceIMPL.addEmergencyContact(empId, emergencyContactRequest);
    }

    @GetMapping("emergency-contacts/{emp-id}")
    public List<EmergencyResponse> findEmergencyContactByEmployeeId(@PathVariable("emp-id") Long id) {
        return emergencyContactRepository.findEmergencyContactByEmployeeId(id);
    }

    @PutMapping("/emergency-contacts/{emp-id}")
    public List<EmergencyResponse> updateEmergencyContact(@PathVariable("emp-id") Long id , @RequestBody EmergencyContactRequest emergencyContactRequest){

        return emergencyContactServiceIMPL.updateEmergencyDetails(emergencyContactRequest,id);

    }
}
