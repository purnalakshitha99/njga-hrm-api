package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.DependentDetailRequest;
import lk.zerocode.api.controller.response.DependentDetailMsgResponse;
import lk.zerocode.api.controller.response.DependentDetailResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.DependentDetail;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.DependentRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.DependentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DependentDetailImpl implements DependentService {

    private EmployeeRepository employeeRepository;
    private DependentRepository dependentRepository;
    @Override
    public DependentDetailMsgResponse saveDependentDetails(Long id, DependentDetailRequest dependentDetailRequest) throws EmployeeNotFoundException {Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent()) {
            throw new EmployeeNotFoundException("Employee not Found with id "+id);
        } else {
            Employee employee = employeeOptional.get();

            DependentDetail dependentDetail = new DependentDetail();
            dependentDetail.setDependentsName(dependentDetailRequest.getDependentName());
            dependentDetail.setDob(dependentDetailRequest.getDob());
            dependentDetail.setRelationship(dependentDetailRequest.getRelationship());
            dependentDetail.setEmployee(employee);
            dependentRepository.save(dependentDetail);

            return DependentDetailMsgResponse.builder()
                    .message(dependentDetail.getDependentsName()+" saved.")
                    .build();
        }
    }

    @Override
    public List<DependentDetailResponse> getDependentByEmpId(Long id) throws EmployeeNotFoundException {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(!optionalEmployee.isPresent()){
            throw new EmployeeNotFoundException("Employee not found with id "+id);
        }
        else {
            Employee employee = optionalEmployee.get();
            List<DependentDetail> dependentDetail = dependentRepository.findDependentDetailByEmployee(employee);

            if(dependentDetail.isEmpty()){
                throw new EmployeeNotFoundException("Dependent Not found with Employee Id "+id);
            }
            return dependentDetail.stream()
                    .map(dependentDetails -> DependentDetailResponse.builder()
                            .dependentName(dependentDetails.getDependentsName())
                            .dob(dependentDetails.getDob())
                            .relation(dependentDetails.getRelationship())
                            .build())
                    .collect(Collectors.toList());
        }
    }

    @Override
    public DependentDetailMsgResponse deleteDependentById(Long empId, Long dependentId)throws EmployeeNotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(empId);

        if(!employeeOptional.isPresent()){
            throw new EmployeeNotFoundException("Employee not found with id "+empId);
        }
        else{
            Employee employee=employeeOptional.get();
            Optional<DependentDetail> dependentDetailOptional = dependentRepository.findDependentDetailsByEmployeeAndId(employee,dependentId);

            if(!dependentDetailOptional.isPresent()){
                throw new EmployeeNotFoundException("Dependent not found with id "+dependentId);
            }
            DependentDetail dependentDetail=dependentDetailOptional.get();
            dependentRepository.deleteById(dependentId);

            return DependentDetailMsgResponse.builder()
                    .message("Deleted "+dependentDetail.getDependentsName()+" with id "+dependentDetail.getId())
                    .build();
        }
    }
}