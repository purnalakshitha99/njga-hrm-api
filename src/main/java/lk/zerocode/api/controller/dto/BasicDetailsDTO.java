package lk.zerocode.api.controller.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lk.zerocode.api.model.Gender;
import lombok.Data;


import java.time.LocalDate;

@Data
public class BasicDetailsDTO {

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
