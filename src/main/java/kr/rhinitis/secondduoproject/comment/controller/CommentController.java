package kr.rhinitis.secondduoproject.comment.controller;

import kr.rhinitis.secondduoproject.comment.dto.CommentDto;
import kr.rhinitis.secondduoproject.comment.service.CommentService;
import kr.rhinitis.secondduoproject.comment.service.CommentServiceImpl;
import kr.rhinitis.secondduoproject.posts.dto.PostDto;
import kr.rhinitis.secondduoproject.posts.entity.Posts;
import kr.rhinitis.secondduoproject.posts.service.PostServiceImpl;
import kr.rhinitis.secondduoproject.util.dto.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/posts/comment/{post-id}")
    public String postComment(CommentDto.Post postDto) {
        CommentDto.Response responseDto = commentService.createComment(postDto);
        return "redirect:/comment/" + responseDto.getCommentId();
    }

    @GetMapping("/comment/{member-id}")
    public String getMemberComment(@PageableDefault(page = 1, sort = "commentId", direction = Sort.Direction.DESC) Pageable pageable,
                           Model model) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize(), pageable.getSort());
        MultiResponseDto responseDto = commentService.readAllComment(pageRequest);
        model.addAttribute("comments", responseDto);
        return "comments";
    }

    @GetMapping("/comment/edit/{comment-id}")
    public String editForm(@PathVariable("comment-id") Long commentId, Model model) {
        CommentDto.Response responseDto = commentService.readComment(commentId);
        model.addAttribute("comment", responseDto);
        return "comment/editComment";
    }

    @PostMapping("/comment/edit/{comment-id}")
    public String patchPost(@PathVariable("comment-id") Long commentId,
                            CommentDto.Patch patchDto) {
        CommentDto.Response responseDto = commentService.updateComment(commentId, patchDto);
        return "redirect:/comment/" + responseDto.getCommentId();
    }

    @PostMapping("/comment/{comment-id}")
    public String deletePost(@PathVariable("comment-id") Long commentId) {
        commentService.deleteComment(commentId);
        return "redirect:/comment";
    }

}



