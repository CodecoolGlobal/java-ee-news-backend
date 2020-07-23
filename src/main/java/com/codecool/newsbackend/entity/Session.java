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
public class Session {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long sessionId;


    @OneToOne(cascade = CascadeType.PERSIST)
    private RegCredential regCredential;
}
