package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

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
}
