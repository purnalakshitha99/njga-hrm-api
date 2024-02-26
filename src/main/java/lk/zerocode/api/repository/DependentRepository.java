package lk.zerocode.api.repository;

import lk.zerocode.api.model.DependentDetail;
import lk.zerocode.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DependentRepository extends JpaRepository<DependentDetail,Long> {
    List<DependentDetail> findDependentDetailByEmployee(Employee employee);
}
