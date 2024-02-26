package lk.zerocode.api.controller.request;

import lk.zerocode.api.model.Employee;
import lombok.Data;
@Data
public class EmergencyContactRequest {

    private Long id;
    private String name;
    private String relationship;
    private String contact;

}
