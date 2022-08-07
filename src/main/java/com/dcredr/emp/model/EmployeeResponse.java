package com.dcredr.emp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    private String EmployeeName;
    private String sex;
    private String clientName;
    private int totalSales;

}
