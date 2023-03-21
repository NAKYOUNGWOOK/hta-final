package com.groupware.Domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "employee")
public class Employee {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empNo;  // 사원번호
	
	@Column(nullable = false)
	private Integer teamNo;  // 부서이름
	
	@Column(nullable = false, length = 50, unique = true)
	private String email;  // 이메일
	
	@Column(nullable = false, length = 50)
	private String empName;  // 사원이름
	
	@Column(nullable = false, length = 30)
	private String password;  // 비밀번호
	
	@Column(nullable = false)
	private Integer rankpNo;  // 직급번호
	
	@Column(nullable = false)
	private String imgurl;  // 프로필 사진
	
	@Column(nullable = false, length = 10)
	private String role;  // 권한
	
	
	public Employee(Integer empNo) {
		this.empNo = empNo;
	}
	
	
	@OneToMany(mappedBy = "teamNo")
	private List<Team> team;  // 직원(1):부서(N)
	
	@OneToMany(mappedBy = "rankpNo")
	private List<Rankp> rankp;  // 직원(1):직급(N)
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("사원번호 : ");
		builder.append(empNo);
		builder.append(", 사원이름 : ");
		builder.append(empName);
		builder.append(", 부서이름 : ");
		builder.append(teamNo);
		builder.append(", 이메일 : ");
		builder.append(email);
		builder.append(", 비밀번호 : ");
		builder.append(password);
		builder.append(", 직급 : ");
		builder.append(rankpNo);
		builder.append(", 권한 : ");
		builder.append(role);
		return builder.toString();
	}

}
