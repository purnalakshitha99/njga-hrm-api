package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table
@Data

public class OtherLeaves {
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

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "otherLeaves")
    private List<MonthlyBasedLeaves> monthlyBasedLeavesList;

}
