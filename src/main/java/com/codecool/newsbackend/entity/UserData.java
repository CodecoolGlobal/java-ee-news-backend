package com.codecool.newsbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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


    @Singular
    @OneToMany(mappedBy = "userData", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Article> favouriteArticles;

}
