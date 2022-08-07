package com.dcredr.emp.repository;

import com.dcredr.emp.entities.EmployeeResponse;
import com.dcredr.emp.entities.EmployeeSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeDaoImpl {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //Here we are getting the information based on gender and client names.
    public  List<EmployeeResponse> searchEmployee(EmployeeSearch employeeSearch) {

        String query = "SELECT CONCAT(employee.first_name,' '," +
                "employee.last_name) as employeeName, employee.sex as sex, client.client_name as clientName, " +
                "works_with.total_sales as totalSales FROM" +
                "((works_with" +
                " INNER JOIN client ON client.client_id =  works_with.client_id)" +
                " INNER JOIN employee ON employee.emp_id = works_with.emp_id)" +
                " WHERE (client.client_name IN (:clientList)) AND employee.sex IN (:gender)";
        SqlParameterSource parameterSource = new MapSqlParameterSource("clientList",employeeSearch.getClientList())
                .addValue("gender",employeeSearch.getGender()==null || employeeSearch.getGender().equals("")
                        ? Arrays.asList(new String[]{"M","F"}) : Arrays.asList(new String[]{employeeSearch.getGender()}));

        //if no gender is provided it will show all males and females employees working with the client.

        try {
            return jdbcTemplate.query(query, parameterSource, new RowMapper<EmployeeResponse>() {
                @Override
                public EmployeeResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                    EmployeeResponse employee = new EmployeeResponse();
                    employee.setEmployeeName(rs.getString("employeeName"));
                    employee.setClientName(rs.getString("clientName"));
                    employee.setSex(rs.getString("sex"));
                    employee.setTotalSales(rs.getInt("totalSales"));
                    return employee;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
