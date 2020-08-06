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

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FavouritesController {

    @Autowired
    FavouritesService favouritesService;

    @RequestMapping(path = "/add-favourites", consumes = {MediaType.APPLICATION_JSON_VALUE}, method = POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String saveArticle(@RequestBody Article article,  @RequestHeader String Authorization) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        favouritesService.addFavourite((String) authentication.getPrincipal(), article.title, article.url, article.imgurl);

        return "setting saved";
    }


    @RequestMapping(value = "/get-favourites", method = GET)
    @ResponseBody
    public List<Article> getFavourites(@RequestHeader String Authorization) throws IllegalAccessException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());

        favouritesService.getFavourites((String) authentication.getPrincipal());
        return favouritesService.getFavourites((String) authentication.getPrincipal());
    }


}
