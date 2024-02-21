package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table
@Data

public class EducationQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String universityName;
    private String qualification;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Employee employee;



}
