package lk.zerocode.api.controller.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EducationQualificationRqDTO {

    private String universityName;
    private String qualification;
    private LocalDate startDate;
    private LocalDate endDate;
}
