package lk.zerocode.api.service.impl;
import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.exceptions.CannotCreateLeaveException;
import lk.zerocode.api.exceptions.EmpCategoryNotFoundException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.*;
import lk.zerocode.api.repository.*;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.service.OtherLeavesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OtherLeavesServiceImpl implements OtherLeavesService {


    private OtherLeavesRepository otherLeavesRepository;
    private EmployeeRepository employeeRepository;
    private MonthlyBasedLeavesRepository monthlyBasedLeavesRepository;

    @Override
    public OtherLeavesResponse createLeave(Long empId,OtherLeavesRequest otherLeavesRequest)throws EmployeeNotFoundException,EmpCategoryNotFoundException, CannotCreateLeaveException {

        Year year = Year.of(Year.now().getValue());


        if (!year.equals(otherLeavesRequest.getFinancialYear())) {
            throw new CannotCreateLeaveException("Cannot create more than 7 casual leaves for standard category.");

        }

        // Get the current local date
        LocalDate currentDate = LocalDate.now();

        // Get the current local time
        LocalTime currentTime = LocalTime.now();

        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new EmployeeNotFoundException("that employee not in a database")
        );

        String category = employee.getCurrentWorkDetails().getEmpCategory().getEmpCategory();
        MonthlyBasedLeave monthlyBasedLeave = monthlyBasedLeavesRepository.findMonthlyBasedLeaveByCategoryAndType(category, otherLeavesRequest.getLeaveType()).orElseThrow(
                () -> new EmpCategoryNotFoundException("that emp category not found")
        );

//        int allowedLeaveCount = monthlyBasedLeave.getNoOfDays();
        int allowedHours = monthlyBasedLeave.getNoOfHours();

        System.out.println("alowed hours : " + allowedHours);
        List<OtherLeave> takenLeaves = otherLeavesRepository.findOtherLeaveByEmployeeAndLeaveType(employee, otherLeavesRequest.getLeaveType());

        float noOfTakenHours = 0;
        if (takenLeaves.isEmpty()) {
            noOfTakenHours = 1;
        }
        for (OtherLeave otherLeave : takenLeaves) {

            if (otherLeavesRequest.getLeaveType().equals("gatepass")){

                noOfTakenHours = noOfTakenHours+1;
            }else {
                noOfTakenHours = (noOfTakenHours + otherLeave.getHours());

            }
        }

        if (otherLeavesRequest.getLeaveType().equals("gatepass")){

            if (allowedHours< noOfTakenHours){
                throw new CannotCreateLeaveException("can not create leave");
            }

            OtherLeave otherLeave = new OtherLeave();

            otherLeave.setLeaveType(otherLeavesRequest.getLeaveType());
            otherLeave.setWantedDate(otherLeavesRequest.getWantedDate());
            otherLeave.setWantedTime(otherLeavesRequest.getWontedTime());
            otherLeave.setFinancialMonth(otherLeavesRequest.getFinancialMonth());
            otherLeave.setFinancialYear(otherLeavesRequest.getFinancialYear());
            otherLeave.setReason(otherLeavesRequest.getReason());

            otherLeave.setDepartment(employee.getCurrentWorkDetails().getDepartment().getName());
            otherLeave.setName(employee.getFirstName());

            otherLeave.setStatus(Status.PENDING);
            otherLeave.setHours(noOfTakenHours);
            otherLeave.setApplyTime(currentTime);
            otherLeave.setApplyDate(currentDate);

            otherLeave.setEmployee(employee);

            otherLeavesRepository.save(otherLeave);

            return OtherLeavesResponse.builder()
                    .id(otherLeave.getId())
                    .name(otherLeave.getName())
                    .department(otherLeave.getDepartment())
                    .leaveType(otherLeave.getLeaveType())
                    .reason(otherLeave.getReason())
                    .financialMonth(otherLeave.getFinancialMonth())
                    .financialYear(otherLeave.getFinancialYear())
                    .applyDate(otherLeave.getApplyDate())
                    .applyTime(otherLeave.getApplyTime())
                    .wantedDate(otherLeave.getWantedDate())
                    .wantedTime(otherLeave.getWantedTime())
                    .status(otherLeave.getStatus())
                    .hours(otherLeave.getHours())
                    .build();
        }

        return null;
    }
    }
