package lk.zerocode.api.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empId;
    private String firstName;
    private String lastName;
    private String nic;
    private String gender;
    private LocalDate dob;
    private String email;
    private String address;
    private String contactNumber;
    private String workTelephone;
    private String imagePath;

}
