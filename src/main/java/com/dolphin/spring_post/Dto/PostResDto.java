package com.dolphin.spring_post.Dto;

import com.dolphin.spring_post.Domain.Post;
import lombok.Getter;

@Getter
public class PostResDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostResDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
