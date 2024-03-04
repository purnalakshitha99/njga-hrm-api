package lk.zerocode.api.controller;


import lk.zerocode.api.controller.request.EmergencyContactRequest;
import lk.zerocode.api.controller.request.PreviousWorkHistoryRequest;

import lk.zerocode.api.controller.response.EmergencyResponse;
import lk.zerocode.api.controller.response.PreviousWorkHistoryIdResponse;
import lk.zerocode.api.controller.response.PreviousWorkHistoryResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.exceptions.PreviousWorkHistoryNotFoundException;
import lk.zerocode.api.service.PreviousWorkHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PreviousWorkHistoryController {
    private PreviousWorkHistoryService previousWorkHistoryService;


    @PostMapping(value ="employees/{eid}/previous-work-histories",headers="version=v1")
    public List<PreviousWorkHistoryResponse> createPreviousWorkHistoty(@PathVariable Long eid, @RequestBody List<PreviousWorkHistoryRequest> previousWorkHistoryRequests)throws EmployeeNotFoundException{
        return previousWorkHistoryService.createPreviousWorkHistoryDetails(eid,previousWorkHistoryRequests);
    }




    @GetMapping(value = "employees/{eid}/previousWorkHistories",headers="version=v1")
    public List<PreviousWorkHistoryResponse> getPreviousWorkHistoryByEmpId(@PathVariable("eid") Long eid) throws EmployeeNotFoundException {

        return previousWorkHistoryService.getPreviousWorkHistoryByEmpId(eid);

    }


    @PutMapping(value="employees/{eid}/previousWorkHistories/{historyId}",headers="version=v1")
    public PreviousWorkHistoryIdResponse updatePreviousWorkHistoryDetails(@PathVariable Long eid, @PathVariable Long historyId,
                                                                          @RequestBody PreviousWorkHistoryRequest updatedHistoryRequest) throws EmployeeNotFoundException, PreviousWorkHistoryNotFoundException {

        return previousWorkHistoryService.updatePreviousWorkHistoryDetails(eid,historyId,updatedHistoryRequest);
    }

    @DeleteMapping(value = "employees/{empId}/previousWorkHistories/{historyId}",headers = "version=v1")
    public String deleteEmergencyContactById(@PathVariable("empId") Long empId, @PathVariable("historyId") Long previousWorkHistoryId) throws EmployeeNotFoundException {
        return previousWorkHistoryService.deletePreviousWorkHistoryDetailsById(empId,previousWorkHistoryId);
    }




}
