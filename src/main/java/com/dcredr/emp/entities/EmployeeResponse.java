package com.dcredr.emp.entities;

import lombok.Data;

@Data
public class EmployeeResponse {

    private String EmployeeName;
    private String sex;
    private String clientName;
    private int totalSales;

}
