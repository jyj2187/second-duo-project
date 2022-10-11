package kr.rhinitis.secondduoproject.member.service;

import kr.rhinitis.secondduoproject.member.dto.MemberDto;
import kr.rhinitis.secondduoproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDto.Response joinMember(MemberDto.Post postDto) {
        return null;
    }

    @Override
    public MemberDto.Response findMember(Long memberId) {
        return null;
    }

    @Override
    public MemberDto.Response updateMember(Long memberId, MemberDto.Patch patch) {
        return null;
    }

    @Override
    public void deleteMember(Long memberId) {

    }
}
