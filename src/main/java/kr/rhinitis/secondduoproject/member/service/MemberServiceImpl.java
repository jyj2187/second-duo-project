package kr.rhinitis.secondduoproject.member.service;

import kr.rhinitis.secondduoproject.member.dto.MemberDto;
import kr.rhinitis.secondduoproject.member.entity.Member;
import kr.rhinitis.secondduoproject.member.mapper.MemberMapper;
import kr.rhinitis.secondduoproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public MemberDto.Response joinMember(MemberDto.Post postDto) {
        Member member = memberMapper.dtoToMember(postDto);
        memberRepository.save(member);
        return memberMapper.memberToResponse(member);
    }

    @Override
    public MemberDto.Response findMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return memberMapper.memberToResponse(member);
    }

    @Override
    public MemberDto.Response updateMember(Long memberId, MemberDto.Patch patch) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        member.update(patch);
        memberRepository.save(member);
        return memberMapper.memberToResponse(member);
    }

    @Override
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
