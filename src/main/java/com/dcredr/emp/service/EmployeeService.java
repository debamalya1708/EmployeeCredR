package com.dcredr.emp.service;

import com.dcredr.emp.entities.EmployeeSearch;
import com.dcredr.emp.entities.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> searchEmployee(EmployeeSearch employeeSearch);
}
