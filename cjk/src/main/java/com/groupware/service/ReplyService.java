package com.groupware.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.repository.ReplyDAO;
import com.groupware.vo.Reply;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	public ArrayList<Reply> getReplyNo(int boardNo) {
		ArrayList<Reply> list = replyDAO.getReplyNo(boardNo);
		return list;
	}
	
	public boolean writeReply(Reply reply) {
		return replyDAO.writeReply(reply);
	}

}