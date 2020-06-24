package com.codecool.newsbackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class NewsController {



    @GetMapping("/dummy")
    public String dummy() {

        return "hello world";
    }

    @Autowired
    RestTemplate restTemplate;


    @Value("https://newsapi.org/v2/top-headlines?country=us&apiKey=00f7878a7a684b51a8f4eb8a56d4a033")
    String serviceURL;

    

    @CrossOrigin(origins = "http://localhost:3001")
    @GetMapping("/data")
    String getAllData() {

       return restTemplate.getForObject(serviceURL, String.class);
    }





}
