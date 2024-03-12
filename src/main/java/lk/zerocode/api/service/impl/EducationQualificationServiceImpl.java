package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.dto.EducationQualificationRqDTO;
import lk.zerocode.api.controller.response.EducationQualificationResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.EducationQualification;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EducationQualificationRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.EducationQualificationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EducationQualificationServiceImpl implements EducationQualificationService {

    private EducationQualificationRepository educationQualificationRepository;
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    @Override
    public EducationQualificationResponse create(Long id, EducationQualificationRqDTO educationQualificationRqDTO) throws EmployeeNotFoundException {
        Employee employee=employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));

            EducationQualification educationQualification= modelMapper.map(educationQualificationRqDTO,EducationQualification.class);
            educationQualification.setEmployee(employee);
            educationQualificationRepository.save(educationQualification);

            return modelMapper.map(educationQualification,EducationQualificationResponse.class);
        }
    @Override
    public ResponseEntity<String> delete(Long employeeId, Long id) throws  EmployeeNotFoundException{
        Employee employee= employeeRepository.findById(employeeId).orElseThrow(()-> new EmployeeNotFoundException("Employee Not Found"));

            List<EducationQualification> educationQualificationList=employee.getEducationQualificationList();
            EducationQualification qualificationToDelete=educationQualificationList.stream()
                    .filter(educationQualification -> educationQualification.getId().equals(id))
                    .findFirst()
                    .orElse(null);
            if (qualificationToDelete !=null){
                educationQualificationList.remove(qualificationToDelete);
                employeeRepository.save(employee);
                educationQualificationRepository.deleteById(id);
            }
        return ResponseEntity.status(HttpStatus.OK).body("Education Qualification Delete Successfully");
    }
    @Override
    public List<EducationQualificationResponse> getSpecific(Long id) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new  EmployeeNotFoundException("Employee Not Found"));
            List<EducationQualification> allQualifications = educationQualificationRepository.findEducationQualificationsByEmployee(employee);
        ModelMapper modelMapper = new ModelMapper();
        List<EducationQualificationResponse> qualificationResponseList = allQualifications.stream()
                .map(qualification -> modelMapper.map(qualification, EducationQualificationResponse.class))
                .collect(Collectors.toList());
        return qualificationResponseList;
        }
    }
