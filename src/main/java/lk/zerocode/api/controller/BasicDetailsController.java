package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.EmployeeRequest;
import lk.zerocode.api.controller.response.BasicDetailsResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BasicDetailsController {

    private EmployeeService employeeService;
    @PostMapping("/employees/employee")
    public BasicDetailsResponse addEmployeeDetails(@RequestBody EmployeeRequest employeeRequest)throws EmployeeNotFoundException {
        return employeeService.saveBasicDetails(employeeRequest);
    }
}
