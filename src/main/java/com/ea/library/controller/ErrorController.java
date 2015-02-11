package com.ea.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @RequestMapping(value="/error", produces="application/json")
    public ModelAndView handle() {     
        return new ModelAndView("index");
    }

}
