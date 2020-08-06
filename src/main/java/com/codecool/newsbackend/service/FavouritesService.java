package com.codecool.newsbackend.service;

import com.codecool.newsbackend.entity.Article;
import com.codecool.newsbackend.entity.UserData;
// import com.codecool.newsbackend.repository.ArticleUserSwitchRepository;
import com.codecool.newsbackend.repository.FavouritesRepository;
import com.codecool.newsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FavouritesService {

    @Autowired
    FavouritesRepository favouritesRepository;


    @Autowired
    UserRepository userRepository;

    public void addFavourite(String username, String title, String url, String urlToImg) {

        UserData userData = userRepository.getUserDataByUsername(username);

        boolean articleSaved = favouritesRepository.existsArticleByUrl(url);

        if (!articleSaved) {
            Article newArticle = Article.builder()
                    .title(title)
                    .imgurl(urlToImg)
                    .url(url)
                    .userDatas(new HashSet<>())
                    .build();
            newArticle.addUser(userData);
            favouritesRepository.save(newArticle);
        } else {
            Article article = favouritesRepository.findArticleByUrl(url);
            article.addUser(userData);
            favouritesRepository.save(article);
        }
    }

    public List<Article> getFavourites(String username) {

        UserData userData = userRepository.getUserDataByUsername(username);
        Set<Article> articles = userData.getArticles();
        List<Article> targetList = new ArrayList<>(articles);
        System.out.println("targetList: " + targetList);
return targetList;
    }

}
