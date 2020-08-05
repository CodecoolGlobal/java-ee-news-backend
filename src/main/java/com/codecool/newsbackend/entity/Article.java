package com.codecool.newsbackend.entity;

import lombok.*;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "article")
    Set <ArticleUserSwitch> articleUserSwitches;
}
