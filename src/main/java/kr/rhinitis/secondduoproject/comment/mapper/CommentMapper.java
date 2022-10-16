package kr.rhinitis.secondduoproject.comment.mapper;

import kr.rhinitis.secondduoproject.comment.dto.CommentDto;
import kr.rhinitis.secondduoproject.comment.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment dtoToComment(CommentDto.Post postDto);
    CommentDto.Response commentToResponse(Comment comment);
    List<CommentDto.Response> commentListToResponseList(List<Comment> commentList);
}
