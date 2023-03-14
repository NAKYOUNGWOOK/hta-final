/*
+--------+------------+----------+
| deptno | dname      | loc      |
+--------+------------+----------+
|     10 | ACCOUNTING | NEW YORK |
|     20 | RESEARCH   | DALLAS   |
|     30 | SALES      | CHICAGO  |
|     40 | OPERATIONS | BOSTON   |
+--------+------------+----------+
 */

package com.mycompany.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//@Entity //class명으로 자동으로 생성된 연관 table명: dept_copy table 의미
@Entity(name="deptcopy")
public class DeptCopy { //deptcopy table의미
	@Id
	private Integer deptno;
	
	private String dname;
	private String loc;
}
