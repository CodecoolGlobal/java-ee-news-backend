package com.codecool.newsbackend.model;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    private static void getEmployees()
    {
        final String uri = "http://localhost:8080/springrestexample/employees.json";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
    }
}
