package kr.rhinitis.secondduoproject.posts.mapper;

import kr.rhinitis.secondduoproject.posts.dto.PostDto;
import kr.rhinitis.secondduoproject.posts.entity.Posts;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Posts dtoToPost(PostDto.Post postDto);
    PostDto.Response postToResponse(Posts posts);
    List<PostDto.Response> postListToResponseList(List<Posts> postsList);
}
