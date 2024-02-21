package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "finger_prints")
@Data

public class FingerPrint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer tId;

    @ManyToOne
    private Employee employee;
}
