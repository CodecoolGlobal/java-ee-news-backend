package com.codecool.newsbackend.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TopicSetting {
    @Id
    @GeneratedValue
    private Long id;

    private boolean business;

    private boolean entertainment;

    private boolean general;

    private boolean health;

    private boolean science;

    private boolean sports;

    private boolean technology;

    @OneToOne(mappedBy = "topicSetting")
    @EqualsAndHashCode.Exclude
    private UserData userData;
}
