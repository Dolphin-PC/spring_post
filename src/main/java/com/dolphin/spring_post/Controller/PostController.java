package com.dolphin.spring_post.Controller;

import com.dolphin.spring_post.Domain.Post;
import com.dolphin.spring_post.Dto.PostResDto;
import com.dolphin.spring_post.Dto.PostSaveReqDto;
import com.dolphin.spring_post.Dto.PostUpdateReqDto;
import com.dolphin.spring_post.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> posts () {
        return postService.findAll();
    }

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

    @DeleteMapping("/post/{id}")
    public void deletePostById(@PathVariable Long id) {
        postService.deleteById(id);
    }
}
