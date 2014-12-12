package com.sla.hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class HelloCtrl {

    @RequestMapping("/hello")
    public String hi(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name", name);

        System.out.println(new Date().toString());
        System.out.println("============================");


        return "hi";
    }

}
