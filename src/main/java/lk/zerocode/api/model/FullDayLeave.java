package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

@Data
@Entity
@Table(name = "full_day_leaves")
public class FullDayLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private MaternityLeave maternityLeave;

    @ManyToOne
    private LeaveToLeave leaveToLeave;

    @ManyToOne
    private YearlyBasedLeave yearBasedLeave;
}
