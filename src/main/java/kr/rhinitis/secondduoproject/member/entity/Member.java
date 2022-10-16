package kr.rhinitis.secondduoproject.member.entity;

import kr.rhinitis.secondduoproject.comment.entity.Comment;
import kr.rhinitis.secondduoproject.image.entity.Image;
import kr.rhinitis.secondduoproject.item.entity.Item;
import kr.rhinitis.secondduoproject.member.dto.MemberDto;
import kr.rhinitis.secondduoproject.posts.entity.Posts;
import kr.rhinitis.secondduoproject.util.audit.Auditable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends Auditable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String username;
    private String password;
    private String email;
    private String nickname;

    //임베디드로
    private String address;

    private String about;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String profileImage;

    @OneToMany(mappedBy = "member")
    private List<Posts> postsList;

    @OneToMany(mappedBy = "member")
    private List<Item> itemsList;

    @OneToMany(mappedBy = "member")
    private List<Comment> commentList;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @Getter
    public enum Role {

        ROLE_ADMIN("관리자"), ROLE_MEMBER("일반사용자");

        private String description;

        Role(String description) {
            this.description = description;
        }
    }

    public enum MemberStatus {

        ACTIVE(1, "활동 중"),
        SUSPENSION(2, "정지 계정"),
        SLEEPER(3, "휴면 계정"),
        WITHDRAWAL(4, "삭제");

        private int stepNumber;

        private String memberDescription;

        MemberStatus(int stepNumber, String memberDescription) {
            this.stepNumber = stepNumber;
            this.memberDescription = memberDescription;
        }
    }

    @Builder
    public Member(Long memberId, String username, String password, String email, String nickname, String address, String about, Role role, String image, List<Posts> postsList, List<Item> itemsList, List<Comment> commentList, MemberStatus memberStatus) {
        this.memberId = memberId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.address = address;
        this.about = about;
        this.role = role == null ? Role.ROLE_MEMBER : role;
        this.profileImage = image;
        this.postsList = postsList;
        this.itemsList = itemsList;
        this.commentList = commentList;
        this.memberStatus = memberStatus == null ? MemberStatus.ACTIVE : memberStatus;
    }

    public void update(MemberDto.Patch patchDto){
        this.username = patchDto.getUsername();
        this.password = patchDto.getPassword();
        this.email = patchDto.getEmail();
        this.nickname = patchDto.getNickname();
        this.address = patchDto.getAddress();
        this.about = patchDto.getAbout();
    }

    public void setDefaultImage(String defaultImage) {
        this.profileImage = defaultImage;
    }
}
