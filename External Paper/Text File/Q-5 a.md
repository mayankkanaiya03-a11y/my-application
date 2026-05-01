# **Q-5 a**





## EmployeeController.java



package com.example.Q\_5\_a;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.\*;



import java.util.ArrayList;

import java.util.List;



@RestController

public class EmployeeController {



&#x20;   List<EmployeeDTO> employees = new ArrayList<>();



&#x20;   @GetMapping("/employee")

&#x20;   List<EmployeeDTO> getEmployees() {

&#x20;       return employees;

&#x20;   }



&#x20;   @GetMapping("/employee/{id}")

&#x20;   EmployeeDTO getEmployee(@PathVariable int id) {

&#x20;       for (EmployeeDTO employee : employees) {

&#x20;           if(employee.id == id)

&#x20;               return employee;

&#x20;       }



&#x20;       return null;

&#x20;   }



&#x20;   @PostMapping("/employee")

&#x20;   EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee) {



&#x20;       for (EmployeeDTO emp : employees) {

&#x20;           if(emp.id == employee.id){

&#x20;               return null;

&#x20;           }

&#x20;       }



&#x20;       employees.add(employee);



&#x20;       return employee;

&#x20;   }

}







## EmployeeDTO.java





package com.example.Q\_5\_a;



public class EmployeeDTO {



&#x20;   int id;

&#x20;   String name;

&#x20;   String department;

&#x20;   double salary;



&#x20;   public EmployeeDTO() {

&#x20;   }

&#x20;   public EmployeeDTO(int id, String name, String department, double salary) {

&#x20;       this.name = name;

&#x20;       this.department = department;

&#x20;       this.salary = salary;

&#x20;       this.id = id;

&#x20;   }



&#x20;   public int getId() {

&#x20;       return id;

&#x20;   }



&#x20;   public void setId(int id) {

&#x20;       this.id = id;

&#x20;   }



&#x20;   public String getName() {

&#x20;       return name;

&#x20;   }



&#x20;   public void setName(String name) {

&#x20;       this.name = name;

&#x20;   }



&#x20;   public String getDepartment() {

&#x20;       return department;

&#x20;   }



&#x20;   public void setDepartment(String department) {

&#x20;       this.department = department;

&#x20;   }



&#x20;   public double getSalary() {

&#x20;       return salary;

&#x20;   }



&#x20;   public void setSalary(double salary) {

&#x20;       this.salary = salary;

&#x20;   }

}



