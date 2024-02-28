package lk.zerocode.api.controller;

import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.service.OtherLeavesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OtherLeavesController {

    OtherLeavesService otherLeavesService;

//    @PostMapping(value = "/employee/{emp-id}/otherleaves" , headers = "version=v1")
//    public List<OtherLeavesResponse> createStandardOtherLeave(@PathVariable("emp-id") Long empId, @RequestBody List<OtherLeavesRequest> otherLeavesRequests){
//        return otherLeavesService.createStandardOtherLeaves(empId,otherLeavesRequests);
//    }

}
