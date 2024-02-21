package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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


    @OneToMany(mappedBy = "branch")
    private List<Employee> employeeList;

    @JoinTable(name = "branch_department",joinColumns = @JoinColumn(name = "branchId"),
            inverseJoinColumns = @JoinColumn(name = "depId"))
    @ManyToMany
    private List<Department> departmentList;

}
