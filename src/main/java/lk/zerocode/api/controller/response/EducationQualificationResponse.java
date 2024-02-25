package lk.zerocode.api.controller.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EducationQualificationResponse {

    private Long id;
    private String universityName;
    private String qualification;
    private LocalDate startDate;
    private LocalDate endDate;
}

