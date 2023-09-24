package org.galapagos.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.galapagos.domain.SampleDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller // bean 등록
@RequestMapping("/sample") // sample로 시작하는 요청은 이 controller가 담당
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
	
	@GetMapping("/ex06")
		public @ResponseBody SampleDTO ex06() {
			log.info("/ex06.........");
			
			SampleDTO dto = new SampleDTO();
			dto.setAge(10);
			dto.setName("홍길동");
			
			return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() { 
		// 브라우저로 직접 응답하는 경우, body에 담을 객체 타입 <String>
		log.info("/ex07..........");
		// {"name": "홍길동"}
		String msg = "{\"name\": \"홍길동\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}							// body , header, 상태코드
	
	@GetMapping("/exUpload")
		public void exUpload() {
		// void -> jsp로 바로 넘어가라 views/sample/exUpload.jsp
		log.info("/exUpload............");
	}
	
	@PostMapping("/exUploadPost") // 업로드 정보 -> MultipartFile
		public void exUploadPost(ArrayList<MultipartFile>files) {
		
			// files.forEach(file -> { // MulitpartFile file
		
			for(MultipartFile file : files) {
				if(file.isEmpty()) continue;
				
				log.info("-------------------------------");
				log.info("name : " + file.getOriginalFilename());
				log.info("size : " + file.getSize());
				
				
				
				// 저장
				File dest = new File("c:/upload", file.getOriginalFilename());
				try {
					file.transferTo(dest); // 저장 담당
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		};
	}
	
	@GetMapping("/ex10")
		public void ex10() {
			throw new RuntimeException("예외 실험");
	}
}
