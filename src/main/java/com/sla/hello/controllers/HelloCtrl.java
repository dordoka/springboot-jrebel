package com.sla.hello.controllers;

import com.sla.hello.models.Customer;
import com.sla.hello.models.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.stream.StreamSupport;

@Controller
public class HelloCtrl {

    @Autowired
    private ApplicationContext ctx;

    @RequestMapping("/hello")
    public String hi(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name", name);

        System.out.println(new Date().toString());
        System.out.println("============================");



        return "hi";
    }

}
