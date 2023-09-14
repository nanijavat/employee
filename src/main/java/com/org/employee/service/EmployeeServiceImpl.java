package com.org.employee.service;

import com.org.employee.model.Employee;
import com.org.employee.repository.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeService{

    @Autowired
    EmployeRepo  employeRepo;

    @Override
    public void createEmployee(Employee employee) {
        employeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeRepo.findAll();
    }

    @Override
    public Employee getEmployeeBasedOnId(Integer id) {
        return employeRepo.findById(id).get();
    }

    @Override
    public void deleteEmployeeBasedOnId(Integer id) {
        employeRepo.deleteById(id);
        System.out.println("success fully deleted");
    }

    @Override
    public void updateBasedOnEmpId(Integer id,String name) {
       Employee employee= employeRepo.findById(id).get();
        employee.setName(name);
        employeRepo.save(employee);
    }

    @Override
    public void deleteAllRecordsInDb() {
        employeRepo.deleteAll();

    }

    @Override
    public Employee getEmployeeBasedOnName(String name) {
        return employeRepo.findByName(name).get();
    }


}
