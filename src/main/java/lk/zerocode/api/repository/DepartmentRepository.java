package lk.zerocode.api.repository;

import lk.zerocode.api.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Optional<Department> findDepartmentByDepId(String depId);
}
