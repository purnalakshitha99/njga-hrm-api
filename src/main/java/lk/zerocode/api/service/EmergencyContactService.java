package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.EmergencyContactRequest;
import lk.zerocode.api.controller.response.EmergencyResponse;
import lk.zerocode.api.model.EmergencyContact;

import java.util.List;

public interface EmergencyContactService {

    List<EmergencyResponse> addEmergencyContact(Long empId , List<EmergencyContactRequest> emergencyRequest);

    List<EmergencyResponse> updateEmergencyDetails(EmergencyContactRequest emergencyContactRequest, Long id);
}
