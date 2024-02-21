package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table
@Data
public class CurrentWorkDetails {
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
