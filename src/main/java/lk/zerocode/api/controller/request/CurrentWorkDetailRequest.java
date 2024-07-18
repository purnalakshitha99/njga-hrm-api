package lk.zerocode.api.controller.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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


    private String designation;
    private LocalDate startDate;
    private String workTelephone;
    private String empCode;

    private Long branchId;
    private Long depId;
    private Long empCategoryId;
}
