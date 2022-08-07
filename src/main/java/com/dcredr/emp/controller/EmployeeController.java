package com.dcredr.emp.controller;

import com.dcredr.emp.entities.EmployeeSearch;
import com.dcredr.emp.entities.EmployeeResponse;
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

    /*This controller accepts gender and client list
     and gives the response as employee's name, employee's sex, client's name and total sales */
    //if the client list is blank, it will give a bad request as a response.
    //if there is no employee on the given input, it will give not found as a response.


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/client/employee")
    public ResponseEntity<List<EmployeeResponse>> searchEmployee(@RequestBody EmployeeSearch employeeSearch){
        if(employeeSearch.getClientList()==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<EmployeeResponse> employeeResponses = employeeService.searchEmployee(employeeSearch);
        if(employeeResponses==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(employeeResponses);
    }

}
