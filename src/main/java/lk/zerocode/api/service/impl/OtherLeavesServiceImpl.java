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
    public OtherLeavesResponse createLeave(Long empId, OtherLeavesRequest otherLeavesRequest) throws EmployeeNotFoundException, EmpCategoryNotFoundException, CannotCreateLeaveException {


        // Get the current local date
        LocalDate currentDate = LocalDate.now();

        // Get the current local time
        LocalTime currentTime = LocalTime.now();



        String year = String.valueOf(otherLeavesRequest.getWantedDate().getYear());
        String month = String.valueOf(otherLeavesRequest.getWantedDate().getMonth().getValue());

        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new EmployeeNotFoundException("that employee not in a database")
        );

        String category = employee.getCurrentWorkDetails().getEmpCategory().getEmpCategory();
        MonthlyBasedLeave monthlyBasedLeave = monthlyBasedLeavesRepository.findMonthlyBasedLeaveByCategoryAndType(category, otherLeavesRequest.getLeaveType()).orElseThrow(
                () -> new EmpCategoryNotFoundException("that emp category not found")
        );

//      int allowedLeaveCount = monthlyBasedLeave.getNoOfDays();
        int allowedHours = monthlyBasedLeave.getNoOfHours();

        List<OtherLeave> takenLeaves = otherLeavesRepository.findOtherLeaveByEmployeeAndLeaveTypeAndFinancialYearAndFinancialMonth(employee, otherLeavesRequest.getLeaveType(),year,month);

        float noOfTakenHours = 0;

        for (OtherLeave otherLeave : takenLeaves){
            noOfTakenHours = noOfTakenHours+otherLeave.getHours();
        }

        if (allowedHours<noOfTakenHours+otherLeavesRequest.getHours()){
            throw new CannotCreateLeaveException("cant create");
        }

        if (!otherLeavesRequest.getLeaveType().equals("halfday")){
            otherLeavesRequest.setDayType(null);
        }

        OtherLeave otherLeave = new OtherLeave();


        otherLeave.setWantedDate(otherLeavesRequest.getWantedDate());
        otherLeave.setWantedTime(otherLeavesRequest.getWontedTime());
        otherLeave.setFinancialMonth(month);
        otherLeave.setFinancialYear(year);
        otherLeave.setReason(otherLeavesRequest.getReason());
        otherLeave.setLeaveType(otherLeavesRequest.getLeaveType());

        otherLeave.setDepartment(employee.getCurrentWorkDetails().getDepartment().getName());
        otherLeave.setName(employee.getFirstName());

        otherLeave.setStatus(Status.PENDING);
        otherLeave.setHours(otherLeavesRequest.getHours());
        otherLeave.setApplyTime(currentTime);
        otherLeave.setApplyDate(currentDate);

        otherLeave.setEmployee(employee);

        otherLeave.setDayType(otherLeavesRequest.getDayType());

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
                .dayType(otherLeave.getDayType())
                .build();

    }
}
