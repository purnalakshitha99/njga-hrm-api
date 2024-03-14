package lk.zerocode.api.service;

import lk.zerocode.api.controller.dto.BasicDetailsDTO;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasicDetailsService {

    BasicDetailsDTO saveBasicDetails(BasicDetailsDTO basicDetailsDTO);

    List<BasicDetailsDTO> getAllDetails();

    List<Employee> filterByName(BasicDetailsDTO basicDetailsDTORqst);

    BasicDetailsDTO updateBasicDetails(Long id, BasicDetailsDTO basicDetailsDTO)throws EmployeeNotFoundException;

}
