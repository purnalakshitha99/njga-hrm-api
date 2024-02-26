package lk.zerocode.api.repository;

import lk.zerocode.api.controller.response.EmergencyResponse;
import lk.zerocode.api.model.EmergencyContact;
import lk.zerocode.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmergencyContactRepository extends JpaRepository<EmergencyContact , Long> {

    List<EmergencyResponse> findEmergencyContactByEmployeeId(Long empId);

}
