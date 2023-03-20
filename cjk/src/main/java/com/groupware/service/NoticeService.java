package com.groupware.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.repository.NoticeDAO;
import com.groupware.vo.Notice;
@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public boolean writeNotice(Notice notice) {
		
		return noticeDAO.writeNotice(notice);
	}
	
	public ArrayList<Notice> getAllNotices() {
		ArrayList<Notice> list = noticeDAO.getAllNotices();
		return list;
	}
	
	public Notice getNoticeNo(int no) {
		return noticeDAO.getNoticeNo(no);
	}
	
	public boolean updateNotice(Notice notice) {
		return noticeDAO.updateNotice(notice);
	}
	
	public boolean deleteNotice(int boardno) {
		return noticeDAO.deleteNotice(boardno);
	}
}