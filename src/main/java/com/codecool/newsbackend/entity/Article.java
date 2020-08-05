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
    public String url;

    @Column
    public String title;

    @Column(length = 1000)
    public String imgurl;
}
