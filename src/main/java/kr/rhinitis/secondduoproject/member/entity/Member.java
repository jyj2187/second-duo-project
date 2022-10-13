package kr.rhinitis.secondduoproject.member.entity;

import kr.rhinitis.secondduoproject.member.dto.MemberDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String username;
    private String password;
    private String email;
    private String nickname;

    //임베디드로
    private String address;

    private String about;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

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
    public Member(Long memberId, String username, String password, String email, String nickname, String address, String about, MemberStatus memberStatus) {
        this.memberId = memberId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.address = address;
        this.about = about;
        this.memberStatus = MemberStatus.ACTIVE;
    }

    public void update(MemberDto.Patch patchDto){
        this.username = patchDto.getUsername();
        this.password = patchDto.getPassword();
        this.email = patchDto.getEmail();
        this.nickname = patchDto.getNickname();
        this.address = patchDto.getAddress();
        this.about = patchDto.getAbout();
    }
}
