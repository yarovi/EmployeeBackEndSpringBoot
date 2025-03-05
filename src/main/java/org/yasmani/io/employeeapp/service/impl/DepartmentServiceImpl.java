package org.yasmani.io.employeeapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.yasmani.io.employeeapp.dto.DepartmentDto;
import org.yasmani.io.employeeapp.entity.Department;
import org.yasmani.io.employeeapp.exception.ResourceNotFoundException;
import org.yasmani.io.employeeapp.mapper.DepartmentMapper;
import org.yasmani.io.employeeapp.repository.DepartmentRepository;
import org.yasmani.io.employeeapp.service.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {

    Department department =departmentRepository.findById(id).
            orElseThrow(() -> new ResourceNotFoundException("Department is not with given id:"+ id));

    return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.
                stream().
                map(DepartmentMapper::mapToDepartmentDto).
                collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given id:"+id));
        department.setDepartmentName(departmentDto.getDepartmentName());
        Department saveDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given id:"+id));
        departmentRepository.delete(department);
    }
}
