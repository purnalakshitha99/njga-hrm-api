package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "dependent_details")
@Data

public class DependentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dependentsName;
    private String relationship;
    private LocalDate dob;

    @ManyToOne
    private Employee employee;
}
