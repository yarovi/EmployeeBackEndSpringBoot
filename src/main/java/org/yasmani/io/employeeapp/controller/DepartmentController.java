package org.yasmani.io.employeeapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yasmani.io.employeeapp.dto.DepartmentDto;
import org.yasmani.io.employeeapp.service.DepartmentService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // build add department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    // build get all departments REST API
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long id) {
        DepartmentDto department = departmentService.getDepartmentById(id);
        return  ResponseEntity.ok(department);
    }

    // build get all departments REST API
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        return  ResponseEntity.ok(departments);
    }

    // build update department REST API
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(
            @PathVariable("id") Long id,
            @RequestBody DepartmentDto departmentDto) {
        DepartmentDto department = departmentService.updateDepartment(id, departmentDto);
        return  ResponseEntity.ok(department);
    }

    // build delete department REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return  ResponseEntity.ok().build();
    }
}
