package kr.rhinitis.secondduoproject.util.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Address {

    //TODO 주소 API 사용시 PK 값을 받는것이 좋다.
    private String si;
    private String gu;
    private String dong;

    @Builder
    public Address(String si, String gu, String dong) {
        this.si = si;
        this.gu = gu;
        this.dong = dong;
    }
}
