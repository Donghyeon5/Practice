package org.galapagos.controller;

import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;
import org.galapagos.domain.PageDTO;
import org.galapagos.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;

	@GetMapping("/list")
	public void list(@ModelAttribute("cri") Criteria cri, Model model) {
	
		log.info("list" + cri);
		int total = service.getTotal(cri);

//		model.addAttribute("list", service.getList());
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));	// 임의로 123  요청

	}
	
	@GetMapping("/register")
	public void register() {	
		log.info("register");	
	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {

		log.info("register: " + board);

		service.register(board);

		rttr.addFlashAttribute("result", board.getBno());

		return "redirect:/board/list";
	}
	
	@GetMapping({ "/get", "/modify" })
	public void get(
			@RequestParam("bno") Long bno,
			@ModelAttribute("cri") Criteria cri,
			Model model) {

		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(
			BoardVO board, 
			@ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		log.info("modify:" + board);
	
		
		if (service.modify(board)) {
			// Flash --> 1회성
			rttr.addFlashAttribute("result", "success");
			rttr.addAttribute("bno", board.getBno());
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
		}
		return "redirect:/board/get";
	}

	
	@PostMapping("/remove")
	public String remove(
			@RequestParam("bno") Long bno, 
			@ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
	
		log.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());

		}
		return "redirect:/board/list";
	}

}

	
	
	


