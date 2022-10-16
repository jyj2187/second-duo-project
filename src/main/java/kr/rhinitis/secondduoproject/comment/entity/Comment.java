package kr.rhinitis.secondduoproject.comment.entity;

import kr.rhinitis.secondduoproject.comment.dto.CommentDto;
import kr.rhinitis.secondduoproject.member.entity.Member;
import kr.rhinitis.secondduoproject.posts.entity.Posts;
import kr.rhinitis.secondduoproject.util.audit.Auditable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends Auditable {

    @Id @GeneratedValue
    private Long commentId;
    private String body;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts post;

    @Builder
    public Comment(Long commentId, String body,Member member,Posts post) {
        this.commentId = commentId;
        this.body = body;
        this.member = member;
        this.post = post;
    }

    public void updateComment(CommentDto.Patch patchDto){
        this.body = patchDto.getBody();
    }

    public void setMember(Member member){
        this.member = member;
    }

    public void setPost(Posts post){
        this.post = post;
    }
}
