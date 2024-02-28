package lk.zerocode.api.repository;

import lk.zerocode.api.model.EducationQualification;
import lk.zerocode.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationQualificationRepository extends JpaRepository<EducationQualification,Long> {
    List<EducationQualification> findEducationQualificationsByEmployee(Employee employee);
}
