package lk.zerocode.api.repository;

import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.FullDayLeave;
import lk.zerocode.api.model.YearlyBasedLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface FullDayLeavesRepository extends JpaRepository<FullDayLeave,Long> {
    int countByYearBasedLeaveCategoryAndLeaveType(String category, String leaveType);

    int countFullDayLeaveByNoOfDaysAndEmployee(int noOfDays,Employee employee);

    @Query("SELECT SUM(fdl.noOfDays) FROM FullDayLeave fdl WHERE fdl.employee = :employee")
    Integer sumNumberOfDaysByEmployee(@Param("employee") Employee employee);

    List<FullDayLeave> findFullDayLeaveByEmployeeAndLeaveType(Employee employee,String leaveType);
}
