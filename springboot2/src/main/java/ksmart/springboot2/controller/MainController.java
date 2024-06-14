package ksmart.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Controller : 클라이언트의 요청과 응답을 담당하는 클래스.
 * 주의 할 점 : class 바로 위에 있어야 한다.
 */
@Controller
public class MainController {

    /**
     * @GetMapping : HTTP GET방식 주소요청시 특정 핸들러메소드.
     * @return String : 화면의 논리 경로
     */
    @GetMapping("/")			// 어노테이션 괄호안에는 옵션을 쓴다.   /  컨트롤러에서는 무조건 String으로 반환
    public String mainPage() {



        return "index";
    }


}
