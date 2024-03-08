package lk.zerocode.api.repository;

import lk.zerocode.api.model.Attendance;
import lk.zerocode.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendenceRepository extends JpaRepository<Attendance, Long> {

Optional<Attendance> findAttendanceByEmployee(Employee employee);
Optional<Attendance> findAttendanceByDateAndEmployee(LocalDate date, Employee employee);

@Query("from Attendance a where a.date=:date ")
List<Attendance> findByDate(@Param("date") LocalDate date);
}
