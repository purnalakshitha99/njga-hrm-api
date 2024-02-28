package lk.zerocode.api.service.impl;
import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.OtherLeavesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OtherLeavesServiceImpl implements OtherLeavesService {

    EmployeeRepository employeeRepository;

    @Override
    public List<OtherLeavesResponse> createStandardOtherLeaves(Long empId, OtherLeavesRequest otherLeavesRequest) {
        return null;
    }
}
