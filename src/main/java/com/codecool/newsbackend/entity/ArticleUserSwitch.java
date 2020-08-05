package com.codecool.newsbackend.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ArticleUserSwitch {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String url;

    @Column
    private Long userId;
}
