package com.dcredr.emp.daoServiceImpl;

import com.dcredr.emp.daoService.EmployeeDaoService;
import com.dcredr.emp.model.EmployeeResponse;
import com.dcredr.emp.model.EmployeeSearch;
import com.dcredr.emp.repository.EmployeeDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeDaoServiceImpl implements EmployeeDaoService {

    @Autowired
    private  EmployeeDAOImpl employeeDAO;

    @Override
    public List<EmployeeResponse> searchEmployee(EmployeeSearch employeeSearch) {
        return employeeDAO.searchEmployee(employeeSearch);
    }
}
