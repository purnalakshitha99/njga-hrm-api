package lk.zerocode.api.controller.response;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
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

    private Long id;

    private String name;
    private String department;
    private String leaveType;
    private String dayType;
    private String reason;

    private Year financialYear;

    private Month financialMonth;

    private LocalDate applyDate;
    private LocalTime applyTime;



    private LocalTime wantedTime;

    private LocalDate wantedDate;

    private Status status;

    private Integer hours;
}
