package lk.zerocode.api.controller.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class WorkDetailResponse {
    private Long id;

    private String designation;
    private LocalDate startDate;
    private String workTelephone;
}
