package kr.rhinitis.secondduoproject.comment.service;

import kr.rhinitis.secondduoproject.comment.dto.CommentDto;
import kr.rhinitis.secondduoproject.util.dto.MultiResponseDto;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CommentService {
    CommentDto.Response createComment(CommentDto.Post postDto);
    //곧바로 리스트로 반환하는 것은 좋지않으니 유의
    CommentDto.Response readComment(Long commentId);
    List<CommentDto.Response> findComments(Long memberId);
    CommentDto.Response updateComment(Long commentId,CommentDto.Patch patch);
    MultiResponseDto readAllComment(PageRequest pageRequest);
    void deleteComment(Long commentId);
}
