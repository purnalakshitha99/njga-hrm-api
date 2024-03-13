package lk.zerocode.api.repository;

import lk.zerocode.api.model.Attendance;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.proj.AttendanceCountProjection;
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

    @Query(value = "SELECT COUNT(*) AS attendanceCount FROM attendances a WHERE a.employee_id = :empId AND MONTH(a.date) = 3  AND YEAR(a.date) = YEAR(CURRENT_DATE()) AND TIME(a.actual_check_in) > '13:50' AND TIME(a.actual_check_in) < '14:20'", nativeQuery = true)
    AttendanceCountProjection getAttendanceCount(@Param("empId") Long id);

}
