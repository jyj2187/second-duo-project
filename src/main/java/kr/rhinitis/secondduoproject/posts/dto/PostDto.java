package kr.rhinitis.secondduoproject.posts.dto;

import kr.rhinitis.secondduoproject.posts.entity.Posts;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PostDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Post{
        private String title;
        private String body;

        @Builder
        public Post(String title, String body) {
            this.title = title;
            this.body = body;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Patch{
        private String title;
        private String body;

        @Builder
        public Patch(String title, String body) {
            this.title = title;
            this.body = body;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response{
        private Long postId;
        private String title;
        private String body;
        private Posts.PostStatus postStatus;

        @Builder
        public Response(Long postId, String title, String body, Posts.PostStatus postStatus) {
            this.postId = postId;
            this.title = title;
            this.body = body;
            this.postStatus = postStatus;
        }
    }
}
