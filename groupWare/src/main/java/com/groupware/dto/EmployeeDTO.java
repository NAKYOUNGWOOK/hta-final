package com.groupware.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class EmployeeDTO {

//	private Integer empNo;  // 사원번호
	private Integer teamNo; // 부서번호
	private String email;  // 이메일
	private String empName;  // 사원이름
	private String password;  // 비밀번호
	private Integer rankpNo;  // 직급번호
	private String imgurl;  // 프로필 사진
	private String role;  // 권한
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
//		builder.append("사원번호 : ");
//		builder.append(empNo);
		builder.append(", 부서이름 : ");
		builder.append(teamNo);
		builder.append(", 이메일 : ");
		builder.append(email);
		builder.append(", 사원이름 : ");
		builder.append(empName);
		builder.append(", 비밀번호 : ");
		builder.append(password);
		builder.append(", 직급 : ");
		builder.append(rankpNo);
		builder.append(", 프로필 사진 : ");
		builder.append(imgurl);
		builder.append(", 권한 : ");
		builder.append(role);
		return builder.toString();
	}
}
