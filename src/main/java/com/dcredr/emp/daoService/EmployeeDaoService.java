package com.dcredr.emp.daoService;

import com.dcredr.emp.entities.EmployeeSearch;
import com.dcredr.emp.entities.EmployeeResponse;

import java.util.List;

public interface EmployeeDaoService {

     List<EmployeeResponse> searchEmployee(EmployeeSearch employeeSearch);
}
