package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.BasicDetailsRequest;
import lk.zerocode.api.controller.response.BasicDetailsResponse;
import lk.zerocode.api.controller.response.IdResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BasicDetailsServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public IdResponse saveBasicDetails(Long id, BasicDetailsRequest basicDetailsRequest) throws EmployeeNotFoundException {

         employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not Found!")
        );

            Employee employee = new Employee();
//            employee.setEmpId(basicDetailsRequest.getEmp_id());
            employee.setFirstName(basicDetailsRequest.getFirst_name());
            employee.setLastName(basicDetailsRequest.getLast_name());
            employee.setDob(basicDetailsRequest.getDob());
            employee.setAddress(basicDetailsRequest.getAddress());
            employee.setContactNumber(basicDetailsRequest.getContact_number());
            employee.setEmail(basicDetailsRequest.getEmail());
            employee.setImagePath(basicDetailsRequest.getImage_path());
            employee.setNic(basicDetailsRequest.getNic());
            employee.setWorkTelephone(basicDetailsRequest.getWork_telephone());
            employee.setGender(basicDetailsRequest.getGender());

            employeeRepository.save(employee);

            IdResponse basicDetailsResponse = IdResponse.builder()
                    .id(employee.getId())
                    .build();
            return basicDetailsResponse;
        }


//    @Override
//    public BasicDetailsResponse getByEmpId(String id) throws EmployeeNotFoundException {
//
//        employeeRepository.findEmployeeByEmpId(id).orElseThrow(
//                () -> new EmployeeNotFoundException("Employee Not Found!")
//        );
//        Optional<Employee> empOpt = employeeRepository.findEmployeeByEmpId(id);
//
//        if (!empOpt.isPresent()) {
//            throw new EmployeeNotFoundException("Employee Not Found!");
//        } else {
//            Employee employee = empOpt.get();
//            return BasicDetailsResponse.builder()
////                    .emp_id(employee.getEmpId())
//                    .first_name(employee.getFirstName())
//                    .last_name(employee.getLastName())
//                    .dob(employee.getDob())
//                    .address(employee.getAddress())
//                    .contact_number(employee.getContactNumber())
//                    .email(employee.getEmail())
//                    .image_path(employee.getImagePath())
//                    .nic(employee.getNic())
//                    .work_telephone(employee.getWorkTelephone())
//                    .gender(employee.getGender())
//                    .build();
//        }
//    }

    @Override
    public BasicDetailsResponse getByEmpEmail(String email) throws EmployeeNotFoundException {

        employeeRepository.findEmployeeByEmail(email).orElseThrow(
                () -> new EmployeeNotFoundException("Employee Not Found!")
        );
        Optional<Employee> empOpt = employeeRepository.findEmployeeByEmail(email);

        if (!empOpt.isPresent()) {
            throw new EmployeeNotFoundException("Employee Not Found!");
        } else {
            Employee employee = empOpt.get();
            return BasicDetailsResponse.builder()
//                    .emp_id(employee.getEmpId())
                    .first_name(employee.getFirstName())
                    .last_name(employee.getLastName())
                    .dob(employee.getDob())
                    .address(employee.getAddress())
                    .contact_number(employee.getContactNumber())
                    .email(employee.getEmail())
                    .image_path(employee.getImagePath())
                    .nic(employee.getNic())
                    .work_telephone(employee.getWorkTelephone())
                    .gender(employee.getGender())
                    .build();
        }
    }

    @Override
    public List<BasicDetailsResponse> getAll() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(employee -> BasicDetailsResponse.builder()
//                        .emp_id(employee.getEmpId())
                        .first_name(employee.getFirstName())
                        .last_name(employee.getLastName())
                        .dob(employee.getDob())
                        .address(employee.getAddress())
                        .contact_number(employee.getContactNumber())
                        .email(employee.getEmail())
                        .image_path(employee.getImagePath())
                        .nic(employee.getNic())
                        .work_telephone(employee.getWorkTelephone())
                        .gender(employee.getGender())
                        .build())
                .collect(Collectors.toList());

    }

    @Override
    public ResponseEntity<String> updateBasicDetails(Long id, BasicDetailsRequest basicDetailsRequest) throws EmployeeNotFoundException {

        Optional<Employee> optEmp = employeeRepository.findById(id);

        if (!optEmp.isPresent()) {
            throw new EmployeeNotFoundException("Employee Not Found!");
        } else {
            Employee updatedEmployee = optEmp.get();
//            updatedEmployee.setEmpId(basicDetailsRequest.getEmp_id());
            updatedEmployee.setFirstName(basicDetailsRequest.getFirst_name());
            updatedEmployee.setLastName(basicDetailsRequest.getLast_name());
            updatedEmployee.setDob(basicDetailsRequest.getDob());
            updatedEmployee.setAddress(basicDetailsRequest.getAddress());
            updatedEmployee.setContactNumber(basicDetailsRequest.getContact_number());
            updatedEmployee.setEmail(basicDetailsRequest.getEmail());
            updatedEmployee.setImagePath(basicDetailsRequest.getImage_path());
            updatedEmployee.setNic(basicDetailsRequest.getNic());
            updatedEmployee.setWorkTelephone(basicDetailsRequest.getWork_telephone());
            updatedEmployee.setGender(basicDetailsRequest.getGender());

            employeeRepository.save(updatedEmployee);

            return ResponseEntity.status(HttpStatus.CREATED).body("Basic Details Update successfully!");

//            return BasicDetailsResponse.builder()
//                    .emp_id(updatedEmployee.getEmpId())
//                    .first_name(updatedEmployee.getFirstName())
//                    .last_name(updatedEmployee.getLastName())
//                    .dob(updatedEmployee.getDob())
//                    .address(updatedEmployee.getAddress())
//                    .contact_number(updatedEmployee.getContactNumber())
//                    .email(updatedEmployee.getEmail())
//                    .image_path(updatedEmployee.getImagePath())
//                    .nic(updatedEmployee.getNic())
//                    .work_telephone(updatedEmployee.getWorkTelephone())
//                    .gender(updatedEmployee.getGender())
//                    .build();
        }
    }
}



