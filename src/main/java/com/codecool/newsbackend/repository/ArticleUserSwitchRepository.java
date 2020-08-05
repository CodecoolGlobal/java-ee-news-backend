package com.codecool.newsbackend.repository;

import com.codecool.newsbackend.entity.ArticleUserSwitch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;
import java.util.List;

public interface ArticleUserSwitchRepository extends JpaRepository<ArticleUserSwitch, Long> {

    // boolean findArticleUserSwitchByUrlAndUserId(String url, Long userId);

    boolean existsArticleUserSwitchByUrlAndUserId(String url, Long userId);



}
