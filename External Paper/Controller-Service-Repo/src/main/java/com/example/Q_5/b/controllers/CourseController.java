package com.example.Q_5.b.controllers;

import com.example.Q_5.b.models.Course;
import com.example.Q_5.b.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService  courseService;

    @GetMapping("/course")
    List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/course/{id}")
    Course getCourse(@PathVariable int id){
        return courseService.getCourse(id);
    }

    @PostMapping("/course")
    Boolean addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PutMapping("/course")
    Boolean updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/course")
    Boolean deleteCourse(int id){
        return courseService.deleteCourse(id);
    }
}
