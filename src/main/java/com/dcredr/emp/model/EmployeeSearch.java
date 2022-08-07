package com.dcredr.emp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearch {
    private List<String> clientList;
    private String gender;

    private List<String> genderList;
}
