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
public class ArticleUserSwitch {

    @Id
    @GeneratedValue
    private Long id;

   @ManyToOne
    @JoinColumn(name = "article_id")
    Article article;

   @ManyToOne
    @JoinColumn(name = "userData_id")
    UserData userData;

   int valami;
}
