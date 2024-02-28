package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.EmergencyContactRequest;
import lk.zerocode.api.controller.response.EmergencyResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.EmergencyContact;

import java.util.List;

public interface EmergencyContactService {

    List<EmergencyResponse> addEmergencyContact(Long empId , List<EmergencyContactRequest> emergencyRequest) throws EmployeeNotFoundException;

    String deleteEmergencyContactById(Long empId, Long id) throws EmployeeNotFoundException;

    List<EmergencyResponse> getEmergencyContactByEmployeeId(Long empId) throws EmployeeNotFoundException;
}
