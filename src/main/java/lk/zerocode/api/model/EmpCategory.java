package lk.zerocode.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "employee_categories")
public class EmpCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empCategory;
    private String empType;

    @OneToMany(mappedBy = "empCategory")
    private List<CurrentWorkDetail> currentWorkDetailList;
}
