package kr.rhinitis.secondduoproject.posts.entity;

import kr.rhinitis.secondduoproject.comment.entity.Comment;
import kr.rhinitis.secondduoproject.image.entity.Image;
import kr.rhinitis.secondduoproject.member.entity.Member;
import kr.rhinitis.secondduoproject.posts.dto.PostDto;
import kr.rhinitis.secondduoproject.util.audit.Auditable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Posts extends Auditable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String title;
    private String body;
    private PostStatus postStatus;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToMany(mappedBy = "posts")
    private List<Comment> commentList;
    @OneToMany(mappedBy = "posts")
    private List<Image> imagesList;

    @Builder
    public Posts(Long postId, String title, String body,Member member,List<Comment> commentList,List<Image> imagesList, PostStatus postStatus) {
        this.postId = postId;
        this.title = title;
        this.body = body;
        this.member = member;
        this.commentList = commentList;
        this.imagesList = imagesList;
        this.postStatus = postStatus == null ? PostStatus.ACTIVE : postStatus;
    }

    public enum PostStatus{
        INACTIVE("비활성화"),
        ACTIVE("활성화");

        String postDescription;

        PostStatus(String postDescription) {
            this.postDescription = postDescription;
        }
    }

    public void updatePosts(PostDto.Patch patchDto) {
        this.title = patchDto.getTitle();
        this.body = patchDto.getBody();
    }

    public void inactive() {
        this.postStatus = PostStatus.INACTIVE;
    }

}
