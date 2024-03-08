package lk.zerocode.api.repository;

import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.OtherLeave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface OtherLeavesRepository extends JpaRepository<OtherLeave , Long> {


    List<OtherLeave> findOtherLeaveByEmployeeAndLeaveTypeAndFinancialYearAndFinancialMonth(Employee employee,String leaveType,String year,String month);

    List<OtherLeave> findOtherLeaveByEmployeeAndWantedDateAndWantedTime(Employee employee, LocalDate wantedDate, LocalTime wantedTime);

//    List<OtherLeave> findOtherLeaveByEmployeeIdAndLeaveType(Long empId,String leaveType);



}
