package lk.zerocode.api.controller;

import jakarta.validation.Valid;
import lk.zerocode.api.controller.dto.BasicDetailsDTO;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.service.BasicDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BasicDetailControllerWithDto {

    private BasicDetailsService basicDetailsWithDto;

    @PostMapping("/employees")
    public ResponseEntity<BasicDetailsDTO> saveBasicDetails(@RequestBody @Valid BasicDetailsDTO basicDetailsDTO){
        BasicDetailsDTO createdemployee = basicDetailsWithDto.saveBasicDetails(basicDetailsDTO);
        return new ResponseEntity<>(createdemployee, HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<BasicDetailsDTO>> getAllDetails(){
        List<BasicDetailsDTO> allDetails = basicDetailsWithDto.getAllDetails();
        return new ResponseEntity<>(allDetails, HttpStatus.OK);
    }


    @GetMapping("/employee/name")
    public ResponseEntity<List<Employee>> getByName(@RequestBody BasicDetailsDTO basicDetailsDTO) {
        List<Employee> details = basicDetailsWithDto.filterByName(basicDetailsDTO);
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @PutMapping("/employee/{empId}")
    public ResponseEntity<BasicDetailsDTO> updateBasicDetails(@PathVariable ("empId") Long id, @RequestBody BasicDetailsDTO basicDetailsDTO) throws EmployeeNotFoundException {
        BasicDetailsDTO updatedEmployee = basicDetailsWithDto.updateBasicDetails(id,basicDetailsDTO);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}
