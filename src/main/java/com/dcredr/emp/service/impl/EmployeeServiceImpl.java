package com.dcredr.emp.service.impl;

import com.dcredr.emp.daoService.EmployeeDaoService;
import com.dcredr.emp.entities.EmployeeSearch;
import com.dcredr.emp.entities.EmployeeResponse;
import com.dcredr.emp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDaoService employeeDaoService;


    @Override
    public List<EmployeeResponse> searchEmployee(EmployeeSearch employeeSearch) {

        return employeeDaoService.searchEmployee(employeeSearch);
    }

}
