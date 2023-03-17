package com.groupware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
public class ApBoardController {
	
	@GetMapping("/")
	public String list() {
		return "webapp/list.jsp";
	}
	
	@GetMapping("/post")
	public String post() {
		return "webapp/post.jsp";
	}
}
