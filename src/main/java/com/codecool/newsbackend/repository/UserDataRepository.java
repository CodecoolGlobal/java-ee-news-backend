package com.codecool.newsbackend.repository;

import com.codecool.newsbackend.entity.Article;
import com.codecool.newsbackend.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDataRepository extends JpaRepository<UserData, Long> {


}
