package lk.zerocode.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lk.zerocode.api.controller.dto.BasicDetailsDTO;
import lk.zerocode.api.controller.response.BasicDetailsResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.BasicDetailsWithDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasicDetailsWithDtoImpl implements BasicDetailsWithDto {

    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;
    @Override
    public BasicDetailsDTO saveBasicDetails(BasicDetailsDTO basicDetailsDTO) {
        Employee employeeCreated = employeeRepository.save(modelMapper.map(basicDetailsDTO, Employee.class));
        return modelMapper.map(employeeCreated, BasicDetailsDTO.class);
    }

    @Override
    public List<BasicDetailsDTO> getAllDetails() {
        List<Employee> employeeAll = employeeRepository.findAll();

        if (employeeAll.isEmpty()){
            throw new EntityNotFoundException("No found Data");
        }
        return modelMapper.map(employeeAll, new TypeToken<List<BasicDetailsDTO>>(){}.getType());
    }

    @Override
    public List<Employee> getByEmpEmail(BasicDetailsDTO basicDetailsDTORqst) {

        System.out.println(basicDetailsDTORqst.getFirstName());
        String name = basicDetailsDTORqst.getFirstName();
        List<Employee> employees = employeeRepository.findByname(name);

        if (employees.isEmpty()){
            throw new EntityNotFoundException("No found Data");
        }

        return modelMapper.map(employees, new TypeToken<List<BasicDetailsDTO>>(){}.getType());
    }
}