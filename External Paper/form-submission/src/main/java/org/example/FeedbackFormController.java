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

    @GetMapping("/feedback")
    public ModelAndView feedbackForm(Model model) {

        model.addAttribute("courses", Arrays.asList("Data Structure","Algorithms","Software Engineerings"));
        model.addAttribute("ratings",Arrays.asList(1,2,3,4,5));


        return new ModelAndView("form","model",model);
    }

    @PostMapping("/feedback")
    public ModelAndView feedback(@ModelAttribute CourseFeedbackForm feedback) {

        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("msg","Feedback saved successfully");

        return modelAndView;
    }

}
