package lk.zerocode.api.controller.request;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lk.zerocode.api.model.Branch;
import lk.zerocode.api.model.Department;
import lk.zerocode.api.model.EmpCategory;
import lk.zerocode.api.model.Employee;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CurrentWorkDetailRequest {

    private Long id;

    private String designation;
    private LocalDate startDate;
    private String workTelephone;


    private Employee employee;


    private Long branch;


    private Department department;


    private EmpCategory empCategory;
}
