package com.example.demo.Service.impl;

import com.example.demo.Exeption.ResourceNotFoundExeption;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new ResourceNotFoundExeption("Employee",id,"ID");
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Employee", id, "ID"));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setName(employee.getEmail());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;

    }

    @Override
    public Employee deleteEmployee(long id) {
        Employee employeeExist = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundExeption("Employee",id,"ID"));
        employeeRepository.delete(employeeExist);
        return employeeExist;
    }
}
