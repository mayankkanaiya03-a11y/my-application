# **Q-6 a**







## Course.java





package org.example;



import jakarta.validation.constraints.Future;

import jakarta.validation.constraints.Max;

import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.Pattern;



import java.util.Date;



public class Course {



&#x20;   String studentName;



&#x20;   @Min(value = 15, message = "age must at least 15")

&#x20;   @Max(value = 45, message = "age can be at max 45")

&#x20;   Integer age;



&#x20;   @Pattern(regexp = "^(Python Programming|Data Science|Coud Computing)$",message = "Invalid course")

&#x20;   String courseTitle;



&#x20;   String contactEmail;



&#x20;   @Future(message = "date must be future or today")

&#x20;   Date enrollmentDate;





&#x20;   public String getStudentName() {

&#x20;       return studentName;

&#x20;   }



&#x20;   public void setStudentName(String studentName) {

&#x20;       this.studentName = studentName;

&#x20;   }



&#x20;   public Integer getAge() {

&#x20;       return age;

&#x20;   }



&#x20;   public void setAge(Integer age) {

&#x20;       this.age = age;

&#x20;   }



&#x20;   public String getCourseTitle() {

&#x20;       return courseTitle;

&#x20;   }



&#x20;   public void setCourseTitle(String courseTitle) {

&#x20;       this.courseTitle = courseTitle;

&#x20;   }



&#x20;   public String getContactEmail() {

&#x20;       return contactEmail;

&#x20;   }



&#x20;   public void setContactEmail(String contactEmail) {

&#x20;       this.contactEmail = contactEmail;

&#x20;   }



&#x20;   public Date getEnrollmentDate() {

&#x20;       return enrollmentDate;

&#x20;   }



&#x20;   public void setEnrollmentDate(Date enrollmentDate) {

&#x20;       this.enrollmentDate = enrollmentDate;

&#x20;   }

}









## CourseController.java





package org.example;



import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;



import java.util.Arrays;



@Controller

public class CourseController {



&#x20;   @GetMapping("/course")

&#x20;   public ModelAndView showForm(Model model){

&#x20;       model.addAttribute("courses", Arrays.asList("Python Programming","Data Science","Coud Computing"));



&#x20;       return new ModelAndView("form","model",model);

&#x20;   }



&#x20;   @PostMapping("/course")

&#x20;   public ModelAndView saveCourse(@Valid @ModelAttribute Course course, BindingResult result, Model model){



&#x20;       if(result.hasErrors()){

&#x20;           model.addAttribute("course", Arrays.asList("Python Programming","Data Science","Coud Computing"));

&#x20;           return new ModelAndView("form","model",model);

&#x20;       }



&#x20;       ModelAndView modelAndView = new ModelAndView("success");

&#x20;       modelAndView.addObject("msg","Course registered successfully");



&#x20;       return modelAndView;

&#x20;   }

}









## WebApplicationContextConfig.java







package org.example;





import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.ViewResolver;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.web.servlet.view.InternalResourceViewResolver;





@Configuration

@EnableWebMvc

@ComponentScan("org.example")

public class WebApplicationContextConfig implements WebMvcConfigurer {



&#x20;   @Bean

&#x20;   public ViewResolver  getViewResolver() {

&#x20;       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

&#x20;       viewResolver.setPrefix("/WEB-INF/jsp/");

&#x20;       viewResolver.setSuffix(".jsp");



&#x20;       return viewResolver;

&#x20;   }

}



