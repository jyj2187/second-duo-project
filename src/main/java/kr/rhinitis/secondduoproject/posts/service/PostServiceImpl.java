package kr.rhinitis.secondduoproject.posts.service;

import kr.rhinitis.secondduoproject.posts.dto.PostDto;
import kr.rhinitis.secondduoproject.posts.entity.Posts;
import kr.rhinitis.secondduoproject.posts.mapper.PostMapper;
import kr.rhinitis.secondduoproject.posts.repository.PostRepository;
import kr.rhinitis.secondduoproject.util.dto.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{
    private final PostMapper postMapper;
    private final PostRepository postRepository;
    @Override
    public PostDto.Response createPost(PostDto.Post postDto) {
        Posts posts = postMapper.dtoToPost(postDto);
        postRepository.save(posts);
        return postMapper.postToResponse(posts);
    }

    @Override
    public PostDto.Response updatePost(Long postId, PostDto.Patch patchDto) {
        Posts posts = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("something"));
        posts.updatePosts(patchDto);
        postRepository.save(posts);
        return postMapper.postToResponse(posts);
    }

    @Override
    public PostDto.Response readPost(Long postId) {
        Posts posts = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("something"));
        return postMapper.postToResponse(posts);
    }

    @Override
    public MultiResponseDto readAllPost(PageRequest pageRequest) {
        Page<Posts> postsPage = postRepository.findAll(pageRequest);
        List<Posts> postsList = postsPage.getContent();
        // TODO : PageInfo 에 T 설정해줬는데 안 먹히면 바꾸자
        return new MultiResponseDto(postMapper.postListToResponseList(postsList), postsPage);
    }

    @Override
    public void deletePost(Long postId) {
        Posts posts = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("something"));
        posts.inactive();
        postRepository.save(posts);
    }
}
