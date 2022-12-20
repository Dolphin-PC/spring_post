package com.dolphin.spring_post.Service;

import com.dolphin.spring_post.Domain.Post;
import com.dolphin.spring_post.Domain.PostRepository;
import com.dolphin.spring_post.Dto.PostSaveReqDto;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {


    @Autowired
    private PostRepository postRepository;

    @Test
    void save() {
        // given
        String title = "title";
        String content = "content";
        postRepository.save(Post.builder().title(title).content(content).author("pcy").build());

        //when
        List<Post> postList = postRepository.findAll();

        //then
        Post post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);

    }
}