package com.codecool.newsbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserData {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @OneToOne(cascade = CascadeType.PERSIST)
    private RegCredential regCredential;

    @OneToOne(cascade = CascadeType.PERSIST)
    private TopicSetting topicSetting;

}
