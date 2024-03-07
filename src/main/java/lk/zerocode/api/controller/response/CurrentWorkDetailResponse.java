package lk.zerocode.api.controller.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CurrentWorkDetailResponse {

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
