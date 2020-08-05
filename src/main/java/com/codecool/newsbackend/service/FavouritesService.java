package com.codecool.newsbackend.service;

import com.codecool.newsbackend.entity.Article;
import com.codecool.newsbackend.entity.ArticleUserSwitch;
import com.codecool.newsbackend.entity.UserData;
// import com.codecool.newsbackend.repository.ArticleUserSwitchRepository;
import com.codecool.newsbackend.repository.FavouritesRepository;
import com.codecool.newsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouritesService {

    @Autowired
    FavouritesRepository favouritesRepository;

    // @Autowired
    // ArticleUserSwitchRepository articleUserSwitchRepository;

    @Autowired
    UserRepository userRepository;

    public void addFavourite(String username, String title, String url, String urlToImg) {

        UserData userData = userRepository.getUserDataByUsername(username);
        boolean alreadySavedToUser = true; //articleUserSwitchRepository.existsArticleUserSwitchByUrlAndUserId(url, userData.getId());

        System.out.println("saved to user: " + alreadySavedToUser);

        if (!alreadySavedToUser) {
            boolean articleSaved = favouritesRepository.existsArticleByUrl(url);
            if (!articleSaved) {
                Article favourite = Article.builder()
                        .title(title)
                        .url(url)
                        .imgurl(urlToImg)
                        .build();
                favouritesRepository.save(favourite);

            } /*
            ArticleUserSwitch userSwitch = ArticleUserSwitch.builder()
                    .url(url)
                    .userId(userData.getId())
                    .build();
            articleUserSwitchRepository.save(userSwitch); */

        }


    }


}
