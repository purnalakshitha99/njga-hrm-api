package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "current_work_details")
public class CurrentWorkDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designation;
    private LocalDate startDate;
    private String workTelephone;

    @OneToOne
    private Employee employee;

    @ManyToOne
    private Branch branch;

    @ManyToOne
    private Department department;

    @ManyToOne
    private EmpCategory empCategory;
}
