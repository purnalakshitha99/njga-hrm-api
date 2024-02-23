package lk.zerocode.api.controller.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DependentDetailRequest {
    private Long id;
    private String dependentName;
    private String relationship;
    private LocalDate dob;
}
