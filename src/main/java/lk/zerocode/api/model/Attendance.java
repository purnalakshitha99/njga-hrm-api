package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private LocalTime actualCheckIn;
    private LocalTime actualCheckOut;
    private LocalTime requiredCheckIn;
    private LocalTime requiredCheckOut;
    private String dayType;//morning/evining

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Employee employee;
}
