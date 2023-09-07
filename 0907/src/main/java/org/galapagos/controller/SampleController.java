package org.galapagos.controller;

import java.util.ArrayList;
import java.util.Date;

import org.galapagos.domain.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller // bean 등록
@RequestMapping("/sample/") // sample로 시작하는 요청은 이 controller가 담당
@Log4j
public class SampleController {
	// /sample/ -> basic 메서드 자동 호출
	@RequestMapping("")
	public void basic() {
	log.info("basic............");
	}
	
	// /sample/basic -> basicGet 메서드 적용
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get.........");
		//view의 이름 "sample/basic.jsp"
	}
	
	// /sample/basicOnlyGet -> basicGet2 메서드 적용
	@GetMapping(value="/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get.........");
		//view의 이름 "sample/basicOnlyGet.jsp"
	}
	
	@GetMapping("/ex01")
		public String ex01(SampleDTO dto) { //request scope에 자동 저장
			log.info("" + dto);
			
			return "ex01";
	}
	
	
	@GetMapping("/ex02") // DTO를 따로 세팅하지않고 바로 설정하는 방법, DTO와 혼용해서 사용가능, 
						//scope에 저장되지않고 el의 내장객체 param으로 접근가능
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: " + name);
		log.info("age: " + age);
		return "ex02";
	}
	
	@GetMapping("/ex02List") //String 타입의 ids를 리스트로 처리 
							//sample/ex02List/?ids=111&ids=222
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
		
		return "ex02Lists";
	}
	
	@GetMapping("/ex04")
		public String ex04(
				Model model, //추가 정보 model에 담음
				@ModelAttribute("sample")SampleDTO dto,
				@ModelAttribute("page") int page){
			log.info("dto : " + dto);
			log.info("page : " + page);
			model.addAttribute("now", new Date());
			
			return "ex04";
	}
}
