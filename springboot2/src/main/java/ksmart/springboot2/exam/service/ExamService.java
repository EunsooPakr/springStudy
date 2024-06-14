package ksmart.springboot2.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ksmart.springboot2.exam.dto.Member;

/**
 * @Service : 비즈니스 로직 수행, 기능구현, data 가공
 * 				(트랜잭션 : 논리적인 작업을 수행하는 한 단위)
 */

@Service
public class ExamService {

    public ExamService() {
        System.out.println("객체 생성 ");
    }

    /**
     * 회원정보조회
     * @return Member
     */
    public Member getMemberInfo(){
        return new Member("id002", "pw002", "홍02", "판매자", "010-2222-2222");
    }

    public Member getMemberInfoById(String member){
        String memberNum = member.substring(member.length()-1);
        System.out.println(memberNum);
        String[] levelList = new String[] {"관리자", "판매자", "구매자"};
        Member m = new Member();
        m.setMemberId(member);
        m.setMemberPw("pw00"+memberNum);
        m.setMemberLevel(levelList[(Integer.parseInt(memberNum)-1)% levelList.length]);
        m.setMemberName("홍0"+memberNum);
        m.setMemberMobile("010-"+memberNum+memberNum+memberNum+memberNum+"-"+memberNum+memberNum+memberNum+memberNum);
        return m;
    }
    public List<Member> getMemberList(){
        // Member id001~id009 arrayList 만들어보시오.
        ArrayList<Member> al = new ArrayList<>();
        String[] levelList = new String[] {"관리자", "판매자", "구매자"};
        for(int i=1; i<10; i++) {
            String memberId = "id00"+i;
            String memberPw = "pw00"+i;
            String memberName = "홍0"+i;
            String memberLevel = levelList[(i-1)% levelList.length];
            String memberMobile = "010-"+i+i+i+i+"-"+i+i+i+i;
            Member m1 = new Member(memberId, memberPw, memberName, memberLevel,memberMobile);
            al.add(m1);
        }

        System.out.println(al);
        return al;
    }




//	public void payOrder(String memberId, Goods goods, Order order, Paymenet pay) {
//		// 1. 주문 내역확인 상품 재고 확인
//
//		// 2. 주문 내역 결제 금액 충분
//
//		// 3. 상품 재고 업데이트
//
//		// 4. 주문 주문이력 추가..
//	}
}
