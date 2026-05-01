# **Q-5 c**





## CourseFeedbackForm.java





package org.example;



public class CourseFeedbackForm {



&#x20;   String studentName;

&#x20;   String courseName;

&#x20;   Integer feedbackRating;

&#x20;   String comments;





&#x20;   public String getStudentName() {

&#x20;       return studentName;

&#x20;   }



&#x20;   public void setStudentName(String studentName) {

&#x20;       this.studentName = studentName;

&#x20;   }



&#x20;   public String getCourseName() {

&#x20;       return courseName;

&#x20;   }



&#x20;   public void setCourseName(String courseName) {

&#x20;       this.courseName = courseName;

&#x20;   }



&#x20;   public Integer getFeedbackRating() {

&#x20;       return feedbackRating;

&#x20;   }



&#x20;   public void setFeedbackRating(Integer feedbackRating) {

&#x20;       this.feedbackRating = feedbackRating;

&#x20;   }



&#x20;   public String getComments() {

&#x20;       return comments;

&#x20;   }



&#x20;   public void setComments(String comments) {

&#x20;       this.comments = comments;

&#x20;   }

}









## FeedbackFormController.java





package org.example;



import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;



import java.util.Arrays;



@Controller

public class FeedbackFormController {



&#x20;   @GetMapping("/feedback")

&#x20;   public ModelAndView feedbackForm(Model model) {



&#x20;       model.addAttribute("courses", Arrays.asList("Data Structure","Algorithms","Software Engineerings"));

&#x20;       model.addAttribute("ratings",Arrays.asList(1,2,3,4,5));





&#x20;       return new ModelAndView("form","model",model);

&#x20;   }



&#x20;   @PostMapping("/feedback")

&#x20;   public ModelAndView feedback(@ModelAttribute CourseFeedbackForm feedback) {



&#x20;       ModelAndView modelAndView = new ModelAndView("success");

&#x20;       modelAndView.addObject("msg","Feedback saved successfully");



&#x20;       return modelAndView;

&#x20;   }



}







## form.jsp





<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<html>



<body>

&#x20;   <form:form method="post" action="feedback" modelAttribute="model" >



&#x20;       <form:input type="text" path="studentName" />

&#x20;       <form:select type="text" path="courseName" >

&#x20;           <form:options items="${courses}"

&#x20;       </form:select>

&#x20;       <form:select type="number" path="feedbackRating" >

&#x20;           <form:options items="${ratings}"

&#x20;       </form:select>

&#x20;       <form:input type="text" path="comments" />



&#x20;       <form: type="submit" />

&#x20;   </form:form>

</body>

</html>









## success.jsp





<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

&#x20;   <title>Feedback Submitted</title>

</head>

<body>

&#x20;   <h2>${msg}</h2>



&#x20;   <h2>${feedback.studentName}</h2>

&#x20;   <h2>${feedback.courseName}</h2>

&#x20;   <h2>${feedback.feedbackRating} / 5</h2>

&#x20;   <h2>${feedback.comments}</h2>



</body>

</html>



