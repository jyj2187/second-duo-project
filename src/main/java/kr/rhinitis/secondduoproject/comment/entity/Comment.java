package kr.rhinitis.secondduoproject.comment.entity;

import kr.rhinitis.secondduoproject.comment.dto.CommentDto;
import kr.rhinitis.secondduoproject.util.audit.Auditable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends Auditable {

    @Id @GeneratedValue
    private Long commentId;
    private String body;
    //private Member member;
    //private Posts posts;

    @Builder
    public Comment(Long commentId, String body) {
        this.commentId = commentId;
        this.body = body;
    }

    public void updateComment(CommentDto.Patch patchDto){
        this.body = patchDto.getBody();
    }
}
