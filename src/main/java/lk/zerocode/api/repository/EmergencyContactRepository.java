package lk.zerocode.api.repository;

import lk.zerocode.api.model.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyContactRepository extends JpaRepository<EmergencyContact , Long> {
}
