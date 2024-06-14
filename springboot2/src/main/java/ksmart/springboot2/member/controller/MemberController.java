package ksmart.springboot2.member.controller;

import ksmart.springboot2.exam.dto.Member;
import ksmart.springboot2.exam.service.ExamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @RestController = @Controller + @RestPonseBody
 */

@RestController
public class MemberController {

    private final ExamService examService;

    public MemberController(ExamService examService) {
        this.examService = examService;
    }

    /**
     * @RequestBody 요청한 json 객체를 서버에서 바인딩 받을 때 사용하는 어노테이션
     * json 으로 전달되는 데이터 타입에 맞게 자바타입을 선언해야 한다.
     * DTO로 선언하고 데이터바인딩 받는게 유리하다.
     * @param paramMap
     * @return
     */
    @GetMapping("/member/searchId")
    public Member getMemberInfo(@RequestBody Map<String, String> paramMap){
        /*
        Set<String> keyset = paramMap.keySet();
        keyset.forEach(key -> {
            System.out.println(key + ":" + paramMap.get(key));
        });*/
        String memberId = paramMap.get("memberId");
        System.out.println("memberId = " + memberId);
        return examService.getMemberInfoById(memberId);
    }

    @GetMapping("/member/list")
    public List<Member> getMemberList() {
        return examService.getMemberList();
    }

    /**
     * @PathVariable : 주소 맵핑 시 (바인딩 받을 키)
     * 핸들러 메소드 매개변수의 @PathVariable(name="바인딩 받을 키") 데이터타입 변수명
     * @param memberId
     * @return
     */
    @GetMapping("/member/{memberId}") // 어떤게 들어올지 모를땐 {} 만 쓴다.
    public Member getMemberInfoById(@PathVariable(name = "memberId") String memberId) {
        return examService.getMemberInfoById(memberId);
    }

}
