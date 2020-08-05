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

    @ManyToOne
    private UserData userData;

    public String title;
    public String url;
    public String imgurl;
}
