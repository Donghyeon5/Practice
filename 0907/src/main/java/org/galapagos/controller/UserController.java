package org.galapagos.controller;

import org.galapagos.domain.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user")
@Log4j
public class UserController {
	
	@GetMapping("/join")
	public String joinGet() {
		return "user/join"; // view 이름
	}
	
	@PostMapping("/join")
	public String joinPost(UserDTO user) {
		// DB에 INSERT 작업을 함
		log.info(user);
		// post 처리 후 INSERT, UPDATE, DELETE -> redirect
		return "redirect:/user/join_result"; // 리다이렉트 이동할 url
	}
	
	@GetMapping("/join_result") // url 주소
	public String joinResult(UserDTO user) { // 메서드 (아무이름)
		// 리다이렉트시 scope가 남아있지 않아서 정보 x
		return "user/join_result"; // view 이름
	}
	
}
