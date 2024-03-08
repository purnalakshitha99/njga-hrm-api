package lk.zerocode.api.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FingerPrintDTO {

    @NotBlank
    private String fingerPrintId;
}
