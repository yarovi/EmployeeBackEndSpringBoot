package org.yasmani.io.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yasmani.io.employeeapp.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
