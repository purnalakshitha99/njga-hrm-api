package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.EmergencyContactRequest;
import lk.zerocode.api.controller.response.EmergencyResponse;
import lk.zerocode.api.model.EmergencyContact;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EmergencyContactRepository;
import lk.zerocode.api.repository.TestEmployeeRepo;
import lk.zerocode.api.service.EmergencyContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmergencyContactServiceIMPL implements EmergencyContactService {

    @Autowired
    private EmergencyContactRepository emergencyContactRepository;

    @Autowired
    private TestEmployeeRepo testEmployeeRepo;

    @Override
    public List<EmergencyResponse> addEmergencyContact(Long empId, List<EmergencyContactRequest> emergencyRequests) {

        Optional<Employee> employeeOptional = testEmployeeRepo.findById(empId);

        if (!employeeOptional.isPresent()) {
            return null;
        }
        List<EmergencyResponse> responses = new ArrayList<>();

        Employee employee = employeeOptional.get();

        for (EmergencyContactRequest emergencyRequest : emergencyRequests) {
            EmergencyContact emergencyContact = new EmergencyContact();
            emergencyContact.setId(emergencyRequest.getId());
            emergencyContact.setName(emergencyRequest.getName());
            emergencyContact.setRelationship(emergencyRequest.getRelationship());
            emergencyContact.setContact(emergencyRequest.getContact());
            emergencyContact.setEmployee(employee);

            employee.getEmergencyContactList().add(emergencyContact);


            emergencyContactRepository.save(emergencyContact);

            EmergencyResponse response = EmergencyResponse.builder()
                    .id(emergencyContact.getId())
                    .name(emergencyContact.getName())
                    .relationship(emergencyContact.getRelationship())
                    .contact(emergencyContact.getContact())
                    .employeeId(emergencyContact.getEmployee().getId())
                    .build();
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<EmergencyResponse> updateEmergencyDetails(EmergencyContactRequest emergencyContactRequest, Long id) {

        Optional<Employee> employeeOptional = testEmployeeRepo.findById(id);

        if (employeeOptional.isPresent()) {
            return null;
        }

        Employee employee = employeeOptional.get();
        List<EmergencyResponse> responses = new ArrayList<>();

        for (EmergencyContact emergencyContact : employee.getEmergencyContactList()) {
            emergencyContact.setName(emergencyContactRequest.getName());
            emergencyContact.setRelationship(emergencyContactRequest.getRelationship());
            emergencyContact.setContact(emergencyContactRequest.getContact());

            emergencyContactRepository.save(emergencyContact);

            EmergencyResponse response = EmergencyResponse.builder()
                    .id(emergencyContact.getId())
                    .name(emergencyContact.getName())
                    .relationship(emergencyContact.getRelationship())
                    .contact(emergencyContact.getContact())
                    .build();

            responses.add(response);
        }

        return responses;
    }


}