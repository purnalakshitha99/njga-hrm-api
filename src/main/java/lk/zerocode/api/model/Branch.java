package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "branches")
@Data
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String branchCode;
    private String name;
    private String city;

    @JoinTable(name = "branch_department",joinColumns = @JoinColumn(name = "branchId"),
            inverseJoinColumns = @JoinColumn(name = "depId"))
    @ManyToMany
    private List<Department> departmentList;

    @OneToMany(mappedBy = "branch")
    private List<CurrentWorkDetail> currentWorkDetailList;



}
