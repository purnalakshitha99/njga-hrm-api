package lk.zerocode.api.repository;

import lk.zerocode.api.model.Attendance;
import lk.zerocode.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AttendenceRepository extends JpaRepository<Attendance, Long> {

Optional<Attendance> findAttendanceByEmployee(Employee employee);
}
