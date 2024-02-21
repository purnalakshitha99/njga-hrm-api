package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table
@Data

public class DependentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dependentsName;
    private String relationship;
    private LocalDate dob;

    @ManyToOne
    private Employee employee;
}
