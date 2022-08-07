package com.dcredr.emp.serviceImpl;

import com.dcredr.emp.daoService.ClientDaoService;
import com.dcredr.emp.daoService.EmployeeDaoService;
import com.dcredr.emp.model.EmployeeSearch;
import com.dcredr.emp.model.EmployeeResponse;
import com.dcredr.emp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDaoService employeeDaoService;

    @Autowired
    private ClientDaoService clientDaoService;

    @Override
    public List<EmployeeResponse> searchEmployee(EmployeeSearch employeeSearch) {

        List<String> clientNameList = clientDaoService.getAllClient();

        employeeSearch.getClientList().removeIf(client -> !clientNameList.contains(client));
        if(employeeSearch.getClientList().size()==0){
            return null;
        }

        List<String> genderList = new ArrayList<>();

        if(employeeSearch.getGender()==null || employeeSearch.getGender().equals("")){
            genderList.add("M");
            genderList.add("F");
        }
        else {
            genderList.add(employeeSearch.getGender());
        }
        employeeSearch.setGenderList(genderList);

        return employeeDaoService.searchEmployee(employeeSearch);
    }

}
