package lk.zerocode.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lk.zerocode.api.controller.dto.BasicDetailsDTO;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.BasicDetailsService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BasicDetailsServiceImpl implements BasicDetailsService {

    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;
    @Override
    public BasicDetailsDTO saveBasicDetails(BasicDetailsDTO basicDetailsDTO) {
        Employee employee = employeeRepository.save(modelMapper.map(basicDetailsDTO, Employee.class));
        return modelMapper.map(employee, BasicDetailsDTO.class);
    }

    @Override
    public List<BasicDetailsDTO> getAllDetails() {
        List<Employee> employeeAll = employeeRepository.findAll();

        if (employeeAll.isEmpty()){
            throw new EntityNotFoundException("No found Data");
        }
//        return modelMapper.map(employeeAll, new TypeToken<List<BasicDetailsDTO>>(){}.getType());

        return employeeAll.stream()
                .map(details -> modelMapper.map(details, BasicDetailsDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<Employee> filterByName(BasicDetailsDTO basicDetailsDTORqst) {

        System.out.println(basicDetailsDTORqst.getFirstName());
        String name = basicDetailsDTORqst.getFirstName();
        List<Employee> employees = employeeRepository.findByname(name);

        if (employees.isEmpty()){
            throw new EntityNotFoundException("No found Data");
        }

        return modelMapper.map(employees, new TypeToken<List<BasicDetailsDTO>>(){}.getType());
    }

    @Override
    public BasicDetailsDTO updateBasicDetails(Long id, BasicDetailsDTO basicDetailsDTO)throws EmployeeNotFoundException{

        employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found!")
        );

        Employee employeeUpdated = employeeRepository.save(modelMapper.map(basicDetailsDTO, Employee.class));
        return modelMapper.map(employeeUpdated, BasicDetailsDTO.class);
    }
}
