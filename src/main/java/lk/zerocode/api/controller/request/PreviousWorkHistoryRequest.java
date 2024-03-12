package lk.zerocode.api.controller.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDate;
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PreviousWorkHistoryRequest {
    private String companyName;
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;
}
