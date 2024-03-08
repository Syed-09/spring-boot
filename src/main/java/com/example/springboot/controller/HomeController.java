package com.example.springboot.controller;


import com.example.springboot.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


//@Controller + @ResponseBody = @RestController
@RestController //@Controller + @ResponseBody
@RequestMapping("/")
public class HomeController {

    @GetMapping
    //@ResponseBody
    public List<Product> getAllProducts(){
        System.out.println("Inside Home Controller");
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(101, "Fridge", "Electronics", 10000));
        return productList; //JSON Format (by default)
    }
}
