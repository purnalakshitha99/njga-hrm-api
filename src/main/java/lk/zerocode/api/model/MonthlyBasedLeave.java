package lk.zerocode.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "monthly_based_leaves")
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
