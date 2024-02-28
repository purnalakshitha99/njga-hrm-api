package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.DependentDetailRequest;
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
    public DependentDetailResponse saveDependentDetails(Long id, DependentDetailRequest dependentDetailRequest) throws EmployeeNotFoundException {Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent()) {
            throw new EmployeeNotFoundException("Employee not Found");
        } else {
            Employee employee = employeeOptional.get();

            DependentDetail dependentDetail = new DependentDetail();
            dependentDetail.setDependentsName(dependentDetailRequest.getDependentName());
            dependentDetail.setDob(dependentDetailRequest.getDob());
            dependentDetail.setRelationship(dependentDetailRequest.getRelationship());
            dependentDetail.setEmployee(employee);
            dependentRepository.save(dependentDetail);

            DependentDetailResponse dependentDetailResponse = DependentDetailResponse.builder()
                    .dependentName(dependentDetail.getDependentsName())
                    .dob(dependentDetail.getDob())
                    .relation(dependentDetail.getRelationship())
                    .build();
            return dependentDetailResponse;
        }
    }

    @Override
    public List<DependentDetailResponse> getDependentByEmpId(Long id) throws EmployeeNotFoundException {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(!optionalEmployee.isPresent()){
            throw new EmployeeNotFoundException("Employee not found");
        }
        else {
            Employee employee = optionalEmployee.get();
            List<DependentDetail> dependentDetail = dependentRepository.findDependentDetailByEmployee(employee);
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
    public void deleteDependentById(Long id) {
        dependentRepository.deleteById(id);
    }

    //    @Override
//    public Optional<DependentDetailResponse> updateDependentDetail(Long id, DependentDetailRequest dependentDetailRequest)throws EmployeeNotFoundException{
//
//        Optional<DependentDetail> optionalDependentDetail = dependentRepository.findById(id);
//
//        if(!optionalDependentDetail.isPresent()){
//            throw new EmployeeNotFoundException("Dependent Not Found!");
//        }
//        else {
//            return optionalDependentDetail
//                    .map(dependentDetailUpdated -> {
//                        dependentDetailUpdated.setDependentsName(dependentDetailRequest.getDependentName());
//                        dependentDetailUpdated.setDob(dependentDetailRequest.getDob());
//                        dependentDetailUpdated.setRelationship(dependentDetailRequest.getRelationship());
//                        dependentRepository.save(dependentDetailUpdated);
//
//                        DependentDetailResponse dependentDetailResponse = DependentDetailResponse.builder()
//                                .dependentName(dependentDetailUpdated.getDependentsName())
//                                .relation(dependentDetailUpdated.getRelationship())
//                                .dob(dependentDetailUpdated.getDob())
//                                .build();
//                        return dependentDetailResponse;
//                    });
//        }
//    }
}
