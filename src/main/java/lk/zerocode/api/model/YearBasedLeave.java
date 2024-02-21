package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data

public class YearBasedLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String category;
    private Integer noOfDays;


    @OneToMany(mappedBy = "yearBasedLeave")
    private List<FullDayLeaves> fullDayLeavesList;
}
