package ksmart.springboot2.exam.controller;

import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import jakarta.annotation.PostConstruct;
import ksmart.springboot2.exam.dto.Member;
import ksmart.springboot2.exam.service.ExamService;

/**
 * @Controller : 주소의 요청과 응답을 담당하는 클래스 (HTTP 통신)
 * 				VIEW의 경로가 정해져 있다. (String : 뷰의 논리적인 경로)
 *
 * 클래스위에 @Component 작성하게 되면 spring framework가 관리하는 객체로 생성 (spring bean)
 * @Component 계열 : @Controller, @service, @Repository(DAO), @Mapper(DAO), @Configuration(스프링 설정)
 * 				  : 일반적인 클래스를 spring bean 등록하고 싶을 때는 @Component
 */





@Controller
public class ExamController {

    //	DI(Dependency Injection : 의존성 주입)
    // 의존성주입 : 클래스 간의 관계를 형성, 스프링이 관리하는 객체를
    // 하나의 객체가 다른 객체의 의존성을 제공하는 테크닉
    // "의존성"은 예를 들어 서비스로 사용할 수 있는 객체

    // 1. 필드 주입방식  >> 위험해서 잘 안
    /*
     * @Autowired
     * private ExamService examService;
     */

    // 2. 수정자 메소드 주입방식 >> 잘 안 씀

    //private ExamService examService;
    //@Autowired
    //public void setExamService(ExamService examService) {
    //	this.examService = examService;
    //}

    // 3. 생성자 메소드 주입방식 >> 잘 씀
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    // @PostConstruct: spring 에서 객체를 생성한 후에 이벤트를 실행하는 어노테이션
    @PostConstruct
    public void initExamController() {
        System.out.println("ExamController 객체생성");
    }

    @GetMapping("/exam/exam7")
    public String exam7(Model model) {
        model.addAttribute("title", "예제7");
        return "exam/exam7";
    }


    /**
     * @ResponseBody : 반환하는 데이터 유형에 따라 text/html, application/json 변환후 응당해주는 어노테이션
     * @return
     */
    @GetMapping("/exam/api")
    @ResponseBody
    public List<Member> api(Member member) {
        System.out.println("Member : " + member);
//        return new Member("id001", "pw001", "홍01", "관리자", "010-1111-1111");
        return examService.getMemberList();
    }
    
    /**
     * @RequestParam(name="요청시의 키", value=name의 별칭 ,required=요청시의 쿼리스트링 필수여부, defaultValue="기본값") 쿼리스트링 바인딩하는 어노테이션
     * @param Member member -> 커멘드객체(controller 계층)
     * ex:) memberId=id001&memberPw=pw001&memberName=홍01 키와 dto 속성명과 일치시 값을 알아서 바인딩
     * @return
     */
    @GetMapping("/exam/detail")
    public String examDetail(@RequestParam(name = "memberId") String memberId
                            ,@RequestParam(value = "memberPw", required = false) String memberPw
                            ,@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum
                            ,Member member
                            ,Model model){
    System.out.println(memberId);
    System.out.println(memberPw);
    System.out.println(pageNum);
    System.out.println(member);
    Member memberInfo = examService.getMemberInfoById(memberId);
    model.addAttribute("memberInfo", memberInfo);
    model.addAttribute("title", "회원상세조회");


        return "exam/detail";
    }
    
    @GetMapping("/exam/exam6")
    public String exam6(Model model){
        List<Member> memberList = examService.getMemberList();
        Member memberInfo = examService.getMemberInfoById("id005");
        model.addAttribute("memberInfo", memberInfo);
        model.addAttribute("memberList", memberList);
        model.addAttribute("price", 123456789);
        model.addAttribute("now", new Date());

        return "exam/exam6";

    }

    @GetMapping("/exam/exam5")
    public String exam5(Model model){
        List<Member> memberList = examService.getMemberList();

        model.addAttribute("memberList", memberList);
        model.addAttribute("price", 123456789);
        model.addAttribute("now", new Date());

        return "exam/exam5";

    }

    @GetMapping("/exam/exam4")
    public String exam4(Model model) {
        List<Member> memberList = examService.getMemberList();
        Member memberInfo = examService.getMemberInfoById("id005");
        System.out.println(memberInfo);
        model.addAttribute("memberInfo", memberInfo);
        model.addAttribute("memberList", memberList);
        return "exam/exam4";

    }

    @GetMapping("/exam/exam3")
    public String exam3(Model model) {
        Member memberInfo = examService.getMemberInfo();
        List<Member> memberList = examService.getMemberList();
        model.addAttribute("title", "예제3");
        model.addAttribute("memberInfo", memberInfo);
        model.addAttribute("memberList", memberList);
        return "exam/exam3";

    }

    @RequestMapping(value="/exam/exam2", method=RequestMethod.GET)
    public ModelAndView exam2() {
        //ExamService es = new ExamService();
        //es.getMemberList();
        List<Member> memberList = examService.getMemberList();

        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "예제2");
        mav.addObject("memberList", memberList);
        mav.setViewName("exam/exam2");
        return mav;

    }


    @GetMapping("/exam/exam1")
    public String exam1(Model model) {

        Member memberInfo = new Member("id001", "pw001", "홍01", "관리자", "010-1111-1111");
        // Model : 화면에 전달할 데이터를 가지고 있는 객체
        // model.addAttribute("키", "값");
        model.addAttribute("memberInfo", memberInfo);
        model.addAttribute("title","예제1");



        return "exam/exam1";
    }
}
