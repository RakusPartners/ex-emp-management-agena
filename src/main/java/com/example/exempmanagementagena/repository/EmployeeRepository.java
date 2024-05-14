package com.example.exempmanagementagena.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exempmanagementagena.domain.Employee;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
        Employee employee = new Employee();

        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setImage(rs.getString("image"));
        employee.setGender(rs.getString("gender"));
        employee.setHireDate(rs.getDate("date"));
        employee.setMailAddress(rs.getString("mailAddress"));
        employee.setZipCode(rs.getString("zipCode"));
        employee.setAddress(rs.getString("address"));
        employee.setTelephone(rs.getString("telephone"));
        employee.setSalary(rs.getInt("salary"));
        employee.setCharacteristics(rs.getString("characteristics"));
        employee.setDependentsCount(rs.getInt("dependentsCount"));

        return employee;
    };

    public List<Employee> findAll() {
        String sql = "SELECT id, name, image, gender, date, mail_address, zip_code, address, telephone, salary, characteristics, dependents_count "
                +
                "FROM employees " +
                "ORDER BY date DESC";

        List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);

        return employeeList;
    }

    public Employee load(Integer id) {
        String sql = "SELECT id, name, image, gender, date, mail_address, zip_code, address, telephone, salary, characteristics, dependents_count "
                +
                "FROM employees " +
                "WHERE id=:id";

        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

        Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);

        return employee;
    }

    public void update(Employee employee) {
        String sql = "UPDATE employees SET name=:name, image=:image, gender=:gender, date=:date, mail_address=:mailAddress, zip_code=:zipCode, address=:address, telephone=:telephone, salary=:salary, characteristics=:characteristics, dependents_count=:dependentsCount "
                +
                "WHERE id=:id";

        SqlParameterSource param = new BeanPropertySqlParameterSource(employee);

        template.update(sql, param);
    }
}
