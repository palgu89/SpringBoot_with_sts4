package com.myweb.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myweb.board.dto.BoardDTO;
import com.myweb.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService bsv;
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(BoardDTO bdto) throws Exception {
		bsv.register(bdto);
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void list(Model model) throws Exception {
		model.addAttribute("list", bsv.getList());
	}
	
	@GetMapping("/detail")
	public void detail(@RequestParam("pno") Long pno, Model model) throws Exception {	// @RequestParam으로 받아도 되고, 그냥 Long pno 해도 됨
		model.addAttribute("bdto", bsv.getDetail(pno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO bdto) throws Exception {
		bsv.modify(bdto);
		return "redirect:/board/detail?pno=" + bdto.getPno();
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("pno") Long pno) throws Exception {
		bsv.remove(pno);
		return "redirect:/board/list";
	}
}
