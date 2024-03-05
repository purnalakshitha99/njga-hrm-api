package lk.zerocode.api.controller.response;

import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.FingerPrint;
import lk.zerocode.api.model.MonthlyBasedLeave;
import lk.zerocode.api.model.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;

@Data
@Builder
public class OtherLeavesResponse {

    private String name;
    private String department;
    private String leaveType;
    private String dayType;
    private String reason;
    private Year financialYear;
    private Month financialMonth;
    private LocalDate applyDate;
    private String approvedPersonName;
    private LocalDate approvedDate;
    private LocalTime approvedTime;
    private LocalTime actualCheckIn;
    private LocalTime actualCheckOut;
    private LocalTime requiredCheckIn;
    private LocalTime requiredCheckOut;
    private Status status;
    private Employee employee;
    private MonthlyBasedLeave monthlyBasedLeaves;
    private LocalTime wontedTime;
    private LocalDate wantedDate;
}
