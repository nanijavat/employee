package com.org.employee.cotroller;

import com.org.employee.model.Employee;
import com.org.employee.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeService employeService;

    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee) {
        employeService.createEmployee(employee);
    }

    @GetMapping("/getall")
    List<Employee> getAllEmployees() {
        return employeService.getAllEmployees();
    }

    @GetMapping("/getByEmpId/{id}")
    Employee getByEmpId(@PathVariable Integer id) {
        return employeService.getEmployeeBasedOnId(id);
    }

    @DeleteMapping("/deleteByEmpId/{id}")
    public String deleteByempId(@PathVariable Integer id){
        employeService.deleteEmployeeBasedOnId(id);
        return "successfully deleted";
    }

    @PutMapping("/updateBasedOnId/{id}/{name}")
    public String updateBasedOnEmpId(@PathVariable Integer id,@PathVariable String name){
        employeService.updateBasedOnEmpId(id,name);
        return "successfully update name beased on id";
    }
    @DeleteMapping("/deleteAll")
    public String deleteAllRecordsInDb(){
        employeService.deleteAllRecordsInDb();
        return "successfully deleted all records";
    }

    @GetMapping("/getByEmpName/{name}")
    Employee getByEmpName(@PathVariable String name) {
        return employeService.getEmployeeBasedOnName(name);
    }
}
