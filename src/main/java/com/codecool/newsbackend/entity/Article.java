package com.codecool.newsbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    public String url;

    @Column
    public String title;

    @Column(length = 1000)
    public String imgurl;

    @ManyToMany(mappedBy = "articles")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Set<UserData> userDatas;

    public void addUser(UserData userData) {
        this.userDatas.add(userData);
        userData.getArticles().add(this);
    }
}
