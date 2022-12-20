package com.dolphin.spring_post.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "board")
    List<Board> boardList = new ArrayList<>();
}
