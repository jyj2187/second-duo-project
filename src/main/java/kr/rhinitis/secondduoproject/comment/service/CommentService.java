package kr.rhinitis.secondduoproject.comment.service;

import kr.rhinitis.secondduoproject.comment.dto.CommentDto;
import kr.rhinitis.secondduoproject.member.dto.MemberDto;

import java.util.List;

public interface CommentService {
    CommentDto.Response joinComment(CommentDto.Post postDto);
    //곧바로 리스트로 반환하는 것은 좋지않으니 유의
    List<CommentDto.Response> findComments(Long memberId);
    CommentDto.Response updateComment(Long commentId,CommentDto.Patch patch);
    void deleteComment(Long commentId);
}
