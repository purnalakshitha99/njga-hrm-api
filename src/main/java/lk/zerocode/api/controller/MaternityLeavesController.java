package lk.zerocode.api.controller;

import lk.zerocode.api.service.MaternityLeaveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MaternityLeavesController {
    private MaternityLeaveService maternityLeaveService;
}
