package lk.zerocode.api.controller;

import lk.zerocode.api.controller.dto.FullDayLeavesRequestDTO;
import lk.zerocode.api.controller.response.FullDayLeavesResponse;
import lk.zerocode.api.exceptions.CannotCreateLeaveException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.exceptions.FullDayLeavesNotFoundException;
import lk.zerocode.api.service.FullDayLeaveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FullDayLeavesController {
    private FullDayLeaveService fullDayLeaveService;

    @PostMapping(value = "/employees/{employee-id}/annual-leaves",headers ="X-API-VERSION=V1")
    public FullDayLeavesResponse create(@PathVariable("employee-id") Long empId, @RequestBody FullDayLeavesRequestDTO fullDayLeavesRequestDTO) throws EmployeeNotFoundException, CannotCreateLeaveException {
        return fullDayLeaveService.create(empId, fullDayLeavesRequestDTO);
    }
    @PostMapping (value = "/annual-leaves/{leave-id}",headers ="X-API-VERSION=V1")
    public void leaveStatus(@PathVariable("leave-id") Long id,@RequestBody FullDayLeavesRequestDTO fullDayLeavesRequestDTO)throws FullDayLeavesNotFoundException {
        fullDayLeaveService.leaveStatus(id, fullDayLeavesRequestDTO);
    }
    @GetMapping(value = "/employees/{employee-id}/annual-leaves",headers ="X-API-VERSION=V1")
    public List<FullDayLeavesResponse> getSpecificEmployeeLeaves(@PathVariable("employee-id")Long empId)throws EmployeeNotFoundException{
        return fullDayLeaveService.getSpecific(empId);
    }
}