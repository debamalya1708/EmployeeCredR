package com.dcredr.emp.service;

import com.dcredr.emp.model.EmployeeSearch;
import com.dcredr.emp.model.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> searchEmployee(EmployeeSearch employeeSearch);
}
