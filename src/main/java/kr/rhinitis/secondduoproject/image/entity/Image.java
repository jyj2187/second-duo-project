package kr.rhinitis.secondduoproject.image.entity;

import kr.rhinitis.secondduoproject.item.entity.Item;
import kr.rhinitis.secondduoproject.member.entity.Member;
import kr.rhinitis.secondduoproject.posts.entity.Posts;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String originName;
    private String storedName;
    private String storedPath;
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts posts;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Builder
    public Image(Long imageId, String originName, String storedName, String storedPath, Member member, Posts posts, Item item) {
        this.imageId = imageId;
        this.originName = originName;
        this.storedName = storedName;
        this.storedPath = storedPath;
        this.member = member;
        this.posts = posts;
        this.item = item;
    }

    public void setPosts(Posts posts) {
        if (posts == null) {
            this.posts = null;
        } else {
            this.posts = posts;
        }
    }

    public void setMember(Member member) {
        if (member == null) {
            this.member = null;
        } else {
            this.member = member;
        }
    }

    public void setItem(Item item) {
        if (item == null) {
            this.item = null;
        } else {
            this.item = item;
        }
    }
}
