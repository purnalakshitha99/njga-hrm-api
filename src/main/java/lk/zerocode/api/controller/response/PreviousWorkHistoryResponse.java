package lk.zerocode.api.controller.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class PreviousWorkHistoryResponse {
    private Long id;
    private String companyName;
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;
}
