package com.example.Q_5_a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {

    Map<Integer, EmployeeDTO> employees = new HashMap<>();

    @GetMapping("/employee")
    Map<Integer,EmployeeDTO> getEmployees() {
        return employees;
    }

    @GetMapping("/employee/{id}")
    EmployeeDTO getEmployee(@PathVariable int id) {

        Set<Integer> Employees = employees.keySet();

        for (Integer employeeId : Employees) {
            if(employeeId == id)
                return employees.get(employeeId);
        }

        return null;
    }

    @PostMapping("/employee")
    EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee) {

        Set<Integer> Employees = employees.keySet();

        for (Integer emp : Employees) {
            if(emp == employee.id){
                return null;
            }
        }

        employees.put(employee.id, employee);

        return employee;
    }
}
