package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "previous_works_histories")
@Data
public class PreviousWorkHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Employee employee;

}
