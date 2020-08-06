package com.codecool.newsbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicSettingSend {

    public boolean business;

    public boolean entertainment;

    public boolean general;

    public boolean health;

    public boolean science;

    public boolean sports;

    public boolean technology;
}
