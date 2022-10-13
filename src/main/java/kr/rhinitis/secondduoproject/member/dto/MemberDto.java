package kr.rhinitis.secondduoproject.member.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Post{
        private String username;
        private String password;
        private String email;
        private String nickname;

        //임베디드로
        private String address;

        private String about;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response{
        private String username;
        private String password;
        private String email;
        private String nickname;

        //임베디드로
        private String address;

        private String about;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Patch{
        private String username;
        private String password;
        private String email;
        private String nickname;

        //임베디드로
        private String address;

        private String about;
    }
}
