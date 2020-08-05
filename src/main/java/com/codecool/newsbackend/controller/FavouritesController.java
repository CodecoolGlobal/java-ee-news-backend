package com.codecool.newsbackend.controller;

import com.codecool.newsbackend.entity.Article;
import com.codecool.newsbackend.entity.TopicSetting;
import com.codecool.newsbackend.service.FavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FavouritesController {

    @Autowired
    FavouritesService favouritesService;

    @RequestMapping(path = "/add-favourites", consumes = {MediaType.APPLICATION_JSON_VALUE}, method = POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String saveTopicSettings(@RequestBody Article article,  @RequestHeader String Authorization) {
        System.out.println(Authorization);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        favouritesService.addFavourite((String) authentication.getPrincipal(), article.title, article.url, article.imgurl);
        System.out.println("mizu: " + article);
        return "setting saved";
    }
}
