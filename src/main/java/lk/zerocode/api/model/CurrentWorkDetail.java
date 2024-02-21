package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "current_work_details")
@Data
public class CurrentWorkDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String branchName;
    private String department;
    private String designation;
    private LocalDate startDate;
    private String empCategory;
    private String empType;
    private String workTelephone;
    @OneToOne
    private Employee employee;


}
