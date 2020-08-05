package com.codecool.newsbackend.service;

import com.codecool.newsbackend.entity.Article;
import com.codecool.newsbackend.entity.UserData;
import com.codecool.newsbackend.repository.FavouritesRepository;
import com.codecool.newsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavouritesService {

    @Autowired
    FavouritesRepository favouritesRepository;

    @Autowired
    UserRepository userRepository;

    public void addFavourite(String username, String title, String url, String urlToImg) {

        UserData userData = userRepository.getUserDataByUsername(username);
        Article articleByTitle = favouritesRepository.findArticleByTitleAndUserData_Id(title, userData.getId());

        System.out.println("articleByTitle: " + articleByTitle);

        if (articleByTitle == null) {

            Article favourite = Article.builder()
                    .userData(userData)
                    .title(title)
                    .url(url)
                    .imgurl(urlToImg)
                    .build();
            favouritesRepository.save(favourite);
        }


    }
}
