package com.codecool.newsbackend.repository;

import com.codecool.newsbackend.entity.RegCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RegCredentialRepository extends JpaRepository<RegCredential, Long> {

    boolean existsByUsernameOrEmail(String username, String email);
    boolean existsByUsernameAndPassword(String username, String password);

    @Query("SELECT r.id from RegCredential r where r.username like :userName")
    int getByUserId(@Param("userName") String userName);

    @Query("SELECT u.id from UserData u where u.regCredential.id = (SELECT id from RegCredential where username = :userName)")
    int getUserDataId(@Param("userName") String userName);

}
