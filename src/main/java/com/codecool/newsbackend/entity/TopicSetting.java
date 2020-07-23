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

    public boolean business;

    public boolean entertainment;

    public boolean general;

    public boolean health;

    public boolean science;

    public boolean sports;

    public boolean technology;

    @OneToOne(mappedBy = "topicSetting")
    @EqualsAndHashCode.Exclude
    private UserData userData;
}
