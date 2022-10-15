package kr.rhinitis.secondduoproject.posts.controller;

import kr.rhinitis.secondduoproject.posts.dto.PostDto;
import kr.rhinitis.secondduoproject.posts.service.PostServiceImpl;
import kr.rhinitis.secondduoproject.util.dto.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostApiController {
    private final PostServiceImpl postServiceImpl;

    @PostMapping
    public ResponseEntity postPost(@RequestBody PostDto.Post postDto) {
        PostDto.Response responseDto = postServiceImpl.createPost(postDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{post-id}")
    public ResponseEntity getPost(@PathVariable("post-id") Long postId) {
        PostDto.Response responseDto = postServiceImpl.readPost(postId);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getPosts(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize(), pageable.getSort());
        MultiResponseDto responseDto = postServiceImpl.readAllPost(pageRequest);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{post-id}")
    public ResponseEntity patchPost(@PathVariable("post-id") Long postId,
                                    @RequestBody PostDto.Patch patchDto) {
        PostDto.Response responseDto = postServiceImpl.updatePost(postId, patchDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{post-id}")
    public ResponseEntity deletePost(@PathVariable("post-id") Long postId) {
        postServiceImpl.deletePost(postId);
        return new ResponseEntity<>("정상적으로 삭제되었습니다.", HttpStatus.NO_CONTENT);
    }
}
