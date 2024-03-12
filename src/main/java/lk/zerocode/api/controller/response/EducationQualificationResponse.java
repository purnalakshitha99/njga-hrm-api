package lk.zerocode.api.controller.response;


import lombok.Data;

import java.time.LocalDate;

@Data
public class EducationQualificationResponse {

    private String universityName;
    private String qualification;
    private LocalDate startDate;
    private LocalDate endDate;
}

