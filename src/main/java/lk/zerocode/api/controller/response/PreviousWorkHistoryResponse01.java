package lk.zerocode.api.controller.response;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PreviousWorkHistoryResponse01 {
    private Long id;
    private String companyName;
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;
}
