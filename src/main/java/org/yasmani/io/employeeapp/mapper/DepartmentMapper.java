package org.yasmani.io.employeeapp.mapper;

import org.yasmani.io.employeeapp.dto.DepartmentDto;
import org.yasmani.io.employeeapp.entity.Department;

public class DepartmentMapper {
    // convert department jpa entity into department dto
    public static DepartmentDto mapToDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setDepartmentDescription(department.getDepartmentDescription());
        return departmentDto;
    }

    // convert department dto into department jpa entity
    public static Department mapToDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        return department;
    }
}
