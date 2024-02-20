package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table
@Data

public class TimeBasedLeaves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

}
