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
public class BasicDetailController {

    private BasicDetailsService basicDetailsService;

    @PostMapping(value = "/employees", headers = "VERSION=V1")
    public ResponseEntity<BasicDetailsDTO> saveBasicDetails(@RequestBody @Valid BasicDetailsDTO basicDetailsDTO){
        BasicDetailsDTO createdemployee = basicDetailsService.saveBasicDetails(basicDetailsDTO);
        return new ResponseEntity<>(createdemployee, HttpStatus.CREATED);
    }

    @GetMapping(value = "/employees", headers = "VERSION=V1")
    public ResponseEntity<List<BasicDetailsDTO>> getAllDetails(){
        List<BasicDetailsDTO> allDetails = basicDetailsService.getAllDetails();
        return new ResponseEntity<>(allDetails, HttpStatus.OK);
    }


    @GetMapping(value = "/employee/name",headers = "VERSION=V1")
    public ResponseEntity<List<Employee>> getByName(@RequestBody BasicDetailsDTO basicDetailsDTO) {
        List<Employee> details = basicDetailsService.filterByName(basicDetailsDTO);
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @PutMapping(value = "/employee/{empId}", headers = "VERSION=V1")
    public ResponseEntity<BasicDetailsDTO> updateBasicDetails(@PathVariable ("empId") Long id, @RequestBody BasicDetailsDTO basicDetailsDTO) throws EmployeeNotFoundException {
        BasicDetailsDTO updatedEmployee = basicDetailsService.updateBasicDetails(id,basicDetailsDTO);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}
