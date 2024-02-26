package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "leave_to_leaves")
public class LeaveToLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate grantDate;
    private LocalDate expireDate;

    @OneToMany(mappedBy = "leaveToLeave")
    private List<FullDayLeave> fullDayLeavesList;
}
