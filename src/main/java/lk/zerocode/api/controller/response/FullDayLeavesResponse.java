package lk.zerocode.api.controller.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.zerocode.api.model.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

@Data
@Builder
public class FullDayLeavesResponse {

    private String name;
    private String department;
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

    @Enumerated(EnumType.STRING)
    private Status status;
}
