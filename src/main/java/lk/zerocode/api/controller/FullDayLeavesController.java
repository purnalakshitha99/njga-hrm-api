package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.FullDayLeavesRequest;
import lk.zerocode.api.controller.response.FullDayLeavesResponse;
import lk.zerocode.api.exceptions.CannotCreateLeaveException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.repository.FullDayLeavesRepository;
import lk.zerocode.api.service.FullDayLeaveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class FullDayLeavesController {
    private FullDayLeaveService fullDayLeaveService;

    @PostMapping("/employees/{employee-id}/year-based")
    public FullDayLeavesResponse create(@PathVariable("employee-id") Long emp_id, @RequestBody FullDayLeavesRequest fullDayLeavesRequest)
            throws EmployeeNotFoundException, CannotCreateLeaveException {
        return fullDayLeaveService.create(emp_id, fullDayLeavesRequest);
    }
    @PostMapping ("/year-based/{leave-id}")
    public void leaveStatus(@PathVariable("leave-id") Long id,@RequestBody FullDayLeavesRequest fullDayLeavesRequest) {
        fullDayLeaveService.leaveStatus(id,fullDayLeavesRequest);
    }

    @DeleteMapping("/leavedelete")
    public void delete() {
        fullDayLeaveService.delete();
    }
}