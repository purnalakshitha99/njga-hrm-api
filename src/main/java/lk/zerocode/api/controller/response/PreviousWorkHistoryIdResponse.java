package lk.zerocode.api.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PreviousWorkHistoryIdResponse {
    private Long id;
    private String empName;
}
