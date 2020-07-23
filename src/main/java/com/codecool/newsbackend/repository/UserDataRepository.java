package com.codecool.newsbackend.repository;

import com.codecool.newsbackend.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Long> {

}
