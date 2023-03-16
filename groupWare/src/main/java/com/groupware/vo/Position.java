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
@Table(name = "position")
public class Position {
	
	@Id
	@Column(nullable = false)
	private Integer positionNo;
	
	@Column(nullable = false)
	private String positionName;
	
	
	public Position(Integer positionNo) {
		this.positionNo = positionNo;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("직급번호 : ");
		builder.append(positionNo);
		builder.append(", 직급명 : ");
		builder.append(positionName);
		return builder.toString();
	}

}
