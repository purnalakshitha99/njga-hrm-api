package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.model.CurrentWorkDetail;
import lk.zerocode.api.model.Department;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.OtherLeave;
import lk.zerocode.api.repository.CurrentWorkDetailRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.repository.OtherLeavesRepository;
import lk.zerocode.api.service.StandardOtherLeavesHalfDayService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StandardOtherLeavesHalfDayServiceImpl implements StandardOtherLeavesHalfDayService {

    EmployeeRepository employeeRepository;

    OtherLeavesRepository otherLeavesRepository;

    CurrentWorkDetailRepository workDetailRepository;

    @Override
    public List<OtherLeavesResponse> createStandardHalfDayLeaves(Long empId, List<OtherLeavesRequest> otherLeavesRequests) {

        Optional<Employee> employeeOptional = employeeRepository.findById(empId);

        List<OtherLeavesResponse> responses = new ArrayList<>();

        Employee employee = employeeOptional.get();

        if (!employeeOptional.isPresent()) {
            return null;
        }

        for (OtherLeavesRequest otherLeavesRequest : otherLeavesRequests){
            OtherLeave otherLeave = new OtherLeave();
            otherLeave.setName(otherLeavesRequest.getName());
            otherLeave.setDepartment(otherLeavesRequest.getDepartment());
            otherLeave.setLeaveType(otherLeavesRequest.getLeaveType());
            otherLeave.setDayType(otherLeavesRequest.getDayType());
            otherLeave.setReason(otherLeavesRequest.getReason());
            otherLeave.setFinancialYear(otherLeavesRequest.getFinancialYear());
            otherLeave.setApplyDate(otherLeavesRequest.getApplyDate());
            otherLeave.setApprovedPersonName(otherLeavesRequest.getApprovedPersonName());
            otherLeave.setApprovedDate(otherLeavesRequest.getApprovedDate());
            otherLeave.setApprovedTime(otherLeavesRequest.getApprovedTime());
            otherLeave.setActualCheckIn(otherLeavesRequest.getActualCheckIn());
            otherLeave.setActualCheckOut(otherLeavesRequest.getActualCheckOut());
            otherLeave.setRequiredCheckIn(otherLeavesRequest.getRequiredCheckIn());
            otherLeave.setRequiredCheckOut(otherLeavesRequest.getRequiredCheckOut());
            otherLeave.setStatus(otherLeavesRequest.getStatus());
            otherLeave.setEmployee(employee);
            otherLeave.setFingerPrint(otherLeavesRequest.getFingerPrint());

            otherLeavesRepository.save(otherLeave);

            OtherLeavesResponse response = OtherLeavesResponse.builder()
                    .name(otherLeave.getName())
                    .department(otherLeave.getDepartment())
                    .leaveType(otherLeave.getLeaveType())
                    .dayType(otherLeave.getDayType())
                    .reason(otherLeave.getReason())
                    .financialYear(otherLeave.getFinancialYear())
                    .applyDate(otherLeave.getApplyDate())
                    .approvedPersonName(otherLeave.getApprovedPersonName())
                    .approvedDate(otherLeave.getApprovedDate())
                    .approvedTime(otherLeave.getApprovedTime())
                    .actualCheckIn(otherLeave.getActualCheckIn())
                    .actualCheckOut(otherLeave.getActualCheckOut())
                    .requiredCheckIn(otherLeave.getRequiredCheckIn())
                    .requiredCheckOut(otherLeave.getRequiredCheckOut())
                    .status(otherLeave.getStatus())
                    .employee(otherLeave.getEmployee())
                    .build();

            responses.add(response);


        }

        return responses;
    }


}
