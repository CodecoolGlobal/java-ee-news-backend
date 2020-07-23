package com.codecool.newsbackend.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
// @RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class NewsController {

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("sibaluca@gmail.com");
        mailSender.setPassword("Sqlninja@2020");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Autowired
    RestTemplate restTemplate;


    @Value("https://newsapi.org/v2/top-headlines?country=us&apiKey=00f7878a7a684b51a8f4eb8a56d4a033")
    String serviceURL;


    @GetMapping("/data")
    String getAllData() {
        System.out.println(restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&pageSize=4&apiKey=00f7878a7a684b51a8f4eb8a56d4a033", String.class));
        return restTemplate.getForObject(serviceURL, String.class);
    }

    @GetMapping("/firstFive")
    String getFirstFiveForMain() {
        //System.out.println(restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&pageSize=4&apiKey=00f7878a7a684b51a8f4eb8a56d4a033", String.class));
        return restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&pageSize=5&apiKey=00f7878a7a684b51a8f4eb8a56d4a033", String.class);
    }

    @GetMapping("/techFour")
    String technologyFirstFour() {
        //System.out.println(restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&pageSize=4&apiKey=00f7878a7a684b51a8f4eb8a56d4a033", String.class));
        return restTemplate.getForObject("http://newsapi.org/v2/top-headlines?country=us&category=technology&pageSize=4&apiKey=687acd6f80d44fe0b6c2c28d162fa674", String.class);
    }

    @GetMapping("/scienceFour")
    String scienceFirstFour() {
        //System.out.println(restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&pageSize=4&apiKey=00f7878a7a684b51a8f4eb8a56d4a033", String.class));
        return restTemplate.getForObject("http://newsapi.org/v2/top-headlines?country=us&category=science&pageSize=4&apiKey=687acd6f80d44fe0b6c2c28d162fa674", String.class);
    }

    @GetMapping("/generalFour")
    String generalFirstFour() {
        //System.out.println(restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&pageSize=4&apiKey=00f7878a7a684b51a8f4eb8a56d4a033", String.class));
        return restTemplate.getForObject("http://newsapi.org/v2/top-headlines?country=us&category=general&pageSize=4&apiKey=687acd6f80d44fe0b6c2c28d162fa674", String.class);
    }

//    @GetMapping("/data")
//    String getAllData() {
//        System.out.println(restTemplate.getForObject(serviceURL, String.class));
//        return restTemplate.getForObject(serviceURL, String.class);
//    }


    @RequestMapping(value = "/search/{urlParam}", method = GET)
    @ResponseBody
    public String search( @PathVariable String urlParam) {
        String url = "https://newsapi.org/v2/everything?q=" + urlParam + "&apiKey=00f7878a7a684b51a8f4eb8a56d4a033";
        return restTemplate.getForObject(url, String.class);
    }


    @GetMapping("/business")
    public String getBusiness() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }


    @GetMapping("/entertainment")
    public String getEntertainment() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=entertainment&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }


    @GetMapping("/general")
    public String getGeneral() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=general&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }


    @GetMapping("/health")
    public String getHealth() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=health&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }


    @GetMapping("/science")
    public String getScience() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=science&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }


    @GetMapping("/sports")
    public String getSports() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }


    @GetMapping("/technology")
    public String getTechnology() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=technology&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }

    public static String MyGETRequest(String url) throws IOException {
        String apiKey = "687acd6f80d44fe0b6c2c28d162fa674";

        URL urlForGetRequest = new URL(url);
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            return response.toString();
        } else {

            System.out.println("GET NOT WORKED: " + url );
            return "something went wrong :( url not working: " + url;
        }

    }



}
