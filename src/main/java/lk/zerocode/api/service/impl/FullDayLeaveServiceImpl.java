package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.FullDayLeavesRequest;
import lk.zerocode.api.controller.response.FullDayLeavesResponse;
import lk.zerocode.api.exceptions.CannotCreateLeaveException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.FullDayLeave;
import lk.zerocode.api.model.Status;
import lk.zerocode.api.model.YearlyBasedLeave;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.repository.FullDayLeavesRepository;
import lk.zerocode.api.repository.YearBasedLeaveRepository;
import lk.zerocode.api.service.FullDayLeaveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FullDayLeaveServiceImpl implements FullDayLeaveService {
    private FullDayLeavesRepository fullDayLeavesRepository;
    private EmployeeRepository employeeRepository;
    private YearBasedLeaveRepository yearBasedLeaveRepository;

    @Override
    public FullDayLeavesResponse create(Long empId, FullDayLeavesRequest fullDayLeavesRequest) throws EmployeeNotFoundException, CannotCreateLeaveException {
        Employee employee = employeeRepository.findEmployeeById(empId).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
        String startDate = String.valueOf(fullDayLeavesRequest.getStartDate().getYear());
        String endDate = String.valueOf(fullDayLeavesRequest.getEndDate().getYear());
        if (!startDate.equals(endDate)) {
            throw new CannotCreateLeaveException("you can't take leaves from two different years.apply separately");
        }
        String category = employee.getCurrentWorkDetails().getEmpCategory().getEmpCategory();
        Optional<YearlyBasedLeave> yearlyBasedLeaveResult = yearBasedLeaveRepository.findYearlyBasedLeaveByCategoryAndType(category, fullDayLeavesRequest.getLeaveType());
        int allowedLeaveCount = yearlyBasedLeaveResult.get().getNoOfDays();
        List<FullDayLeave> takenLeavesByYear = fullDayLeavesRepository.findFullDayLeaveByEmployeeAndLeaveTypeAndFinancialYear(employee, fullDayLeavesRequest.getLeaveType(), startDate);
        int noOfTakenLeaves = 0;
        for (FullDayLeave fullDayLeave : takenLeavesByYear) {
            noOfTakenLeaves = noOfTakenLeaves + fullDayLeave.getNoOfDays();
        }

        if (allowedLeaveCount < noOfTakenLeaves + fullDayLeavesRequest.getNoOfDays() || allowedLeaveCount < fullDayLeavesRequest.getNoOfDays()) {
            throw new CannotCreateLeaveException("exceeded the leave limit");
        }
        FullDayLeave fullDayLeave = new FullDayLeave();
        fullDayLeave.setName(fullDayLeavesRequest.getName());
        fullDayLeave.setApplyDate(LocalDate.now());
        fullDayLeave.setNoOfDays(fullDayLeavesRequest.getNoOfDays());
        fullDayLeave.setStartDate(fullDayLeavesRequest.getStartDate());
        fullDayLeave.setYearBasedLeave(yearlyBasedLeaveResult.get());
        fullDayLeave.setEndDate(fullDayLeavesRequest.getEndDate());
        fullDayLeave.setDepartment(fullDayLeavesRequest.getDepartment());
        fullDayLeave.setFinancialYear(startDate);
        fullDayLeave.setReason(fullDayLeavesRequest.getReason());
        fullDayLeave.setLeaveType(fullDayLeavesRequest.getLeaveType());
        fullDayLeave.setStatus(Status.PENDING);
        fullDayLeave.setEmployee(employee);
        fullDayLeavesRepository.save(fullDayLeave);

        return FullDayLeavesResponse.builder()
                .name(fullDayLeave.getName())
                .applyDate(fullDayLeave.getApplyDate())
                .noOfDays(fullDayLeave.getNoOfDays())
                .startDate(fullDayLeave.getStartDate())
                .endDate(fullDayLeave.getEndDate())
                .approvedPersonName(fullDayLeave.getApprovedPersonName())
                .department(fullDayLeave.getDepartment())
                .financialYear(fullDayLeave.getFinancialYear())
                .reason(fullDayLeave.getReason())
                .status(fullDayLeave.getStatus())
                .build();
    }
    @Override
    public void leaveStatus(Long id, FullDayLeavesRequest fullDayLeavesRequest) {
        Optional<FullDayLeave> optionalFullDayLeave = fullDayLeavesRepository.findById(id);
        if (optionalFullDayLeave.isPresent()) {
            FullDayLeave fullDayLeave = optionalFullDayLeave.get();
            fullDayLeave.setApprovedDate(LocalDate.now());
            fullDayLeave.setApprovedTime(LocalTime.now());
            fullDayLeave.setApprovedPersonName("Viduth");
            fullDayLeave.setStatus(fullDayLeavesRequest.getStatus());
            fullDayLeavesRepository.save(fullDayLeave);
        }
    }
}