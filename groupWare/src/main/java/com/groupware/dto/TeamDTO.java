package com.groupware.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
public class TeamDTO {
	
	private Integer teamNo;
	private String teamName;
	
	
	public TeamDTO(Integer teamNo) {
		this.teamNo = teamNo;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", 부서번호 : ");
		builder.append(teamNo);
		builder.append(", 부서명 : ");
		builder.append(teamName);
		return builder.toString();
	}

}
