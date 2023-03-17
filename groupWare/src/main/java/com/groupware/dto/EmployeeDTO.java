package com.groupware.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class EmployeeDTO {

	private Integer empNo;  // 사원번호
	private String empName;  // 사원이름
	private String team;  // 부서이름
	private String email;  // 이메일
	private String password;  // 비밀번호
	private String position;  // 직급
	private String imgurl;  // 프로필 사진
	private String role;  // 권한
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("사원번호 : ");
		builder.append(empNo);
		builder.append(", 사원이름 : ");
		builder.append(empName);
		builder.append(", 부서이름 : ");
		builder.append(team);
		builder.append(", 이메일 : ");
		builder.append(email);
		builder.append(", 비밀번호 : ");
		builder.append(password);
		builder.append(", 직급 : ");
		builder.append(password);
		builder.append(", 권한 : ");
		builder.append(role);
		return builder.toString();
	}
}
