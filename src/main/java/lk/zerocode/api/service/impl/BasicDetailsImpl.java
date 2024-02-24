package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.request.BasicDetailsRequest;
import lk.zerocode.api.controller.response.BasicDetailsResponse;
import lk.zerocode.api.controller.response.IdResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.BranchesRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BasicDetailsImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private BranchesRepository branchesRepository;

    @Override
    public IdResponse saveBasicDetails(BasicDetailsRequest basicDetailsRequest) throws EmployeeNotFoundException {
        Employee employee = new Employee();
        Optional<Employee> empOpt = employeeRepository.findEmployeeByEmpId(basicDetailsRequest.getEmp_id());
        if (empOpt.isPresent()) {
            throw new EmployeeNotFoundException("Employee id Exist");
        } else {
            employee.setEmpId(basicDetailsRequest.getEmp_id());
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
    }

    @Override
    public BasicDetailsResponse getByEmpId(String id) throws EmployeeNotFoundException {

        Optional<Employee> empOpt = employeeRepository.findEmployeeByEmpId(id);

        if (!empOpt.isPresent()) {
            throw new EmployeeNotFoundException("Employee Not Found!");
        } else {
            Employee employee = empOpt.get();
            return BasicDetailsResponse.builder()
                    .emp_id(employee.getEmpId())
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
    public BasicDetailsResponse getByEmpEmail(String email) throws EmployeeNotFoundException {
        Optional<Employee> empOpt = employeeRepository.findEmployeeByEmail(email);

        if (!empOpt.isPresent()){
            throw new EmployeeNotFoundException("Employee Not Found!");
        }
        else {
            Employee employee = empOpt.get();
            return  BasicDetailsResponse.builder()
                    .emp_id(employee.getEmpId())
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
}


