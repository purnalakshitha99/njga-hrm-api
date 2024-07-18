package lk.zerocode.api.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.zerocode.api.model.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BasicDetailsRequest {

    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;
    private String contactNumber;
    private String email;
    private String imagePath;
    private String nic;
    private String workTelephone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
