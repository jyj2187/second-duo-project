package kr.rhinitis.secondduoproject.comment.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

public class CommentDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class Post{
        private String body;

        public Post(String body) {
            this.body = body;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class Patch{
        private String body;

        public Patch(String body) {
            this.body = body;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class Response{
        private Long commentId;
        private String body;
        //member id?
        //member name?
        private LocalDateTime createAt;
        private LocalDateTime modifyAt;

        public Response(Long commentId,String body, LocalDateTime createAt, LocalDateTime modifyAt) {
            this.commentId = commentId;
            this.body = body;
            this.createAt = createAt;
            this.modifyAt = modifyAt;
        }
    }
}
