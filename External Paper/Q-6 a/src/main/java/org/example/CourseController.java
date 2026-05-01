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

    @GetMapping("/course")
    public ModelAndView showForm(Model model){
        model.addAttribute("courses", Arrays.asList("Python Programming","Data Science","Coud Computing"));

        return new ModelAndView("form","model",model);
    }

    @PostMapping("/course")
    public ModelAndView saveCourse(@Valid @ModelAttribute Course course, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("course", Arrays.asList("Python Programming","Data Science","Coud Computing"));
            return new ModelAndView("form","model",model);
        }

        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("msg","Course registered successfully");

        return modelAndView;
    }
}
