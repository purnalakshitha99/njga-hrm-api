package lk.zerocode.api.controller.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDate;
@Data

public class CurrentWorkDetailsDTO {

    private String designation;
    private LocalDate startDate;
    private String workTelephone;
    private String empCode;

    private Long branchId;
    private Long depId;
    private Long empCategoryId;

}
