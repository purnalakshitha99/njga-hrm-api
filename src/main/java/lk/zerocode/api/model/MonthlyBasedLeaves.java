package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data

public class MonthlyBasedLeaves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String category;
    private Integer noOfDays;
    private Integer noOfHours;

    @OneToMany(mappedBy = "monthlyBasedLeaves")
    private List<OtherLeaves> otherLeavesList;

}
