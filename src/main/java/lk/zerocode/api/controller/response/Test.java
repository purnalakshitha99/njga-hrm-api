package lk.zerocode.api.controller.response;

import lk.zerocode.api.model.Employee;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Test {
    private Long id;

    private String fingerPrintId;


    private String employee;
}
