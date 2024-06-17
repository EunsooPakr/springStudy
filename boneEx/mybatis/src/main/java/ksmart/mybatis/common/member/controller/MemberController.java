package ksmart.mybatis.common.member.controller;

import java.util.List;

import ksmart.mybatis.common.member.dto.MemberLevel;
import ksmart.mybatis.common.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ksmart.mybatis.common.member.dto.Member;
import ksmart.mybatis.common.member.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
	
	private final MemberService memberService;
	private final MemberMapper memberMapper;

	@PostMapping("/idCheck")
	@ResponseBody
	public boolean idCheck(@RequestParam(value = "memberId") String memberId) {
		log.info("아이디중복체크: memberId()", memberId);
		boolean isMember = false;
		isMember = memberMapper.idCheck(memberId);
		return isMember;

	}

	@GetMapping("/addMember")
	public String addMember(Model model) {
		List<MemberLevel> memberLevelList = memberService.getMemberLevelList();

		model.addAttribute("levelList", memberLevelList);
		model.addAttribute("title", "addMember");
		return "admin/member/addMember";
	}


	@GetMapping("/memberList")
	public String getMemberList(Model model) {
		List<Member> memberList = memberService.getMemberList();

		log.info("회원목록조회: {}", memberList);
		model.addAttribute("title", "회원목록조회");
		model.addAttribute("memberList", memberList);
		
		return "admin/member/memberList";
	}
}
