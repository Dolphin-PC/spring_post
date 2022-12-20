package com.dolphin.spring_post.Entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String title;
    private String contents;

    @ManyToOne
    @JoinColumn(name = "usr_id")
    private User user;
}
