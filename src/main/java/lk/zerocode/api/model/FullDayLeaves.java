package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table
@Data

public class FullDayLeaves {
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
    private LocalDate financialYear;
    private LocalDate applyDate;
    private String approvedPersonName;
    private LocalDate approvedDate;
    private LocalTime approvedTime;

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "fullDayLeaves")
    private List<MaternityLeave> maternityLeaveList;

    @OneToMany(mappedBy = "fullDayLeaves")
    private List<LeaveToLeave> leaveToLeaveList;

    @OneToMany(mappedBy = "fullDayLeaves")
    private List<YearBasedLeave> yearBasedLeaveList;

}
