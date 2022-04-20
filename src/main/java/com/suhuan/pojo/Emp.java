package com.suhuan.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {
	    private Integer empno;
	    private String ename;
	    private String job;
	    private Integer mgr;
	    private Date hiredate;
	    private Double sal;
	    private Double comm;
	    private Integer deptno;
		@Override
		public String toString() {
			return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate="
					+ hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
		}
		
	    
	}
