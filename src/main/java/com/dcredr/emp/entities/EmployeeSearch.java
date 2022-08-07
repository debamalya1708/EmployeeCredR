package com.dcredr.emp.entities;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeSearch {
    private List<String> clientList;
    private String gender;
}
