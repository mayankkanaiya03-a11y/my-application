package com.example.Q_5.b.repositories;

import com.example.Q_5.b.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface CourseRepo extends JpaRepository<Course, Integer> {
}
