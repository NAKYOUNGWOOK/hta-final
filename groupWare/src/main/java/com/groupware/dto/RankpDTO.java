package com.groupware.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
public class RankpDTO {
	
	private Integer rankpNo;
	private String rankpName;
	
	
	public RankpDTO(Integer rankpNo) {
		this.rankpNo = rankpNo;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", 직급번호 : ");
		builder.append(rankpNo);
		builder.append(", 직급명 : ");
		builder.append(rankpName);
		return builder.toString();
	}

}
