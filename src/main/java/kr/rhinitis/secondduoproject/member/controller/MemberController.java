package kr.rhinitis.secondduoproject.member.controller;

import kr.rhinitis.secondduoproject.member.dto.MemberDto;
import kr.rhinitis.secondduoproject.member.entity.Member;
import kr.rhinitis.secondduoproject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.NoPermissionException;
import java.io.IOException;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String addForm(){
        return "member/addPost";
    }

    @PostMapping("/signup")
    public String signIn(@ModelAttribute("member") MemberDto.Post postDto){
        memberService.joinMember(postDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/member/edit/{member-id}")
    public String editMemberForm(@PathVariable("member-id") Long memberId,
                                 Model model) {
        MemberDto.Response member = memberService.findMember(memberId);
        model.addAttribute("member", member);
        return "member/editMember";
    }

    @PostMapping("/member/edit/{member-id}")
    public String editMember(@PathVariable("member-id") Long memberId,
                             MemberDto.Patch updateDto){
        memberService.updateMember(memberId, updateDto);
        return "redirect:/member/" + memberId;
    }

    @PostMapping("/member/{member-id}")
    public String deleteMember(@PathVariable("member-id") Long memberId) {
        memberService.deleteMember(memberId);
        return "redirect:/posts";
    }
}
