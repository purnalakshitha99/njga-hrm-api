package lk.zerocode.api.controller.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lk.zerocode.api.model.Gender;
import lombok.Data;


import java.time.LocalDate;

@Data
public class BasicDetailsDTO {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Pattern(regexp = "[0-9]{9}[Vv]")
    private String nic;

    @Past
    private LocalDate dob;

    @Email
    private String email;

    private String address;

    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$")
    private String contactNumber;

    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$")
    private String workTelephone;

    private String imagePath;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
