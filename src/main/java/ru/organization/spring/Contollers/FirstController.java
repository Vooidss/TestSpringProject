package ru.organization.spring.Contollers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Scanner;

@Controller
public class FirstController {

    private Scanner messageRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView helloPage(HttpServletRequest request){

        ModelAndView model = new ModelAndView("first/hello");

        model.addObject("name",request.getParameter("name"));
        model.addObject("surname",request.getParameter("surname"));

        return model;
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

}
