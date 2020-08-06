package com.codecool.newsbackend.service;

import com.codecool.newsbackend.entity.Article;
import com.codecool.newsbackend.entity.UserData;
// import com.codecool.newsbackend.repository.ArticleUserSwitchRepository;
import com.codecool.newsbackend.repository.FavouritesRepository;
import com.codecool.newsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FavouritesService {

    @Autowired
    FavouritesRepository favouritesRepository;


    @Autowired
    UserRepository userRepository;

    public void addFavourite(String username, String title, String url, String urlToImg) {

        UserData userData = userRepository.getUserDataByUsername(username);

        Set<Article> articles = userData.getArticles();

        for ( Article article: articles ) {
            if(article.url == url) {

            }
        }
    }


}
