package com.codecool.newsbackend.repository;

import com.codecool.newsbackend.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDataRepository extends JpaRepository<UserData, Long> {

}
