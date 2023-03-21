package com.groupware.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Rankp")
public class Rankp {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rankpNo;
	
	@Column(nullable = false)
	private String rankpName;
	
	
	public Rankp(Integer rankpNo) {
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
