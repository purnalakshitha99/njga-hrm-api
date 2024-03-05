package lk.zerocode.api.repository;

import lk.zerocode.api.controller.dto.BasicDetailsDTO;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.PreviousWorkHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //    Optional<Employee> findEmployeeByEmpId(String id);
    Optional<Employee> findEmployeeByEmail(String email);


    // Custom query method to retrieve previous work history by employee
    @Query("SELECT p FROM PreviousWorkHistory p WHERE p.employee = :employee")
    List<PreviousWorkHistory> findPreviousWorkHistoryByEmployee(@Param("employee") Employee employee);

    @Query("FROM Employee e WHERE e.firstName LIKE CONCAT('%', :name, '%')")
    List<Employee> findByname(@Param("name") String name);
}
