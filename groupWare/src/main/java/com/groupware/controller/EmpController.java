package com.groupware.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.service.EmpService;


@Controller  // 동기 방식 즉 jsp등으로 이동 의미
@RequestMapping("company")
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinEmp(@RequestParam Map<String, Object> param) {
		return null;
		
	}

}
