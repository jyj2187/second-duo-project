package kr.rhinitis.secondduoproject.member.mapper;

import kr.rhinitis.secondduoproject.member.dto.MemberDto;
import kr.rhinitis.secondduoproject.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member dtoToMember(MemberDto.Post postDto);
    MemberDto.Response memberToResponse(Member member);
    List<MemberDto.Response> memberListToResponseList(List<Member> memberList);
}
