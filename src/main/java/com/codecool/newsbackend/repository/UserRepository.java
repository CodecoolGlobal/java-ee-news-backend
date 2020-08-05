package com.codecool.newsbackend.repository;

import com.codecool.newsbackend.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserData, Long> {
    Optional<UserData> findByUsername(String username);

    UserData getUserDataByUsername(String username);

}
