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
import java.util.Optional;

@Service
@AllArgsConstructor
public class FullDayLeaveServiceImpl implements FullDayLeaveService {
    private FullDayLeavesRepository fullDayLeavesRepository;
    private EmployeeRepository employeeRepository;
    private YearBasedLeaveRepository yearBasedLeaveRepository;
    @Override
    public FullDayLeavesResponse create(Long emp_id, FullDayLeavesRequest fullDayLeavesRequest) throws EmployeeNotFoundException, CannotCreateLeaveException {
        Employee employee = employeeRepository.findEmployeeById(emp_id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
        String category = employee.getCurrentWorkDetails().getEmpCategory().getEmpCategory();
        Optional<YearlyBasedLeave> yearlyBasedLeaveResult = yearBasedLeaveRepository.findYearlyBasedLeaveByCategoryAndType(category, fullDayLeavesRequest.getLeaveType());

        if (fullDayLeavesRequest.getLeaveType().equalsIgnoreCase("casual") && category.equalsIgnoreCase("standard")) {
            int casualLeavesCount = fullDayLeavesRepository.countByYearBasedLeaveCategoryAndLeaveType(category, "casual");
            if (casualLeavesCount >= 7) {
                throw new CannotCreateLeaveException("Cannot create more than 7 casual leaves for standard category.");
            }
        }

        FullDayLeave fullDayLeave = new FullDayLeave();
        fullDayLeave.setName(fullDayLeavesRequest.getName());
        fullDayLeave.setApplyDate(LocalDate.now());
        fullDayLeave.setNoOfDays(fullDayLeavesRequest.getNoOfDays());
        fullDayLeave.setStartDate(fullDayLeavesRequest.getStartDate());
        fullDayLeave.setYearBasedLeave(yearlyBasedLeaveResult.get());
        fullDayLeave.setEndDate(fullDayLeavesRequest.getEndDate());
        fullDayLeave.setApprovedPersonName(fullDayLeavesRequest.getApprovedPersonName());
        fullDayLeave.setDepartment(fullDayLeavesRequest.getDepartment());
        fullDayLeave.setFinancialYear(fullDayLeavesRequest.getFinancialYear());
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
    public void delete() {
        fullDayLeavesRepository.deleteAll();
    }
}
