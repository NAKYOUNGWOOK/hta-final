package com.groupware.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class MessageVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no; //메시지 번호
	
	@NonNull
	@Column(nullable = false)
	private int room; //방 번호

	@NonNull
	@Column(nullable = false)
	private int sender; //보낸사람
	
	@NonNull
	@Column(nullable = false)
	private int receiver; //받은사람

	@NonNull
	@Column(nullable = false)
	private String content; //내용

	@NonNull
	@Column(nullable = false)
	private String writeDate; //작성일
	
	@NonNull
	@Column(nullable = false)
	private int readcheck; //확인여부 (미확인시 1, 확인시 0)
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Massage [no=");
		builder.append(no);
		builder.append(", room=");
		builder.append(room);
		builder.append(", sender=");
		builder.append(sender);
		builder.append(", receiver=");
		builder.append(receiver);
		builder.append(", content=");
		builder.append(content);
		builder.append(", writeDate=");
		builder.append(writeDate);
		builder.append(", readcheck=");
		builder.append(readcheck);
	   	builder.append("]");
		return builder.toString();
   }
}
