package com.dcredr.emp.daoService.impl;

import com.dcredr.emp.daoService.EmployeeDaoService;
import com.dcredr.emp.entities.EmployeeResponse;
import com.dcredr.emp.entities.EmployeeSearch;
import com.dcredr.emp.repository.EmployeeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDaoServiceImpl implements EmployeeDaoService {

    @Autowired
    private EmployeeDaoImpl employeeDaoImpl;

    @Override
    public List<EmployeeResponse> searchEmployee(EmployeeSearch employeeSearch) {
        return employeeDaoImpl.searchEmployee(employeeSearch);
    }
}
