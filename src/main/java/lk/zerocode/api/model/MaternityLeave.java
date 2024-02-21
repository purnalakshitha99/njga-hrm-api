package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "maternity_leaves")
@Data

public class MaternityLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate expireDate;



    @OneToMany(mappedBy = "maternityLeave")
    private List<FullDayLeave> fullDayLeavesList;
}
