package com.groupware.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
//@ToString

@Entity
@Table(name = "team")
public class Team {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
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
		builder.append(super.toString());
		builder.append(", 부서번호 : ");
		builder.append(teamNo);
		builder.append(", 부서명 : ");
		builder.append(teamName);
		return builder.toString();
	}

}
