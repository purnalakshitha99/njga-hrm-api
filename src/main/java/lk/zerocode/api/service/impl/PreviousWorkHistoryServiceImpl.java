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

@Service
@AllArgsConstructor
public class PreviousWorkHistoryServiceImpl implements PreviousWorkHistoryService {
    private EmployeeRepository employeeRepository;
    private PreviousWorkHistoryRepository previousWorkHistoryRepository;
    @Override
    public List<PreviousWorkHistoryResponse> createPreviousWorkHistoryDetails(Long empId, List<PreviousWorkHistoryRequest> previousWorkHistoryRequests) throws EmployeeNotFoundException{

        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found with Id : "+ empId)
        );

        List<PreviousWorkHistoryResponse> previousWorkHistoryResponses= new ArrayList<>();

        for(PreviousWorkHistoryRequest workHistoryRequest : previousWorkHistoryRequests){
            PreviousWorkHistory previousWorkHistory = new PreviousWorkHistory();
            previousWorkHistory.setCompanyName(workHistoryRequest.getCompanyName());
            previousWorkHistory.setDesignation(workHistoryRequest.getDesignation());
            previousWorkHistory.setStartDate(workHistoryRequest.getStartDate());
            previousWorkHistory.setEndDate(workHistoryRequest.getEndDate());
            previousWorkHistory.setEmployee(employee);

            employee.getPreviousWorkHistories().add(previousWorkHistory);
            previousWorkHistoryRepository.save(previousWorkHistory);

            PreviousWorkHistoryResponse workHistoryResponse = PreviousWorkHistoryResponse.builder()
                    .id(previousWorkHistory.getId())
                    .companyName(previousWorkHistory.getCompanyName())
                    .designation(previousWorkHistory.getDesignation())
                    .startDate(previousWorkHistory.getStartDate())
                    .endDate(previousWorkHistory.getEndDate())
                    .build();

            previousWorkHistoryResponses.add(workHistoryResponse);
        }

        return previousWorkHistoryResponses;
    }


    @Override
    public List<PreviousWorkHistoryResponse> getPreviousWorkHistoryByEmpId(Long empId) throws EmployeeNotFoundException {

        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new EmployeeNotFoundException(" Employee not  found in  id number " + empId)
        );

        List<PreviousWorkHistory> previousWorkHistoryList = employeeRepository.findPreviousWorkHistoryByEmployee(employee);

        List<PreviousWorkHistoryResponse> responseList = new ArrayList<>();
        for (PreviousWorkHistory workHistory : previousWorkHistoryList) {

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
    public PreviousWorkHistoryIdResponse updatePreviousWorkHistoryDetails(Long empId, Long previousWorkHistoryId, PreviousWorkHistoryRequest updatedHistoryRequest) throws EmployeeNotFoundException, PreviousWorkHistoryNotFoundException {

        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found with ID: " + empId)
        );

        PreviousWorkHistory previousWorkHistory = previousWorkHistoryRepository.findById(previousWorkHistoryId).orElseThrow(
                () -> new PreviousWorkHistoryNotFoundException("Previous Work History not found with ID : " + previousWorkHistoryId)
        );

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
    public String deletePreviousWorkHistoryDetailsById(Long empId, Long previousWorkHistoryId) throws EmployeeNotFoundException,PreviousWorkHistoryNotFoundException{

        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found with id: " + empId)
        );

        PreviousWorkHistory previousWorkHistory = previousWorkHistoryRepository.findById(previousWorkHistoryId).orElseThrow(
                () -> new PreviousWorkHistoryNotFoundException("Employee not found with id: "+previousWorkHistoryId)
        );
        previousWorkHistoryRepository.deleteById(previousWorkHistoryId);

        return ("Delete successfully previousWorkHistoryId no "+previousWorkHistory.getId()+" of employee with Id: "+empId);
    }
}
