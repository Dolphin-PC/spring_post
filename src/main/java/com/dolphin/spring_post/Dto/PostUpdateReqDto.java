package com.dolphin.spring_post.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class PostUpdateReqDto {

    private String title;
    private String content;

}
