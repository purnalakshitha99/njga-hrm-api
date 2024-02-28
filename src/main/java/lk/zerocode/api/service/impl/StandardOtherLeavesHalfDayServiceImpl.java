package lk.zerocode.api.service.impl;

import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.model.Department;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.service.StandardOtherLeavesHalfDayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StandardOtherLeavesHalfDayServiceImpl implements StandardOtherLeavesHalfDayService {

    EmployeeRepository employeeRepository;


    @Override
    public List<OtherLeavesResponse> createStandardHalfDayLeaves(Long empId) {

        Optional<Employee> employeeOptional = employeeRepository.findById(empId);

        if (!employeeOptional.isPresent()) {
            return null;
        }

        return null;
    }


}
