package ksmart.mybatis.common.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.mybatis.common.member.dto.Member;

@Mapper
public interface MemberMapper {

	// 회원목록 조회
	List<Member> getMemberList();
}
