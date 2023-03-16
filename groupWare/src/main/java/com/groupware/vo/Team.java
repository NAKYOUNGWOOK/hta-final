package com.groupware.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString

@Entity
@Table(name = "team")
public class Team {
	
	@Id
	@Column(nullable = false)
	private Integer teamNo;
	
	@Column(nullable = false)
	private String teamName;
	
	
	public Team(Integer teamNo) {
		this.teamNo = teamNo;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("부서번호 : ");
		builder.append(teamNo);
		builder.append(", 부서명 : ");
		builder.append(teamName);
		return builder.toString();
	}

}
