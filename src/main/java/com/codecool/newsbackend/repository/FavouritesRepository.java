package com.codecool.newsbackend.repository;

import com.codecool.newsbackend.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface FavouritesRepository extends JpaRepository<Article, Long> {

    // boolean findArticleByUrl(String url);

    boolean existsArticleByUrl(String url);

    //Article findArticleByTitleAndUserData_Id(String title, Long user_data_id);

    /*
    @Modifying
    @Transactional
    @Query(" into TopicSetting ts set ts.business = :business, ts.entertainment= :entertainment, ts.general = :general," +
            " ts.health = :health, ts.science = :science, ts.sports = :sports, ts.technology = :technology " +
            "where ts.id = (select u.topicSetting.id from UserData u where u.id = :user_id)")
    void addFavouriteArticle(@Param("user_id") Long user_id, @Param("title") String title, @Param("url") String url, @Param("urlToImage") String urlToImage); */
}
