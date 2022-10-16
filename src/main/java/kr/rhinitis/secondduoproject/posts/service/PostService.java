package kr.rhinitis.secondduoproject.posts.service;

import kr.rhinitis.secondduoproject.posts.dto.PostDto;
import kr.rhinitis.secondduoproject.util.dto.MultiResponseDto;
import org.springframework.data.domain.PageRequest;

public interface PostService {
    PostDto.Response createPost(PostDto.Post postDto);
    PostDto.Response updatePost(Long postId, PostDto.Patch patchDto);
    PostDto.Response readPost(Long postId);
    MultiResponseDto readAllPost(PageRequest pageRequest);
    void deletePost(Long postId);
}
