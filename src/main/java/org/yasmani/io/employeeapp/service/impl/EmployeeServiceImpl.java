package org.yasmani.io.employeeapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.yasmani.io.employeeapp.dto.EmployeeDto;
import org.yasmani.io.employeeapp.entity.Employee;
import org.yasmani.io.employeeapp.exception.ResourceNotFoundException;
import org.yasmani.io.employeeapp.mapper.EmployeeMapper;
import org.yasmani.io.employeeapp.repository.EmployeeRepository;
import org.yasmani.io.employeeapp.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {

        Employee employee =employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given is:"+id));
        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.
                stream().
                map(EmployeeMapper::mapToEmployeeDto).
                collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id:"+id));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Employee saveEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id:"+id));
        employeeRepository.delete(employee);
    }
}
