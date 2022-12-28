package com.dolphin.spring_post.Controller;

import com.dolphin.spring_post.Domain.Post;
import com.dolphin.spring_post.Dto.PostResDto;
import com.dolphin.spring_post.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.dolphin.spring_post.Util.setPagination;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping(value = { "/posts"})
    public String posts(
            Model model,
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<Post> posts = postService.findAll(pageable);
        model.addAttribute("postList", posts);
        model.addAttribute("pageInfo", setPagination(posts, pageable));
        return "posts";
    }

    @GetMapping("/new")
    public String newPost() {
        return "new";
    }

    @GetMapping("/post/{id}")
    public String detailPost(@PathVariable Long id, Model model) {
        PostResDto dto = postService.findById(id);
        model.addAttribute("post", dto);
        return "detail";
    }
}

