package com.dolphin.spring_post.Domain;

import com.dolphin.spring_post.Enum.UserRoleType;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class User {


    @Id
    @Column(name = "user_id")
    private Long id;

    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRoleType userRoleType;

}
