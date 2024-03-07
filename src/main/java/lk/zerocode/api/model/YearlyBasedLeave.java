package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "yearly_based_leaves")
public class YearlyBasedLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String category;
    private Integer noOfDays;

    @OneToMany(mappedBy = "yearBasedLeave")
    private List<FullDayLeave> fullDayLeavesList;

}
