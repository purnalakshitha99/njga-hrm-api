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

//    EmployeeRepository employeeRepository;
    private OtherLeavesRepository otherLeavesRepository;
    private EmployeeRepository employeeRepository;
    private EmpCategoryRepository empCategoryRepository;
    private MonthlyBasedLeavesRepository monthlyBasedLeavesRepository;

    @Override
    public OtherLeavesResponse createLeave(Long empId,OtherLeavesRequest otherLeavesRequest)throws EmployeeNotFoundException,EmpCategoryNotFoundException, CannotCreateLeaveException {

        Year year = Year.of(Year.now().getValue());


        if(!year.equals(otherLeavesRequest.getFinancialYear())){
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

        System.out.println("alowed hours : "+allowedHours);
        List<OtherLeave> takenLeaves = otherLeavesRepository.findOtherLeaveByEmployeeAndLeaveType(employee, otherLeavesRequest.getLeaveType());




        int noTakenHours = 0;

        for (OtherLeave otherLeave : takenLeaves) {


            noTakenHours = noTakenHours + otherLeave.getHours();
            System.out.println("other leave : "+ otherLeave.getHours());


        }

        System.out.println("num of taken hours :"+noTakenHours);
        System.out.println("other leave request hours: "+otherLeavesRequest.getHours());
        System.out.println("sum of other leaves and no taken hours: "+(noTakenHours+otherLeavesRequest.getHours()));


        if (otherLeavesRequest.getLeaveType().equals("gatepass")){
            System.out.println("gate pass ekata awa");

            System.out.println("mulin "+(noTakenHours+otherLeavesRequest.getHours()));
            if (allowedHours < (noTakenHours+otherLeavesRequest.getHours()) || allowedHours< otherLeavesRequest.getHours()){
                System.out.println("if eka athule :"+noTakenHours+otherLeavesRequest.getHours());
                throw new CannotCreateLeaveException("can not create leave");
            }
            OtherLeave otherLeave = new OtherLeave();

            otherLeave.setLeaveType(otherLeavesRequest.getLeaveType());
            otherLeave.setHours(otherLeavesRequest.getHours());
            otherLeave.setWantedDate(otherLeavesRequest.getWantedDate());
            otherLeave.setWantedTime(otherLeavesRequest.getWontedTime());
            otherLeave.setFinancialMonth(otherLeavesRequest.getFinancialMonth());
            otherLeave.setFinancialMonth(otherLeavesRequest.getFinancialMonth());
            otherLeave.setApplyTime(otherLeave.getApplyTime());
            otherLeave.setApplyDate(otherLeave.getApplyDate());

            otherLeavesRepository.save(otherLeave);
        }






        return null;






    }


}
