package lk.zerocode.api.controller.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EducationQualificationRequest {

    private String universityName;
    private String qualification;
    private LocalDate startDate;
    private LocalDate endDate;
}
