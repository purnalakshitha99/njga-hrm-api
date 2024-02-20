package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
