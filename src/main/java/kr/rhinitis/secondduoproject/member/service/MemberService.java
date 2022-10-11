package kr.rhinitis.secondduoproject.member.service;

import kr.rhinitis.secondduoproject.member.dto.MemberDto;
import org.springframework.stereotype.Service;

public interface MemberService {

    MemberDto.Response joinMember(MemberDto.Post postDto);
    MemberDto.Response findMember(Long memberId);
    MemberDto.Response updateMember(Long memberId,MemberDto.Patch patch);
    void deleteMember(Long memberId);

}
