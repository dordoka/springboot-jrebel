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

        CustomerRepo repo = ctx.getBean(CustomerRepo.class);


        repo.save(new Customer("Jack", "Blu"));
        repo.save(new Customer("Chloe", "Blau"));
        repo.save(new Customer("Aliron", "tximpon"));
        repo.save(new Customer("David", "Palmer"));
        repo.save(new Customer("Michelle", "Dressler"));

        System.out.println("testing");
        Iterable<Customer> customers = repo.findAll();
        System.out.println("Customer List");


        for (Customer customer : customers) {
            System.out.println(customer);
        }

        StreamSupport.stream(customers.spliterator(), false)
                .forEach(System.out::println);

        repo.findByFirstName("Michelle")
                .stream()
                .forEach(System.out::println);

        System.out.println(new Date().toString());
        System.out.println("============================");
        System.out.println("============================");
        System.out.println("============================");
        System.out.println("asdfasdfasdfasf");


        return "hi";
    }

}
