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

import java.time.Month;
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


        Optional<CurrentWorkDetail> currentWorkDetailOptional = currentWorkDetailRepository.findById(empId);
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);
        String empCategory = currentWorkDetailOptional.get().getEmpCategory().getEmpCategory();

        List<OtherLeavesResponse> responses = new ArrayList<>();

        if (!currentWorkDetailOptional.isPresent()){
            throw new EmployeeNotFoundException("employee not found with id " + empId);
        }
        else if (empCategory.equals("standard")) {
            Employee employee = employeeOptional.get();
            CurrentWorkDetail currentWorkDetail = currentWorkDetailOptional.get();

            OtherLeave otherLeave = new OtherLeave();
            otherLeave.setName(employee.getFirstName());
            otherLeave.setDepartment(otherLeavesRequest.getDepartment());
            otherLeave.setLeaveType(otherLeavesRequest.getLeaveType());
            otherLeave.setDayType(otherLeavesRequest.getDayType());
            otherLeave.setReason(otherLeavesRequest.getReason());
            otherLeave.setFinancialYear(otherLeavesRequest.getFinancialYear());
//            otherLeave.setApplyDate(otherLeavesRequest.getApplyDate());
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

        } else if (empCategory.equals("pl")) {
            Employee employee = employeeOptional.get();
            CurrentWorkDetail currentWorkDetail = currentWorkDetailOptional.get();

            OtherLeave otherLeave = new OtherLeave();
            otherLeave.setName(employee.getFirstName());
            otherLeave.setDepartment(otherLeavesRequest.getDepartment());
            otherLeave.setLeaveType(otherLeavesRequest.getLeaveType());
            otherLeave.setDayType(otherLeavesRequest.getDayType());
            otherLeave.setReason(otherLeavesRequest.getReason());
            otherLeave.setFinancialYear(otherLeavesRequest.getFinancialYear());
//            otherLeave.setApplyDate(otherLeavesRequest.getApplyDate());
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
        else {
            throw new EmployeeNotFoundException("you are not in the current work details table with id "+empId );
        }
    }
}
