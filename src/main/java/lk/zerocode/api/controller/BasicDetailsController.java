package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.BasicDetailsRequest;
import lk.zerocode.api.controller.response.BasicDetailsResponse;
import lk.zerocode.api.controller.response.IdResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
public class BasicDetailsController {

    private EmployeeService employeeService;
    @PostMapping("/employee")
    public IdResponse addEmployeeDetails(@RequestBody BasicDetailsRequest basicDetailsRequest)throws EmployeeNotFoundException {
        return employeeService.saveBasicDetails(basicDetailsRequest);
    }
    @GetMapping("/{emp_id}/employee")
    public BasicDetailsResponse getEmployeeByEmpId(@PathVariable("emp_id") String id) throws EmployeeNotFoundException{
        return employeeService.getByEmpId(id);
    }
    @GetMapping("/{emp_email}/employee2")
    public BasicDetailsResponse getEmployeeByEmail(@PathVariable("emp_email") String email) throws EmployeeNotFoundException{
        return employeeService.getByEmpEmail(email);
    }
}
