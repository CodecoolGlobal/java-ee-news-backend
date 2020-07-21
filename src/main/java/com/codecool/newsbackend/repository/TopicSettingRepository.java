package com.codecool.newsbackend.repository;

import com.codecool.newsbackend.entity.TopicSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicSettingRepository extends JpaRepository<TopicSetting, Long> {
}
