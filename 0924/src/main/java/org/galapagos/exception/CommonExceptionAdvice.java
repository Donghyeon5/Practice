package org.galapagos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice //bean 등록
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class) // 처리할 예외
	public String except(Exception ex, Model model) {
						// 실제 예외
	log.error("Exception ......." + ex.getMessage());
	model.addAttribute("exception", ex);
	log.error(model);
	
	return "error_page"; // view의 이름
	}
	
	// 핸들러 없을때
	@ExceptionHandler(NoHandlerFoundException.class)
	// 응답이 404 응답이면
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
	
	// custom404 view로 이동
	return "custom404";
	}

}
