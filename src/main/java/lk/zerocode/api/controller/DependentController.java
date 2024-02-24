package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.DependentDetailRequest;
import lk.zerocode.api.controller.response.DependentDetailResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.service.DependentService;
import lk.zerocode.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class DependentController {
    private DependentService dependentService;
    @PostMapping(value = "/employees/{id}/dependents",headers = "version=v1")
    public DependentDetailResponse addDependent(@PathVariable Long id, @RequestBody DependentDetailRequest dependentDetailRequest)throws EmployeeNotFoundException {
        return dependentService.saveDependentDetails(id,dependentDetailRequest);
    }
}
