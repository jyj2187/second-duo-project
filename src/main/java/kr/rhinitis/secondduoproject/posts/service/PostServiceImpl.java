package kr.rhinitis.secondduoproject.posts.service;

import kr.rhinitis.secondduoproject.posts.dto.PostDto;
import kr.rhinitis.secondduoproject.util.dto.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{
    @Override
    public PostDto.Response createPost(PostDto.Post postDto) {
        return null;
    }

    @Override
    public PostDto.Response updatePost(Long postId, PostDto.Patch patchDto) {
        return null;
    }

    @Override
    public PostDto.Response readPost(Long postId) {
        return null;
    }

    @Override
    public MultiResponseDto readAllPost(PageRequest pageRequest) {
        return null;
    }

    @Override
    public void deletePost(Long postId) {

    }
}
