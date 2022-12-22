package com.dolphin.spring_post.Controller;

import com.dolphin.spring_post.Dto.PostResDto;
import com.dolphin.spring_post.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String index() {
        return "index";
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

