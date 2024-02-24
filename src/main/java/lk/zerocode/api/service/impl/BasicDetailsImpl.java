package lk.zerocode.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lk.zerocode.api.controller.request.EmployeeRequest;
import lk.zerocode.api.controller.response.BasicDetailsResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.BranchesRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasicDetailsImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private BranchesRepository branchesRepository;
    @Override
    public BasicDetailsResponse saveBasicDetails(EmployeeRequest employeeRequest) throws EmployeeNotFoundException {
        Employee employee = new Employee();
        Optional<Employee> empOpt = employeeRepository.findEmployeeByEmpId(employeeRequest.getEmp_id());
        if (!empOpt.isPresent()){
            employee.setEmpId(employeeRequest.getEmp_id());
            employee.setFirstName(employeeRequest.getFirst_name());
            employee.setLastName(employeeRequest.getLast_name());
            employee.setDob(employeeRequest.getDob());
            employee.setAddress(employeeRequest.getAddress());
            employee.setContactNumber(employeeRequest.getContact_number());
            employee.setEmpId(employeeRequest.getEmail());
            employee.setImagePath(employeeRequest.getImage_path());
            employee.setNic(employeeRequest.getNic());
            employee.setWorkTelephone(employeeRequest.getWork_telephone());
            employee.setGender(employeeRequest.getGender());

            employeeRepository.save(employee);

            BasicDetailsResponse basicDetailsResponse = BasicDetailsResponse.builder()
                    .id(employee.getId())
                    .build();
            return basicDetailsResponse;
        }
        else {
            throw new EmployeeNotFoundException("Employee id Exist");
        }

    }
}
