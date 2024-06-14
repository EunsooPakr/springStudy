package ks51team03.user.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller("userCommonController")
public class CommonController {
	
	@GetMapping("/")
	public String userMainPage(Model model) {
		return "user/main";
	}
}
