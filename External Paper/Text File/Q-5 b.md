# **Q-5 b**





## CourseRepo.java





package com.example.Q\_5.b.repositories;



import com.example.Q\_5.b.models.Course;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;





public interface CourseRepo extends JpaRepository<Course, Integer> {

}







## CourseService.java



package com.example.Q\_5.b.services;



import com.example.Q\_5.b.models.Course;

import com.example.Q\_5.b.repositories.CourseRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import java.util.List;



@Service

public class CourseService {



&#x20;   @Autowired

&#x20;   CourseRepo repository;





&#x20;   public List<Course> getCourses(){

&#x20;       return repository.findAll();

&#x20;   }



&#x20;   public Course getCourse(int id){

&#x20;       List<Course> courses = getCourses();



&#x20;       for (Course course : courses) {

&#x20;           if (course.getId() == id) {

&#x20;               return course;

&#x20;           }

&#x20;       }



&#x20;       return null;

&#x20;   }



&#x20;   public Boolean addCourse(Course course){

&#x20;       Course courseExist = getCourse(course.getId());



&#x20;       if(courseExist != null){

&#x20;           return false;

&#x20;       }



&#x20;       repository.save(course);



&#x20;       return true;

&#x20;   }



&#x20;   public Boolean updateCourse(Course course){

&#x20;       Course courseExist = getCourse(course.getId());



&#x20;       if(courseExist == null){

&#x20;           return false;

&#x20;       }



&#x20;       courseExist.setName(course.getName());

&#x20;       courseExist.setCode(course.getCode());

&#x20;       courseExist.setCreditHours(course.getCreditHours());



&#x20;       repository.save(courseExist);

&#x20;       return true;

&#x20;   }



&#x20;   public Boolean deleteCourse(int id){

&#x20;       Course course = getCourse(id);

&#x20;       if(course == null){

&#x20;           return false;

&#x20;       }



&#x20;       repository.delete(course);

&#x20;       return true;

&#x20;   }

}









## CourseController.java



package com.example.Q\_5.b.controllers;



import com.example.Q\_5.b.models.Course;

import com.example.Q\_5.b.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.\*;



import java.util.List;



@RestController

public class CourseController {



&#x20;   @Autowired

&#x20;   CourseService  courseService;



&#x20;   @GetMapping("/course")

&#x20;   List<Course> getCourses(){

&#x20;       return courseService.getCourses();

&#x20;   }



&#x20;   @GetMapping("/course/{id}")

&#x20;   Course getCourse(@PathVariable int id){

&#x20;       return courseService.getCourse(id);

&#x20;   }



&#x20;   @PostMapping("/course")

&#x20;   Boolean addCourse(@RequestBody Course course){

&#x20;       return courseService.addCourse(course);

&#x20;   }



&#x20;   @PutMapping("/course")

&#x20;   Boolean updateCourse(@RequestBody Course course){

&#x20;       return courseService.updateCourse(course);

&#x20;   }



&#x20;   @DeleteMapping("/course")

&#x20;   Boolean deleteCourse(int id){

&#x20;       return courseService.deleteCourse(id);

&#x20;   }

}



