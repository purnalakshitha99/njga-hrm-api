package lk.zerocode.api.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AttandanceSearchDTO {

    private LocalDate date;
    private Long id;
}
