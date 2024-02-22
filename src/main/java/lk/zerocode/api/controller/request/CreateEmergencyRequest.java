package lk.zerocode.api.controller.request;

import jakarta.persistence.ManyToOne;
import lk.zerocode.api.model.Employee;
import lombok.Data;
@Data
public class CreateEmergencyRequest {

    private Long id;
    private String name;
    private String relationship;
    private String contact;
    private Employee employee;
}
