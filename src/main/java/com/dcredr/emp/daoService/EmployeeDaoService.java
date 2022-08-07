package com.dcredr.emp.daoService;

import com.dcredr.emp.model.EmployeeSearch;
import com.dcredr.emp.model.EmployeeResponse;

import java.util.List;
import java.util.Map;

public interface EmployeeDaoService {

     List<EmployeeResponse> searchEmployee(EmployeeSearch employeeSearch);
}
