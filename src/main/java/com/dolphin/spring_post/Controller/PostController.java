package com.dolphin.spring_post.Controller;

import com.dolphin.spring_post.Dto.PostResDto;
import com.dolphin.spring_post.Dto.PostSaveReqDto;
import com.dolphin.spring_post.Dto.PostUpdateReqDto;
import com.dolphin.spring_post.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;


    @PostMapping("/post")
    public Long save(@RequestBody PostSaveReqDto requestDto) {
        return postService.save(requestDto);
    }

    @PutMapping("/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateReqDto reqDto) {
        return postService.update(id, reqDto);
    }

    @GetMapping("/post/{id}")
    public PostResDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }
}
