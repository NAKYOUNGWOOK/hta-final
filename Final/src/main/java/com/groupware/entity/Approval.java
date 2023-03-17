package com.groupware.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter   
@Setter  
@Builder

@Entity
public class Approval {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int apno; // 게시물 번호

	@NonNull
	@Column
	private String title; //게시물 제목

	@NonNull
	@Column
	private String contents; //게시물 내용

	@NonNull
	@Column
	private int employeeNo; //사번
	
	@NonNull
	@Column
	private String apdate; //작성날짜
	
	@NonNull
	@Column
	private int director; //결재자 부장(5)
	
	@NonNull
	@Column
	private int Gmanager; //결재자 차장(4)
	
	@NonNull
	@Column
	private int Dmanager; //과장(3)
	
	@NonNull
	@Column
	private int assistant; //대리(2)
	
	@NonNull
	@Column
	private int employee; //사원(1)
	
	@NonNull
	@Column
	private int verify; //권한(0),(0이 아니라면 관리자)

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("게시물 번호 : ");
		builder.append(apno);
		builder.append("게시물 제목 : ");
		builder.append(title);
		builder.append("사번 : ");
		builder.append(employeeNo);
		builder.append("작성날짜 : ");
		builder.append(apdate);
		builder.append("권한 : ");
		builder.append(verify);
		return builder.toString();
	}

}
