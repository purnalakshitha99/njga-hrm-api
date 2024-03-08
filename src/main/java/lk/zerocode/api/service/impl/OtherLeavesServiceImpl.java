package lk.zerocode.api.service.impl;
import lk.zerocode.api.controller.OtherLeavesController;
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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


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

        List<OtherLeave> existingLeaves = otherLeavesRepository.findOtherLeaveByEmployeeAndWantedDateAndWantedTime(employee,otherLeavesRequest.getWantedDate(),otherLeavesRequest.getWontedTime());

        if (!existingLeaves.isEmpty()){
            throw new CannotCreateLeaveException("cant create leave in same date and same time");
        }

        String category = employee.getCurrentWorkDetails().getEmpCategory().getEmpCategory();
        MonthlyBasedLeave monthlyBasedLeave = monthlyBasedLeavesRepository.findMonthlyBasedLeaveByCategoryAndType(category, otherLeavesRequest.getLeaveType()).orElseThrow(
                () -> new EmpCategoryNotFoundException("that emp category not found")
        );

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

    @Override
    public List <OtherLeavesResponse> getLeaves(Long empId)throws EmployeeNotFoundException {

       Employee employee = employeeRepository.findById(empId).orElseThrow(
               ()-> new EmployeeNotFoundException("that employee not in a database")
       );

       List <OtherLeave> otherLeavesList = employee.getOtherLeavesList();

       return otherLeavesList.stream().map(otherLeave -> OtherLeavesResponse.builder().id(otherLeave.getId())
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
                .dayType(otherLeave.getDayType()).build()).toList();
    }


}
