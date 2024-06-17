package ksmart.mybatis.common.member.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data //@Setter + @Getter + @ToString
public class Member {

	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberLevel;
	private String memberLevelName;
	private String memberEmail;
	private String memberAddr;
	private String memberRegDate;
	
}
