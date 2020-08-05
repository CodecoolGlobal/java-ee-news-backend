package com.codecool.newsbackend.repository;

import com.codecool.newsbackend.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouritesRepository extends JpaRepository<Article, Long> {
}
