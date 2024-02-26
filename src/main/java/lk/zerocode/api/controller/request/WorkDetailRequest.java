package lk.zerocode.api.controller.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class WorkDetailRequest {
    private Long id;

    private String designation;
    private LocalDate startDate;
    private String workTelephone;
}
