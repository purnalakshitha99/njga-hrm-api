package lk.zerocode.api.controller.request;

import lombok.Data;

@Data
public class DependentDetailRequest {
    private String dependentName;
    private String relationship;
}
