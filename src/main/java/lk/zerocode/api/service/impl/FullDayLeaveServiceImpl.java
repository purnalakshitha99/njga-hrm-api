package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.dto.FullDayLeavesRequestDTO;
import lk.zerocode.api.controller.response.FullDayLeavesResponse;
import lk.zerocode.api.exceptions.CannotCreateLeaveException;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.exceptions.FullDayLeavesNotFoundException;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.FullDayLeave;
import lk.zerocode.api.model.Status;
import lk.zerocode.api.model.YearlyBasedLeave;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.repository.FullDayLeavesRepository;
import lk.zerocode.api.repository.YearBasedLeaveRepository;
import lk.zerocode.api.service.FullDayLeaveService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FullDayLeaveServiceImpl implements FullDayLeaveService {
    private FullDayLeavesRepository fullDayLeavesRepository;
    private EmployeeRepository employeeRepository;
    private YearBasedLeaveRepository yearBasedLeaveRepository;
    private ModelMapper modelMapper;

    @Override
    public FullDayLeavesResponse create(Long empId, FullDayLeavesRequestDTO fullDayLeavesRequestDTO) throws EmployeeNotFoundException, CannotCreateLeaveException {
        Employee employee = employeeRepository.findEmployeeById(empId).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
        String startDate = String.valueOf(fullDayLeavesRequestDTO.getStartDate().getYear());
        String endDate = String.valueOf(fullDayLeavesRequestDTO.getEndDate().getYear());
        if (!startDate.equals(endDate)) {
            throw new CannotCreateLeaveException("you can't take leaves from two different years.apply separately");
        }
        List<FullDayLeave> existingLeaves = fullDayLeavesRepository.findFullDayLeaveByEmployeeAndStartDateAndEndDate(employee, fullDayLeavesRequestDTO.getStartDate(), fullDayLeavesRequestDTO.getEndDate());
        if (!existingLeaves.isEmpty()){
            throw new CannotCreateLeaveException("you cant create leaves on same date");
        }
        String category = employee.getCurrentWorkDetails().getEmpCategory().getEmpCategory();
        Optional<YearlyBasedLeave> yearlyBasedLeaveResult = yearBasedLeaveRepository.findYearlyBasedLeaveByCategoryAndType(category, fullDayLeavesRequestDTO.getLeaveType());
        int allowedLeaveCount = yearlyBasedLeaveResult.get().getNoOfDays();
        List<FullDayLeave> takenLeavesByYear = fullDayLeavesRepository.findFullDayLeaveByEmployeeAndLeaveTypeAndFinancialYear(employee, fullDayLeavesRequestDTO.getLeaveType(), startDate);
        int noOfTakenLeaves = 0;
        for (FullDayLeave fullDayLeave : takenLeavesByYear) {
            noOfTakenLeaves = noOfTakenLeaves + fullDayLeave.getNoOfDays();
        }

        if (allowedLeaveCount < noOfTakenLeaves + fullDayLeavesRequestDTO.getNoOfDays() || allowedLeaveCount < fullDayLeavesRequestDTO.getNoOfDays()) {
            throw new CannotCreateLeaveException("exceeded the leave limit");
        }
        FullDayLeave fullDayLeave = modelMapper.map(fullDayLeavesRequestDTO,FullDayLeave.class);
        fullDayLeave.setApplyDate(LocalDate.now());
        fullDayLeave.setYearBasedLeave(yearlyBasedLeaveResult.get());
        fullDayLeave.setFinancialYear(startDate);
        fullDayLeave.setStatus(Status.PENDING);
        fullDayLeave.setEmployee(employee);
        fullDayLeavesRepository.save(fullDayLeave);

        return modelMapper.map(fullDayLeave, FullDayLeavesResponse.class);
    }
    @Override
    public void leaveStatus(Long id, FullDayLeavesRequestDTO fullDayLeavesRequestDTO) throws FullDayLeavesNotFoundException {
        Optional<FullDayLeave> optionalFullDayLeave = fullDayLeavesRepository.findById(id);
        if (!optionalFullDayLeave.isPresent()) {
            throw new FullDayLeavesNotFoundException(" not found");
        }else {
            FullDayLeave fullDayLeave = optionalFullDayLeave.get();
            fullDayLeave.setApprovedDate(LocalDate.now());
            fullDayLeave.setApprovedTime(LocalTime.now());
            fullDayLeave.setApprovedPersonName("Viduth");
            fullDayLeave.setStatus(fullDayLeavesRequestDTO.getStatus());
            fullDayLeavesRepository.save(fullDayLeave);
        }
    }
    @Override
    public List<FullDayLeavesResponse> getSpecific(Long empId) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findEmployeeById(empId).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
        List<FullDayLeave> allLeavesList = fullDayLeavesRepository.findFullDayLeaveByEmployee(employee);
        List<FullDayLeavesResponse> allSpecificLeavesResponse = allLeavesList.stream()
                .map(allLeaves -> modelMapper.map(allLeaves,FullDayLeavesResponse.class))
                .collect(Collectors.toList());
        return allSpecificLeavesResponse;
    }
}