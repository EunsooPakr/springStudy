package ksmart.mybatis.common.member.service;

import ksmart.mybatis.common.member.dto.Member;
import ksmart.mybatis.common.member.dto.MemberLevel;

import java.util.List;

public interface MemberService {

    // 회원등급 조회
    List<MemberLevel> getMemberLevelList();

    // 회원목록 조회
    List<Member> getMemberList();
}
