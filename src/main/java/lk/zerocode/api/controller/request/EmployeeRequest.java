package lk.zerocode.api.controller.request;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeRequest {

    private Long id;
    private String address;
    private Integer contact_number;
    private Date dob;
    private String email;
    private Long emp_id;
    private String first_name;
    private String last_name;
    private String gender,image_path,nic,work_telephone

}
