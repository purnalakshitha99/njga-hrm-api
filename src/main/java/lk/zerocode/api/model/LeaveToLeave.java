package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Table
@Data

public class LeaveToLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate grantDate;
    private LocalDate expireDate;

    @ManyToOne
    private FullDayLeaves fullDayLeaves;
}
