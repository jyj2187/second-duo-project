package kr.rhinitis.secondduoproject.member.repository;

import kr.rhinitis.secondduoproject.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
