package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "monthly_based_leaves")
@Data

public class MonthlyBasedLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String category;
    private Integer noOfDays;
    private Integer noOfHours;

    @OneToMany(mappedBy = "monthlyBasedLeaves")
    private List<OtherLeave> otherLeavesList;

}
