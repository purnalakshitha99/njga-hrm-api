package lk.zerocode.api.service;

import lk.zerocode.api.controller.request.CreateEmergencyRequest;

public interface EmergencyContactService {

    void addEmergencyContact(CreateEmergencyRequest emergencyRequest);
}
