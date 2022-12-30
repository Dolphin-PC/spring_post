package com.dolphin.springpost2.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class PostUpdateReqDto {

    private String title;
    private String content;

}
