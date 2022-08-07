package com.dcredr.emp.controller;

import com.dcredr.emp.model.EmployeeSearch;
import com.dcredr.emp.model.EmployeeResponse;
import com.dcredr.emp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value="/search")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/client/employee")
    public ResponseEntity<List<EmployeeResponse>> searchEmployee(@RequestBody EmployeeSearch employeeSearch){
        List<EmployeeResponse> employeeResponses = employeeService.searchEmployee(employeeSearch);
        if(employeeResponses==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(employeeResponses);
    }

}
