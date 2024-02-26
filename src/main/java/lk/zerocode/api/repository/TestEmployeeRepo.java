package lk.zerocode.api.repository;

import lk.zerocode.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEmployeeRepo extends JpaRepository<Employee,Long> {
}
