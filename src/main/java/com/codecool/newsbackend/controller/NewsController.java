package com.codecool.newsbackend.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping
public class NewsController {

    @GetMapping("/dummy")
    public String dummy() {
System.out.println("i was called");

        return "hello world";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/business")
    public String getBusiness() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/entertainment")
    public String getEntertainment() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=entertainment&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/general")
    public String getGeneral() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=general&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/health")
    public String getHealth() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=health&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/science")
    public String getScience() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=science&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/sports")
    public String getSports() throws IOException {

        return MyGETRequest("http://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
    }

    @CrossOrigin(origins = "http://localhost:3000")
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
        // conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            // print result
            System.out.println("JSON String Result " + response.toString());
            //GetAndPost.POSTRequest(response.toString());
            return response.toString();
        } else {
            System.out.println("GET NOT WORKED");
            return "something went wrong :(";
        }

    }

}
