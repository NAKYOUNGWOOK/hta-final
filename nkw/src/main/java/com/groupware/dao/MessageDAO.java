package com.groupware.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.MessageDTO;

@Repository
public class MessageDAO {

	@Autowired
	private SqlSession sqlSession;
	
	//메세지 리스트
	public ArrayList<MessageDTO> messageList(MessageDTO to) {
	
		String nick = to.getNick();
		
		//메세지 리스트에 나타낼 것들 가져오기(최근 메세지, 보낸사람 프로필, *nick*)
		ArrayList<MessageDTO> list = (ArrayList)sqlSession.selectList("mesage_list", to);
		
		for (MessageDTO mto : list) {
			mto.setNick(nick);
			//현재 사용자가 해당 room에서 읽지 않는 메세지의 갯수
			int unread = sqlSession.selectOne("count_unread", mto);
			//메세지 상대 profile
			String profile = sqlSession.selectOne("get_other_profile", mto);
			
			mto.setUnread(unread);
			mot.setProfile(profile);
			
			//메세지 상대 nick 세팅
			if(nick.equals(mto.getSender())) {
				mto.setOther(mto.getReceiver());
			}else {
				mto.setOther(mto.getSender());
			}
		}
		return list;
	}
	

	//room 별 메세지 내용을 가져온다.
	public ArrayList<MessageDTO> roomContentList(MessageDTO to) {
		
			System.out.println("room: " + to.getRoom());
			System.out.println("receiver: " + to.getReceiver());
			System.out.println("nick: " + to.getNick());
			
			//메세지 내역을 가져온다.
			ArrayList<MessageDTO> clist = (ArrayList)sqlSession.selectList("room_content_list", to);
			
			//해당 방의 메세지들 중 받는 사람이 현재 사용자의 nick인 메세지를 모두 읽음 처리
			sqlSession.update("message_readcheck", to);
			
			return clist;
	}
	
	
	//메세지 list에서 메세지를 보낸다.
	public int messageSendInlist(MessageDTO to) {
		
		//메세지 리스트에서 보낸건지 프로필에서 보낸건지 구분
		if(to.getRoom() == 0) { //room이 0인 경우 프로필에서 보낸 것
			int exist_chat = sqlSession.selectOne("exist_chat", to);
			
			//프로필에서 보낸 것 중 메세지 내역이 없어 첫 메제시가 될 경우
			if(exist_chat == 0) { //메세지 내역이 0일 경우 room의 최댓값을 구해 to에 set
				int max_room = sqlSession.selectOne("max_room", to);
				to.setRoom(max_room + 1);
			}else { //메세지 내역이 있다면 해당 room 번호 호출
				int room = Integer.parseInt(sqlSession.selectOne("select_room", to));
				to.setRoom(room);
			}
		}
		int flag = sqlSession.insert("messageSendInlist", to);
		return flag;
	}
}


