package ksmart.mybatis.common.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	private final MemberMapper memberMapper;

	@GetMapping("/memberList")
	public String getMemberList() {
		List<Member> memberList = memberMapper.getMemberList();
		
		log.info("회원목록조회 : {}", memberList);
		
		return "admin/member/memberList";
	}
}
