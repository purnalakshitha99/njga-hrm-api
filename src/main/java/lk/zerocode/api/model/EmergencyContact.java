package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "emergency_contacts")
public class EmergencyContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String relationship;
    private String contact;

    @ManyToOne
    private Employee employee;
}
