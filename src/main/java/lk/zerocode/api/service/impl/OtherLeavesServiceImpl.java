package lk.zerocode.api.service.impl;
import lk.zerocode.api.controller.request.OtherLeavesRequest;
import lk.zerocode.api.controller.response.OtherLeavesResponse;
import lk.zerocode.api.exceptions.EmployeeNotFoundException;
import lk.zerocode.api.model.EmpCategory;
import lk.zerocode.api.model.Employee;
import lk.zerocode.api.repository.EmpCategoryRepository;
import lk.zerocode.api.repository.EmployeeRepository;
import lk.zerocode.api.repository.OtherLeavesRepository;
import lk.zerocode.api.service.OtherLeavesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OtherLeavesServiceImpl implements OtherLeavesService {

//    EmployeeRepository employeeRepository;
    private OtherLeavesRepository otherLeavesRepository;
    private EmployeeRepository employeeRepository;
    private EmpCategoryRepository empCategoryRepository;

    @Override
    public List<OtherLeavesResponse> createLeave(Long empId,OtherLeavesRequest otherLeavesRequest)throws EmployeeNotFoundException {



        Employee employee = employeeRepository.findById(empId).orElseThrow(
                ()-> new EmployeeNotFoundException("that employee not in a database")
        );

        String category = employee.getCurrentWorkDetails().getEmpCategory().getEmpCategory();


return null;
    }

//    @Override
//    public List<OtherLeavesResponse> createStandardOtherLeaves(Long empId, OtherLeavesRequest otherLeavesRequest) {
//        return null;
//    }
}
