package com.dolphin.spring_post.Service;

import com.dolphin.spring_post.Domain.Post;
import com.dolphin.spring_post.Domain.PostRepository;
import com.dolphin.spring_post.Dto.PostResDto;
import com.dolphin.spring_post.Dto.PostSaveReqDto;
import com.dolphin.spring_post.Dto.PostUpdateReqDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveReqDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateReqDto reqDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        post.update(reqDto.getTitle(), reqDto.getContent());

        return id;
    }

    public PostResDto findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        return new PostResDto(post);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }


}
