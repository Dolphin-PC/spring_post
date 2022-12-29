package com.dolphin.spring_post.Domain;

import com.dolphin.spring_post.Enum.UserRoleType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRoleType userRoleType;

//    @Builder
//    public User(String userName, String password, UserRoleType userRoleType) {
//        this.userName = userName;
//        this.password = password;
//        this.userRoleType = userRoleType;
//    }
}
