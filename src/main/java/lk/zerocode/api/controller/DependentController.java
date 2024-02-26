//package lk.zerocode.api.controller;
//
//import lk.zerocode.api.controller.request.DependentDetailReq;
//import lk.zerocode.api.service.EmployeeService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@AllArgsConstructor
//public class DependentController {
//    private EmployeeService employeeService;
//    @PostMapping(value = "/students",headers = "version=v1")
//    public void addDependent(@RequestBody DependentDetailReq dependentDetailReq, @PathVariable Long id){
//        employeeService.addDependent(dependentDetailReq,id);
//    }
//}
