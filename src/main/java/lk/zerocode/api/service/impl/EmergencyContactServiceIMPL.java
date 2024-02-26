package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.EmergencyContactRequest;
import lk.zerocode.api.controller.response.EmergencyResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.EmergencyContact;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EmergencyContactRepository;
import lk.zerocode.api.repository.EmployeeRepository;
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
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmergencyResponse> addEmergencyContact(Long empId, List<EmergencyContactRequest> emergencyRequests) {

        Optional<Employee> employeeOptional = employeeRepository.findById(empId);

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

    public List<EmergencyResponse> getEmergencyContactByEmployeeId(Long empId) {

        return emergencyContactRepository.findEmergencyContactByEmployeeId(empId);
    }

    @Override
    public String deleteEmergencyContactById(Long empId, Long id) throws EmployeeNotFoundException {
        Optional<EmergencyContact> emergencyContactOptional = emergencyContactRepository.findById(empId);

        if (!emergencyContactOptional.isPresent()) {
            throw new EmployeeNotFoundException("Employee not found");
        }

        EmergencyContact contact = emergencyContactOptional.get();

        emergencyContactRepository.deleteById(id);

        return "delete succesfull with employee id :" + empId + " with contact id :" + id;
    }


}