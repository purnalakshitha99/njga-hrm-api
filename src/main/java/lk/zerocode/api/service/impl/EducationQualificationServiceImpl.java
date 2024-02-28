package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.EducationQualificationRequest;
import lk.zerocode.api.controller.response.EducationQualificationResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.EducationQualification;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EducationQualificationRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.EducationQualificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EducationQualificationServiceImpl implements EducationQualificationService {

    private EducationQualificationRepository educationQualificationRepository;
    private EmployeeRepository employeeRepository;
    @Override
    public EducationQualificationResponse create(Long id, EducationQualificationRequest educationQualificationRequest) throws EmployeeNotFoundException {
        Optional<Employee> optionalEmployee= employeeRepository.findById(id);
        if(!optionalEmployee.isPresent()){
           throw new EmployeeNotFoundException("Employee not found!");
        }
        else {
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
    }
    @Override
    public void delete(Long id, Long employeeId) throws  EmployeeNotFoundException{
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(!optionalEmployee.isPresent()){
            throw new EmployeeNotFoundException("Employee not found!");
        }
        else {
            Employee employee=optionalEmployee.get();
            List<EducationQualification> educationQualificationList=employee.getEducationQualificationList();

            EducationQualification qualificationToDelete=educationQualificationList.stream()
                    .filter(educationQualification -> educationQualification.getId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (qualificationToDelete !=null){
                educationQualificationList.remove(qualificationToDelete);
                employeeRepository.save(employee);
                educationQualificationRepository.deleteById(id);
                System.out.println("Education Qualification Delete Successfully");
            }
        }
    }
    @Override
    public List<EducationQualificationResponse> getSpecific(Long id) throws EmployeeNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(!optionalEmployee.isPresent()){
            throw new EmployeeNotFoundException("Employee not found!");
        }
        else {
            Employee employee = optionalEmployee.get();
            List<EducationQualification> allQualifications = educationQualificationRepository.findEducationQualificationsByEmployee(employee);

            List<EducationQualificationResponse> qualificationResponseList = allQualifications.stream()
                    .map(qualification -> EducationQualificationResponse.builder()
                            .id(qualification.getId())
                            .universityName(qualification.getUniversityName())
                            .qualification(qualification.getQualification())
                            .startDate(qualification.getStartDate())
                            .endDate(qualification.getEndDate())
                            .build())
                    .collect(Collectors.toList());
            return qualificationResponseList;
        }
    }
}

