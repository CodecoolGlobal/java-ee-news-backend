package com.codecool.newsbackend.repository;

import com.codecool.newsbackend.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface FavouritesRepository extends JpaRepository<Article, Long> {

    boolean existsArticleByUrl(String url);

    Article findArticleByUrl(String url);
}
