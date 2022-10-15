package kr.rhinitis.secondduoproject.posts.service;

import kr.rhinitis.secondduoproject.posts.dto.PostDto;
import kr.rhinitis.secondduoproject.util.dto.MultiResponseDto;
import org.springframework.data.domain.PageRequest;

public interface PostService {
    public PostDto.Response createPost(PostDto.Post postDto);
    public PostDto.Response updatePost(Long postId, PostDto.Patch patchDto);
    public PostDto.Response readPost(Long postId);
    public MultiResponseDto readAllPost(PageRequest pageRequest);
    public void deletePost(Long postId);
}
