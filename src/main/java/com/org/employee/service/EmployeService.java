package com.org.employee.service;

import com.org.employee.model.Employee;
import com.org.employee.response.PartnerModel;

import java.util.List;

public interface EmployeService {

        public void createEmployee(Employee employee);

       public List<Employee> getAllEmployees();

    public Employee getEmployeeBasedOnId(Integer id);
    public void deleteEmployeeBasedOnId(Integer id);
    void updateBasedOnEmpId(Integer id,String neme);
    void deleteAllRecordsInDb();

    public Employee getEmployeeBasedOnName(String name);

    public List<PartnerModel>getAllPartnerFromEmployee();

}
