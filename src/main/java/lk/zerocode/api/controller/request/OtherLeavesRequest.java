package lk.zerocode.api.controller.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.FingerPrint;
import lk.zerocode.api.model.MonthlyBasedLeave;
import lk.zerocode.api.model.Status;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OtherLeavesRequest {

    private String department;
    private String leaveType;
    private String dayType;
    private String reason;
    private Year financialYear;
    private Month financialMonth;



    private Status status;
    private Float hours;
//    private MonthlyBasedLeave monthlyBasedLeaves;
//    private FingerPrint fingerPrint;
    private LocalTime wontedTime;
    private LocalDate wantedDate;





}
