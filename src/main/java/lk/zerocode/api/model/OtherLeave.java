package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "other_leaves")
public class OtherLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;
    private String leaveType;
    private String dayType;
    private String reason;

    @Column(name = "f_year")
    private LocalDate financialYear;
    private LocalDate applyDate;

    @Column(name = "ap_p_name")
    private String approvedPersonName;

    @Column(name = "ap_date")
    private LocalDate approvedDate;

    @Column(name = "ap_time")
    private LocalTime approvedTime;

    @Column(name = "a_checkin")
    private LocalTime actualCheckIn;

    @Column(name = "a_checkout")
    private LocalTime actualCheckOut;

    @Column(name = "r_checkin")
    private LocalTime requiredCheckIn;

    @Column(name = "r_checkout")
    private LocalTime requiredCheckOut;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private MonthlyBasedLeave monthlyBasedLeaves;

    @ManyToOne
    private FingerPrint fingerPrint;
}
