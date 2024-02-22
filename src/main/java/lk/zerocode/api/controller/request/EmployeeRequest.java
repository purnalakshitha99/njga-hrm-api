package lk.zerocode.api.controller.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.zerocode.api.model.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeRequest {

    private Long id;
    private String address;
    private String contact_number;
    private Date dob;
    private String email;
    private Long emp_id;
    private String first_name;
    private String last_name;
    private String image_path;
    private String nic;
    private String work_telephone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
