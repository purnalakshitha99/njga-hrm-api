package lk.zerocode.api.controller.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DependentDetailResponse {
    private String dependentName;
    private LocalDate dob;
    private String relation;
}
