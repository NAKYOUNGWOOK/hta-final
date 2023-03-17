package com.groupware.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class MessageDTO {
	
	private int no; //메시지 번호
	private int room; //방 번호
	private String sender; //보낸사람
	private String receiver; //받은사람
	private String content; //내용
	private String sendtime; //작성일
	private String receivetime; //수신일
	private int readcheck; //확인여부 (미확인시 1, 확인시 0)
	
	private String other; //메세지 상대
	private String profile; //메세지 상대 profile
	private String nick; //현재 사용자
	private int unread; //읽지 않은 메세지 갯수

}
