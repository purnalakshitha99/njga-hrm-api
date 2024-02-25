package lk.zerocode.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lk.zerocode.api.controller.request.EducationQualificationRequest;
import lk.zerocode.api.controller.response.EducationQualificationResponse;
import lk.zerocode.api.model.EducationQualification;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EducationQualificationRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.EducationQualificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EducationQualificationServiceImpl implements EducationQualificationService {

    private EducationQualificationRepository educationQualificationRepository;
    private EmployeeRepository employeeRepository;
    @Override
    public EducationQualificationResponse create(Long id, EducationQualificationRequest educationQualificationRequest) {
        Optional<Employee> optionalEmployee= employeeRepository.findById(id);
        employeeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("designation not found"));
        if(optionalEmployee.isPresent()){
            Employee employee= optionalEmployee.get();
            EducationQualification educationQualification=new EducationQualification();
            educationQualification.setUniversityName(educationQualificationRequest.getUniversityName());
            educationQualification.setQualification(educationQualificationRequest.getQualification());
            educationQualification.setStartDate(educationQualificationRequest.getStartDate());
            educationQualification.setEndDate(educationQualificationRequest.getEndDate());
            educationQualification.setEmployee(employee);
            educationQualificationRepository.save(educationQualification);

            EducationQualificationResponse educationQualificationResponse=EducationQualificationResponse.builder()
                    .id(educationQualification.getId())
                    .universityName(educationQualification.getUniversityName())
                    .qualification(educationQualification.getQualification())
                    .startDate(educationQualification.getStartDate())
                    .endDate(educationQualification.getEndDate())
                    .build();
            return educationQualificationResponse;
        }

        return null;
    }
}


//    Optional<Designation> optionalDesignation=designationRepository.findById(designationId);
//        designationRepository.findById(designationId).orElseThrow(()->
//                new EntityNotFoundException("designation not found"));
//
//                if (optionalDesignation.isPresent()) {
//                Designation designation = optionalDesignation.get();
//                Employee employee=new Employee();
//                employee.setFirstName(employeeRequest.getFirstName());
//                employee.setLastName(employeeRequest.getLastName());
//                employee.setDob(employeeRequest.getDob());
//                employee.setAge(employeeRequest.getAge());
//                employee.setGender(employeeRequest.getGender());
//                employee.setNationality(employeeRequest.getNationality());
//                employee.setAddress(employeeRequest.getAddress());
//                employee.setMaritalStatus(employeeRequest.getMaritalStatus());
//                employee.setEmail(employeeRequest.getEmail());
//                employee.setContactNumber(employeeRequest.getContactNumber());
//                employee.setDesignation(designation);
//                employeeRepository.save(employee);
//
//                EmployeeResponse employeeResponse=new EmployeeResponse();
//                employeeResponse.setFirstName(employee.getFirstName());
//                employeeResponse.setLastName(employee.getLastName());
//                employeeResponse.setDob(employee.getDob());
//                employeeResponse.setAge(employee.getAge());
//                employeeResponse.setGender(employee.getGender());
//                employeeResponse.setNationality(employee.getNationality());
//                employeeResponse.setAddress(employee.getAddress());
//                employeeResponse.setMaritalStatus(employee.getMaritalStatus());
//                employeeResponse.setEmail(employee.getEmail());
//                employeeResponse.setContactNumber(employee.getContactNumber());
//                return employeeResponse;
//                }
//                return null;