package lk.zerocode.api.controller.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.zerocode.api.model.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BasicDetailsResponse {

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
