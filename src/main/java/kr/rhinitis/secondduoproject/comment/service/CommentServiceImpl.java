package kr.rhinitis.secondduoproject.comment.service;

import kr.rhinitis.secondduoproject.comment.dto.CommentDto;
import kr.rhinitis.secondduoproject.comment.entity.Comment;
import kr.rhinitis.secondduoproject.comment.mapper.CommentMapper;
import kr.rhinitis.secondduoproject.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper mapper;

    @Override
    public CommentDto.Response joinComment(CommentDto.Post postDto) {
        Comment comment = mapper.dtoToComment(postDto);
        commentRepository.save(comment);
        return mapper.commentToResponse(comment);
    }

    @Override
    public List<CommentDto.Response> findComments(Long memberId) {
        //TODO 연관관계 이후
        return null;
    }

    @Override
    public CommentDto.Response updateComment(Long commentId, CommentDto.Patch patch) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.updateComment(patch);
        commentRepository.save(comment);
        return mapper.commentToResponse(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
