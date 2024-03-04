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
    public List<OtherLeavesResponse> createStandardHalfDayLeaves(Long empId,OtherLeavesRequest otherLeavesRequest) throws EmployeeNotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(empId);

        Optional<CurrentWorkDetail> currentWorkDetailOptional = currentWorkDetailRepository.findById(empId);

        CurrentWorkDetail currentWorkDetail = currentWorkDetailOptional.get();

        EmpCategory empCategory = currentWorkDetail.getEmpCategory();

        List<OtherLeavesResponse> responses = new ArrayList<>();

        if (!currentWorkDetailOptional.isPresent() && empCategory == null || !"standard".equals(empCategory.getEmpCategory())
        ) {

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
            otherLeave.setWantedDate(otherLeavesRequest.getWantedDate());
            otherLeave.setWantedTime(otherLeavesRequest.getWontedTime());
            otherLeave.setStatus(Status.PENDING);

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
