package org.yasmani.io.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yasmani.io.employeeapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
