package com.codecool.newsbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserData {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    @EqualsAndHashCode.Exclude
    private RegCredential regCredential;

    @OneToOne(cascade = CascadeType.PERSIST)
    @EqualsAndHashCode.Exclude
    private TopicSetting topicSetting;


    @ManyToMany
    @ToString.Exclude
            @EqualsAndHashCode.Exclude
    Set<Article> articles = new HashSet<>();
}
