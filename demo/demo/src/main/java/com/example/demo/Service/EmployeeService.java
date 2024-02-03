package com.example.demo.Service;

import com.example.demo.Model.Employee;

import java.util.List;

public interface EmployeeService {
Employee saveEmployee(Employee employee);
List<Employee> getAllEmployee();
Employee getEmployeeById(long id);
Employee updateEmployee(Employee employee,long id);
Employee deleteEmployee(long id);
}
