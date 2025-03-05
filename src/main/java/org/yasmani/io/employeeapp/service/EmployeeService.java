package org.yasmani.io.employeeapp.service;

import org.yasmani.io.employeeapp.dto.EmployeeDto;
import org.yasmani.io.employeeapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
    void deleteEmployee(Long id);
}
