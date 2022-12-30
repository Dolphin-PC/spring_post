package com.dolphin.springpost2.Controller;

import com.dolphin.springpost2.Domain.Post;
import com.dolphin.springpost2.Dto.PostResDto;
import com.dolphin.springpost2.Dto.PostSaveReqDto;
import com.dolphin.springpost2.Dto.PostUpdateReqDto;
import com.dolphin.springpost2.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @DeleteMapping("/post/{id}")
    public void deletePostById(@PathVariable Long id) {
        postService.deleteById(id);
    }
}
