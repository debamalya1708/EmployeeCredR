package com.dcredr.emp.repository;

import com.dcredr.emp.model.EmployeeResponse;
import com.dcredr.emp.model.EmployeeSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDAOImpl {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public  List<EmployeeResponse> searchEmployee(EmployeeSearch employeeSearch) {


        String query = "SELECT CONCAT(employee.first_name,' '," +
                "employee.last_name) as employeeName, employee.sex as sex, client.client_name as clientName, " +
                "works_with.total_sales as totalSales FROM" +
                "((works_with" +
                " INNER JOIN client ON client.client_id =  works_with.client_id)" +
                " INNER JOIN employee ON employee.emp_id = works_with.emp_id)" +
                " WHERE (client.client_name IN (:clientList)) AND employee.sex IN (:gender)";
        SqlParameterSource parameterSource = new MapSqlParameterSource("clientList",employeeSearch.getClientList())
                .addValue("gender",employeeSearch.getGenderList());
        try {
            return jdbcTemplate.query(query, parameterSource, new RowMapper<EmployeeResponse>() {
                @Override
                public EmployeeResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                    EmployeeResponse person = new EmployeeResponse();
                    person.setEmployeeName(rs.getString("employeeName"));
                    person.setClientName(rs.getString("clientName"));
                    person.setSex(rs.getString("sex"));
                    person.setTotalSales(rs.getInt("totalSales"));
                    return person;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
