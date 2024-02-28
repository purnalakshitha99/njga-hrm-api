package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "finger_prints")
public class FingerPrint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tId;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private OtherLeave otherLeave;
}
