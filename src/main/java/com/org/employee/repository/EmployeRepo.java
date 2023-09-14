package com.org.employee.repository;

import com.org.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeRepo extends JpaRepository<Employee,Integer> {

  Optional<Employee> findById(Integer id);
  Optional<Employee> findByName(String name);
}
