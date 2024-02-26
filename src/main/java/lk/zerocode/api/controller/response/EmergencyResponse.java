package lk.zerocode.api.controller.response;

import jakarta.persistence.ManyToOne;
import lk.zerocode.api.model.Employee;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmergencyResponse {

    private Long id;
    private String name;
    private String relationship;
    private String contact;
    private Long employeeId;
}
