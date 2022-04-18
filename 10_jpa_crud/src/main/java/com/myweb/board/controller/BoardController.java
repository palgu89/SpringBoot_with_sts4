package com.myweb.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.board.dto.BoardDTO;
import com.myweb.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")	// boot는 /board/* 안해줘도 됨 -> boot 기능은 아니고 spring 버전업으로 인해 생긴 기능
@Controller
public class BoardController {
	private final BoardService bsv;
	
	@GetMapping("/register")
	public void register() {
		log.info(">>> /board/register - GET");
	}
	
	@PostMapping("/register")
	public String register(BoardDTO bdto, RedirectAttributes reAttr) {
		Long bno = bsv.register(bdto);
		reAttr.addFlashAttribute("register", bno);
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", bsv.getList());
	}
	
	@GetMapping("/detail")
	public void detail(Long bno, Model model) {	// spring에서 bno를 RequestParam으로 안 받아줘도 됨
		model.addAttribute("bdto", bsv.getDetail(bno));
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes reAttr) {
		bsv.remove(bno);
		reAttr.addFlashAttribute("remove", bno);	// bno 던지면 'bno'번 게시물 삭제 띄우기 위해
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO bdto, RedirectAttributes reAttr) {
		Long bno = bsv.modify(bdto);
		reAttr.addFlashAttribute("modify", bno);
		return "redirect:/board/detail?bno=" + bno;
	}
}
