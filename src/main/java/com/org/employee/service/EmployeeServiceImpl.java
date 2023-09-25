package com.org.employee.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.employee.model.Employee;
import com.org.employee.repository.EmployeRepo;
import com.org.employee.response.PartnerModel;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeService{

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
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

    @Override
    public List<PartnerModel> getAllPartnerFromEmployee() {

        ObjectMapper mapper=new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String body = getRestTemplate().exchange("http://localhost:9090/api/allRecords", HttpMethod.GET, entity, String.class).getBody();
        List<PartnerModel> partnerModel = null;
        try {
            partnerModel = mapper.readValue(body, new TypeReference<List<PartnerModel>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return partnerModel;
    }

    }
