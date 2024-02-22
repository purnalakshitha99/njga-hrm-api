package lk.zerocode.api.controller.request;

import lombok.Data;

@Data
public class DependentDetailReq {
    private String dependentName;
    private String relationship;
}
