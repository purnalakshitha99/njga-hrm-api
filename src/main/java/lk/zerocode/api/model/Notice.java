package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "notices")
@Data
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empCategory;
    private String empType;
    private String title;
    private String description;
    private String imgPath;

    @JoinTable(name = "employee_notice",joinColumns = @JoinColumn(name = "noticeId"),inverseJoinColumns = @JoinColumn(name = "empId"))
    @ManyToMany
    private List<Employee> employeeList;
}
