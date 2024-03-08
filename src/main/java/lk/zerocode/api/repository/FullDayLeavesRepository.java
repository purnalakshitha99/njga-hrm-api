package lk.zerocode.api.repository;

import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.FullDayLeave;
import lk.zerocode.api.model.YearlyBasedLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface FullDayLeavesRepository extends JpaRepository<FullDayLeave,Long> {
    List<FullDayLeave> findFullDayLeaveByEmployeeAndLeaveTypeAndFinancialYear(Employee employee, String leaveType,String year);
    List<FullDayLeave> findFullDayLeaveByEmployee(Employee employee);
    List<FullDayLeave> findFullDayLeaveByEmployeeAndStartDateAndEndDate(Employee employee,LocalDate startDate,LocalDate endDate);
}