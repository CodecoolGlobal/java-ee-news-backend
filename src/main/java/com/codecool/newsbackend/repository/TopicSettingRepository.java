package com.codecool.newsbackend.repository;

import com.codecool.newsbackend.entity.TopicSetting;
import com.codecool.newsbackend.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface TopicSettingRepository extends JpaRepository<TopicSetting, Long> {

    @Modifying
    @Transactional
    @Query("update TopicSetting ts set ts.business = :business, ts.entertainment= :entertainment, ts.general = :general," +
            " ts.health = :health, ts.science = :science, ts.sports = :sports, ts.technology = :technology " +
            "where ts.id = (select u.topicSetting.id from UserData u where u.id = :user_id)")
    void updateUserTopicSettingsByUserId(@Param("user_id") Long user_id, @Param("business") boolean business ,
                                         @Param("entertainment") boolean entertainment,
                                         @Param("general") boolean general, @Param("health") boolean health,
                                         @Param("science") boolean science, @Param("sports") boolean sports,
                                         @Param("technology") boolean technology );

    @Modifying
    @Transactional
    @Query("update TopicSetting ts set ts.business = :business, ts.entertainment= :entertainment, ts.general = :general," +
            " ts.health = :health, ts.science = :science, ts.sports = :sports, ts.technology = :technology " +
            "where ts.id = (select u.topicSetting.id from UserData u where u.username = :user_name)")
    void updateUserTopicSettingsByUserName(@Param("user_name") String user_name, @Param("business") boolean business ,
                                         @Param("entertainment") boolean entertainment,
                                         @Param("general") boolean general, @Param("health") boolean health,
                                         @Param("science") boolean science, @Param("sports") boolean sports,
                                         @Param("technology") boolean technology );


    @Query("select ts from TopicSetting ts join ts.userData u where u.id = :user_id")
    TopicSetting getUserChosenTopicsByUserId(@Param("user_id") Long user_id);

    @Query("select ts from TopicSetting ts where ts.id = (select u.topicSetting.id from UserData u where u.username = :user_name)")
    TopicSetting getUserChosenTopicsByUserName(@Param("user_name") String user_name);




}
