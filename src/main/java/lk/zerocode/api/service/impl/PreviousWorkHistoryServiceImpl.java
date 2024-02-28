package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.PreviousWorkHistoryRequest;
import lk.zerocode.api.controller.response.PreviousWorkHistoryIdResponse;
import lk.zerocode.api.controller.response.PreviousWorkHistoryResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.exceptions.PreviousWorkHistoryNotFoundException;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.model.PreviousWorkHistory;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.repository.PreviousWorkHistoryRepository;
import lk.zerocode.api.service.PreviousWorkHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PreviousWorkHistoryServiceImpl implements PreviousWorkHistoryService {
    private EmployeeRepository employeeRepository;
    private PreviousWorkHistoryRepository previousWorkHistoryRepository;

    @Override
    public PreviousWorkHistoryIdResponse savePreviousWorkHistoryDetails(Long eid, PreviousWorkHistoryRequest previousWorkHistoryRequest) throws EmployeeNotFoundException {
//        Optional<Employee> employeeOptional = employeeRepository.findById(id);
//
//        if(!employeeOptional.isPresent()){
//            throw new EmployeeNotFoundException("Employee not found in id number "+id);
//        }
//        Employee employee = employeeOptional.get();

        Employee employee = employeeRepository.findById(eid).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found in id number " + eid)
        );

        PreviousWorkHistory previousWorkHistory = new PreviousWorkHistory();
        previousWorkHistory.setCompanyName(previousWorkHistoryRequest.getCompanyName());
        previousWorkHistory.setDesignation(previousWorkHistoryRequest.getDesignation());
        previousWorkHistory.setStartDate(previousWorkHistoryRequest.getStartDate());
        previousWorkHistory.setEndDate(previousWorkHistoryRequest.getEndDate());
        previousWorkHistory.setEmployee(employee);
        previousWorkHistoryRepository.save(previousWorkHistory);

        PreviousWorkHistoryIdResponse previousWorkHistoryResponse = PreviousWorkHistoryIdResponse.builder()
                .id(employee.getId())
                .empName(employee.getFirstName())
                .build();

        return previousWorkHistoryResponse;
    }


    @Override
    public List<PreviousWorkHistoryResponse> getPreviousWorkHistoryByEmpId(Long eid) throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(eid);

        if (!employeeOptional.isPresent()) {
            throw new EmployeeNotFoundException(" Employee not  found in  id number " + eid);
        }
        Employee employee = employeeOptional.get();

        // Assuming you have a method in employeeRepository to get previous work history
        List<PreviousWorkHistory> previousWorkHistoryList = employeeRepository.findPreviousWorkHistoryByEmployee(employee);


        // Convert PreviousWorkHistory objects to PreviousWorkHistoryResponse objects
        List<PreviousWorkHistoryResponse> responseList = new ArrayList<>();
        for (PreviousWorkHistory workHistory : previousWorkHistoryList) {
            // Assuming you have a constructor or a mapper method in PreviousWorkHistoryResponse
            // to convert from PreviousWorkHistory to PreviousWorkHistoryResponse
            PreviousWorkHistoryResponse response = PreviousWorkHistoryResponse.builder()
                    .id(workHistory.getId())
                    .companyName(workHistory.getCompanyName())
                    .designation(workHistory.getDesignation())
                    .startDate(workHistory.getStartDate())
                    .endDate(workHistory.getEndDate())
                    .build();
            responseList.add(response);
        }

        return responseList;

    }


    @Override
    public PreviousWorkHistoryIdResponse updatePreviousWorkHistoryDetails(Long eid, Long previousWorkHistoryId, PreviousWorkHistoryRequest updatedHistoryRequest) throws EmployeeNotFoundException, PreviousWorkHistoryNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(eid);

        if (!employeeOptional.isPresent()) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + eid);
        }

        Employee employee = employeeOptional.get();

        Optional<PreviousWorkHistory> previousWorkHistoryOptional = previousWorkHistoryRepository.findById(previousWorkHistoryId);

        if (!previousWorkHistoryOptional.isPresent()) {
            throw new PreviousWorkHistoryNotFoundException("Previous Work History not found with ID: " + previousWorkHistoryId);
        }

        PreviousWorkHistory previousWorkHistory = previousWorkHistoryOptional.get();

        // Update the fields with the new values
        previousWorkHistory.setCompanyName(updatedHistoryRequest.getCompanyName());
        previousWorkHistory.setDesignation(updatedHistoryRequest.getDesignation());
        previousWorkHistory.setStartDate(updatedHistoryRequest.getStartDate());
        previousWorkHistory.setEndDate(updatedHistoryRequest.getEndDate());

        // Save the updated previous work history
        previousWorkHistoryRepository.save(previousWorkHistory);

        // Build and return the response
        PreviousWorkHistoryIdResponse previousWorkHistoryResponse = PreviousWorkHistoryIdResponse.builder()
                .id(employee.getId())
                .empName(employee.getFirstName())
                .build();

        return previousWorkHistoryResponse;
    }


    @Override
    public String deletePreviousWorkHistoryDetailsById(Long empId, Long previousWorkHistoryId) throws EmployeeNotFoundException{

        Optional<Employee> employeeOptional = employeeRepository.findById(empId);
        if (!employeeOptional.isPresent()) {
            throw new EmployeeNotFoundException("Employee not found with id: " + empId);
        }

        Optional<PreviousWorkHistory> contactOptional = previousWorkHistoryRepository.findById(previousWorkHistoryId);
        if (!contactOptional.isPresent()) {
            return null;
        }

        previousWorkHistoryRepository.deleteById(previousWorkHistoryId);
        return "Delete successful for employee id: " + empId + " and contact id: " + previousWorkHistoryId;
    }


}
