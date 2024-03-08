package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.FullDayLeavesRequest;
import lk.zerocode.api.controller.response.FullDayLeavesResponse;
import lk.zerocode.api.exceptions.CannotCreateLeaveException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.repository.FullDayLeavesRepository;
import lk.zerocode.api.service.FullDayLeaveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FullDayLeavesController {
    private FullDayLeaveService fullDayLeaveService;

    @PostMapping(value = "/employees/{employee-id}/annual-leaves",headers ="X-API-VERSION=V1")
    public FullDayLeavesResponse create(@PathVariable("employee-id") Long empId, @RequestBody FullDayLeavesRequest fullDayLeavesRequest)
            throws EmployeeNotFoundException, CannotCreateLeaveException {
        return fullDayLeaveService.create(empId, fullDayLeavesRequest);
    }
    @PostMapping (value = "/annual-leaves/{leave-id}",headers ="X-API-VERSION=V1")
    public void leaveStatus(@PathVariable("leave-id") Long id,@RequestBody FullDayLeavesRequest fullDayLeavesRequest) {
        fullDayLeaveService.leaveStatus(id,fullDayLeavesRequest);
    }
    @GetMapping(value = "/employees/{employee-id}/annual-leaves",headers ="X-API-VERSION=V1")
    public List<FullDayLeavesResponse> getSpecificEmployeeLeaves(@PathVariable("employee-id")Long empId)throws EmployeeNotFoundException{
        return fullDayLeaveService.getSpecific(empId);
    }
}