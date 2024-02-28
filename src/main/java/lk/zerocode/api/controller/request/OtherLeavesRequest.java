package lk.zerocode.api.controller.request;

import jakarta.persistence.ManyToOne;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.FingerPrint;
import lk.zerocode.api.model.MonthlyBasedLeave;
import lk.zerocode.api.model.Status;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class OtherLeavesRequest {

    private String name;
    private String department;
    private String leaveType;
    private String dayType;
    private String reason;
    private LocalDate financialYear;
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
    private FingerPrint fingerPrint;
}
