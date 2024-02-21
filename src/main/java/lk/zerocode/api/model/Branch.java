package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String branchCode;
    private String name;
    private String city;


}
