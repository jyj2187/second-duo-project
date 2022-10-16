package kr.rhinitis.secondduoproject.posts.controller;

import kr.rhinitis.secondduoproject.posts.dto.PostDto;
import kr.rhinitis.secondduoproject.posts.service.PostService;
import kr.rhinitis.secondduoproject.posts.service.PostServiceImpl;
import kr.rhinitis.secondduoproject.util.dto.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;

    @GetMapping("/posts/add")
    public String addForm() {
        return "posts/addPost";
    }

    @PostMapping("/posts/add")
    public String postPost(PostDto.Post postDto) {
        PostDto.Response responseDto = postService.createPost(postDto);
        return "redirect:/posts/" + responseDto.getPostId();
    }

    @GetMapping("/posts/{post-id}")
    public String getPost(@PathVariable("post-id") Long postId, Model model) {
        PostDto.Response responseDto = postService.readPost(postId);
        model.addAttribute("post", responseDto);
        return "posts/post";
    }

    @GetMapping("/posts")
    public String getPosts(@PageableDefault(page = 1, sort = "postId", direction = Sort.Direction.DESC) Pageable pageable,
                           Model model) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize(), pageable.getSort());
        MultiResponseDto responseDto = postService.readAllPost(pageRequest);
        model.addAttribute("posts", responseDto);
        return "posts";
    }

    @GetMapping("/posts/edit/{post-id}")
    public String editForm(@PathVariable("post-id") Long postId, Model model) {
        PostDto.Response responseDto = postService.readPost(postId);
        model.addAttribute("post", responseDto);
        return "posts/editPost";
    }

    @PostMapping("/posts/edit/{post-id}")
    public String patchPost(@PathVariable("post-id") Long postId,
                                    PostDto.Patch patchDto) {
        PostDto.Response responseDto = postService.updatePost(postId, patchDto);
        return "redirect:/posts/" + responseDto.getPostId();
    }

    @PostMapping("/posts/{post-id}")
    public String deletePost(@PathVariable("post-id") Long postId) {
        postService.deletePost(postId);
        return "redirect:/posts";
    }
}
