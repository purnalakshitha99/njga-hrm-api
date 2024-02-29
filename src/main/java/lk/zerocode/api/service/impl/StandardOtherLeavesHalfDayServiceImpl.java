package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.*;
import lk.zerocode.api.repository.*;
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

    CurrentWorkDetailRepository currentWorkDetailRepository;

    MonthlyBasedLeavesRepository monthlyBasedLeavesRepository;

    EmpCategoryRepository empCategoryRepository;


    @Override
    public List<OtherLeavesResponse> createStandardHalfDayLeaves(Long empId,Long wId,OtherLeavesRequest otherLeavesRequest) throws EmployeeNotFoundException {

        Optional<CurrentWorkDetail> currentWorkDetailOptional = currentWorkDetailRepository.findById(wId);
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);

        CurrentWorkDetail currentWorkDetail = currentWorkDetailOptional.get();

        List<OtherLeavesResponse> responses = new ArrayList<>();

        if (!employeeOptional.isPresent() && currentWorkDetailOptional.isPresent()) {
            throw new EmployeeNotFoundException("employee not found with id :" +empId);
        }
            OtherLeave otherLeave = new OtherLeave();
            Employee employee = employeeOptional.get();

            otherLeave.setName(employee.getFirstName());
            otherLeave.setDepartment(otherLeavesRequest.getDepartment());
            otherLeave.setLeaveType(otherLeavesRequest.getLeaveType());
            otherLeave.setDayType(otherLeavesRequest.getDayType());
            otherLeave.setReason(otherLeavesRequest.getReason());
            otherLeave.setFinancialYear(otherLeavesRequest.getFinancialYear());
            otherLeave.setApplyDate(otherLeavesRequest.getApplyDate());
            otherLeave.setEmployee(currentWorkDetail.getEmployee());

            otherLeavesRepository.save(otherLeave);

            OtherLeavesResponse response = OtherLeavesResponse.builder()
                    .name(otherLeave.getName())
                    .department(otherLeave.getDepartment())
                    .leaveType(otherLeave.getLeaveType())
                    .dayType(otherLeave.getDayType())
                    .reason(otherLeavesRequest.getReason())
                    .financialYear(otherLeave.getFinancialYear())
                    .applyDate(otherLeave.getApplyDate())
                    .build();

            responses.add(response);

        return responses;
    }
}
