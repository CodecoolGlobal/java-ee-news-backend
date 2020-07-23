package com.codecool.newsbackend.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RegCredential {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;

    @Column(nullable = true)
    private LocalDateTime registrationTime;

    @OneToOne(mappedBy = "regCredential")
    @EqualsAndHashCode.Exclude
    private UserData userData;


}
