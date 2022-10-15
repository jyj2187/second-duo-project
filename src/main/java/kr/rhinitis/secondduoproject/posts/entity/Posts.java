package kr.rhinitis.secondduoproject.posts.entity;

import kr.rhinitis.secondduoproject.posts.dto.PostDto;
import kr.rhinitis.secondduoproject.util.audit.Auditable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Posts extends Auditable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String title;
    private String body;
    private PostStatus postStatus;
    // TODO: 조회수, 추천수 ///// 멤버 이미지 댓글
//    Member member;

    @Builder
    public Posts(Long postId, String title, String body, PostStatus postStatus) {
        this.postId = postId;
        this.title = title;
        this.body = body;
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
