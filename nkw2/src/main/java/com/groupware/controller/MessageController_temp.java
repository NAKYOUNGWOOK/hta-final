package com.groupware.controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.repository.EmployeeRepository;
import com.groupware.service.MessageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MessageController {

	private final MessageService messagService;
	private final EmployeeRepository employeeRepository;
	
	//메시지 작성
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/messages")
	public Response sendMessage() {
		return Response.success(MessageService.sendMessage(req));
	}
	
	
	//받은 메시지 확인
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/messages/received")
	public Response getReceivedMessage() {
		
	}
	
//	@GetMapping(value =  "/allview", produces = "application/json; charset=UTF-8")
//	public ModelAndView allview() throws SQLException {
//		
//		ModelAndView mv = new ModelAndView();
//		
//		mv.addObject("list", messageService.getMessage());
//		mv.setViewName("../message/list");
//		
//		return mv;
//	}
	
	
	//받은 메시지 삭제
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/messages/received/{id}")
	public Response {
		
	}
	
	
	//보낸 메시지 확인
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/messages/sent")
	public Response {
		
	}
	
	
	//보낸 메시지 삭제
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/messages/sent/{id}")
	public Response {
		
	}
}
