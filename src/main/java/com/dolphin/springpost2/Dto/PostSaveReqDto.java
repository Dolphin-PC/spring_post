package com.dolphin.springpost2.Dto;

import com.dolphin.springpost2.Domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @Builder
public class PostSaveReqDto {

    private String title;
    private String content;
    private String author;

//    @Builder
//    public PostSaveReqDto(String title, String content, String author) {
//        this.title = title;
//        this.content = content;
//        this.author = author;
//    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
