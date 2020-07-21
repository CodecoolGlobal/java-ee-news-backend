package com.codecool.newsbackend.repository;

import com.codecool.newsbackend.entity.RegCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface RegCredentialRepository extends JpaRepository<RegCredential, Long> {
}
