package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="departments")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String depId;
    private String name;

    @ManyToMany(mappedBy = "departmentList")
    private List<Branch> branchList;

    @OneToMany(mappedBy = "department")
    private List<CurrentWorkDetail> currentWorkDetailList;

}
