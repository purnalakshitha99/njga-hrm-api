package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.DependentDetailRequest;
import lk.zerocode.api.controller.response.DependentDetailMsgResponse;
import lk.zerocode.api.controller.response.DependentDetailResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.service.DependentService;
import lk.zerocode.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class DependentController {
    private DependentService dependentService;
    @PostMapping(value = "/employees/{id}/dependent",headers = "version=v1")
    public DependentDetailMsgResponse addDependentDetails(@PathVariable ("id") Long id, @RequestBody DependentDetailRequest dependentDetailRequest)throws EmployeeNotFoundException {
        return dependentService.saveDependentDetails(id,dependentDetailRequest);
    }
    @GetMapping(value = "/employees/{id}/dependents",headers = "version=v1")
    public List<DependentDetailResponse> getDependentByEmpId(@PathVariable("id")Long id)throws EmployeeNotFoundException{
        return dependentService.getDependentByEmpId(id);
    }
//    @PutMapping(value = "/dependents/{id}/dependent",headers = "version=v1")
//    @PutMapping("/dependents/{id}/dependent")
//    public Optional<DependentDetailResponse> updateDependentDetails(@PathVariable("id")Long id,@RequestBody DependentDetailRequest dependentDetailRequest)throws EmployeeNotFoundException{
//        return dependentService.updateDependentDetail(id,dependentDetailRequest);
//    }
    @DeleteMapping("/employees/{emp_id}/dependents/{dependent_id}")
    public DependentDetailMsgResponse deleteDependent(@PathVariable ("emp_id") Long emp_id, @PathVariable("dependent_id") Long dependent_id) throws EmployeeNotFoundException{
        return dependentService.deleteDependentById(emp_id,dependent_id);
    }
}
