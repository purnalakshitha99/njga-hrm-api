package lk.zerocode.api.controller.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDate;
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CurrentWorkDetailsDTO {

    private Long id;
    private String designation;
    private LocalDate startDate;
    private String workTelephone;
    private String empCode;

    private String branchCode;
    private String depId;
    private String empCategory;
    private String empCategoryType;
}
