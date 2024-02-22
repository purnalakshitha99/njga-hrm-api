package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.CreateEmergencyRequest;
import lk.zerocode.api.model.EmergencyContact;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EmergencyContactRepository;
import lk.zerocode.api.service.EmergencyContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyContactServiceIMPL implements EmergencyContactService {

    @Autowired
    private EmergencyContactRepository emergencyContactRepository;

    @Override
    public void addEmergencyContact(CreateEmergencyRequest emergencyRequest) {

        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setId(emergencyRequest.getId());
        emergencyContact.setName(emergencyRequest.getName());
        emergencyContact.setRelationship(emergencyRequest.getRelationship());

        emergencyContact.setEmployee(emergencyRequest.getEmployee());

        emergencyContactRepository.save(emergencyContact);
    }
}