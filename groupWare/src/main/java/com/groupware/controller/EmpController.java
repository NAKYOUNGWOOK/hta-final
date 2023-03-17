package com.groupware.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.service.EmpService;


@Controller
@RequestMapping("company")
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	//회원가입
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	String signUp(@RequestParam Map<String, Object> param) {
		return null;
		
	}

}
