package lk.zerocode.api.repository;

import lk.zerocode.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findEmployeeByEmpId(String  id);
    Optional<Employee> findEmployeeByEmail(String email);


}
