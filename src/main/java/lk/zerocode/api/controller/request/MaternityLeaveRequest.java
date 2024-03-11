package lk.zerocode.api.controller.request;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

public class MaternityLeaveRequest {
    private String name;
    private String leaveType;
    private String reason;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer noOfDays;
    private Year financialYear;
    private LocalDate applyDate;
    private String approvedPersonName;
    private LocalDate approvedDate;
    private LocalTime approvedTime;
}
