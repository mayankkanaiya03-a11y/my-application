package com.example.Q_5.b.services;

import com.example.Q_5.b.models.Course;
import com.example.Q_5.b.repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo repository;

    public List<Course> getCourses(){
        return repository.findAll();
    }

    public Course getCourse(int id){
        List<Course> courses = getCourses();

        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }

        return null;
    }

    public Boolean addCourse(Course course){
        Course courseExist = getCourse(course.getId());

        if(courseExist != null){
            return false;
        }

        repository.save(course);

        return true;
    }

    public Boolean updateCourse(Course course){
        Course courseExist = getCourse(course.getId());

        if(courseExist == null){
            return false;
        }

        courseExist.setName(course.getName());
        courseExist.setCode(course.getCode());
        courseExist.setCreditHours(course.getCreditHours());

        repository.save(courseExist);
        return true;
    }

    public Boolean deleteCourse(int id){
        Course course = getCourse(id);
        if(course == null){
            return false;
        }

        repository.delete(course);
        return true;
    }
}
