package com.groupware.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.dao.MessageDAO;
import com.groupware.dto.MessageDTO;

public class MessageController {

	@Autowired
	private MessageDAO messageDao;
	
	//메세지 목록
	@RequestMapping(value = "/message_list.do")
	public String message_list(HttpServletRequest request, HttpSession session) {
		
		String nick = (String)session.getAttribute("nick");
		
		MessageDTO to = new MessageDTO();
		to.setNick(nick);
		
		//메세지 리스트
		ArrayList<MessageDTO> list = messageDao.messageList(to);
		
		request.setAttribute("list", list);
		
		return "message/message_list";
	}
	
	
	//메세지 목록
	@RequestMapping(value = "/message_ajax_list_do")
	public String message_ajax_list(HttpServletRequest request, HttpSession session) {
		
		String nick = (String)session.getAttribute("nick");
		
		MessageDTO to = new MessageDTO();
		to.setNick(nick);
		
		//메세지 리스트
		ArrayList<MessageDTO> list = messageDao.messageList(to);
		
		request.setAttribute("list", list);
		
		return "message/message_ajax_list";
	}
	
	
	//메세지 리스트에서 메세지 보내기
	@ResponseBody
	@RequestMapping(value = "/message_send_inlist.do")
	public int message_send_inlist(@RequestParma int room, @RequestParam String other,
									@RequestParam String content, HttpSession session) {
		
		MessageDTO to = new MessageDTO();
		to.setRoom(room);
		to.setSender((String)session.getAttribute("nick"));
		to.setReceiver((other));
		to.setContent(content);
		
		int flag = messageDao.messageSendInlist(to);
		
		return flag;
	}
	
	
}
