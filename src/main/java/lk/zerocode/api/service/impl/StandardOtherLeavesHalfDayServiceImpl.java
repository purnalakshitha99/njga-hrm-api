package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.model.*;
import lk.zerocode.api.repository.CurrentWorkDetailRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.repository.MonthlyBasedLeavesRepository;
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

    MonthlyBasedLeavesRepository monthlyBasedLeavesRepository;


    @Override
    public List<OtherLeavesResponse> createStandardHalfDayLeaves(Long empId,OtherLeavesRequest otherLeavesRequest) {

        Optional<CurrentWorkDetail> currentWorkDetailOptional = workDetailRepository.findById(empId);
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);



        List<OtherLeavesResponse> responses = new ArrayList<>();

        if (!employeeOptional.isPresent() && currentWorkDetailOptional.isPresent()) {
            return null;
        }
//        } else if (currentWorkDetailOptional.get().getEmpCategory().getId().equals(4)) {
//            CurrentWorkDetail currentWorkDetail = currentWorkDetailOptional.get();

        else if (currentWorkDetailOptional.get().getEmpCategory().getEmpCategory().equals("standard")) {

            OtherLeave otherLeave = new OtherLeave();
            CurrentWorkDetail currentWorkDetail = currentWorkDetailOptional.get();
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


        }





        return responses;





    }
}
