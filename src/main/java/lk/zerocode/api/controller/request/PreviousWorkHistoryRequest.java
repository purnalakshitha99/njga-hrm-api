package lk.zerocode.api.controller.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PreviousWorkHistoryRequest {


    private String companyName;
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;
}
