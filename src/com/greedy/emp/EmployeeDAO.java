package com.greedy.emp;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.greedy.emp.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO{
	/*구현 조건
	 * 1. Connection 생성은 JDBC 템플릿 사용
	 * 2. query문은 xml 파일로 분리
	 * 3. 쿼리문에 값을 전달해야 하는 겅우는 preparedStatement, 아닌 경우는 Statement 사용
	 * 4. 한 행 정보는 DTO에 담아 출력, 여러 행 정보는 ArrayList에 담아 출력하기*/

	public void findOneEmpByEmpId(String inputEmpId){
		 Connection con = getConnection();
	      
	    
	      Statement stmt = null;
	      
	     
	      ResultSet rset = null;
	      
	      try {
	        
	         stmt = con.createStatement();
	         
	         
	         Scanner sc = new Scanner(System.in);
	         System.out.print("찾으실 사원번호를 입력하세요 : ");
	         String empId = sc.nextLine();
	         
	         String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";
	         rset = stmt.executeQuery(query);
	       
	         if(rset.next()) {
	            System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	        
	         close(con);
	         close(stmt);
	         close(rset);
	      } 
	      }
   public void findOneEmpByAll() {Connection con = getConnection();
	
	Statement stmt = null;
	ResultSet rset = null;
	
	List<EmployeeDTO> empList = null;
	
	String query = "SELECT * FROM EMPLOYEE";
	
	try {
		stmt = con.createStatement();
		rset = stmt.executeQuery(query);
		
		empList = new ArrayList<>();
		
		while(rset.next()) {
			
			EmployeeDTO row = new EmployeeDTO();
			
			row.setEmpId(rset.getString("EMP_ID"));
			row.setEmpName(rset.getString("EMP_NAME"));	
			row.setEmpNo(rset.getString("EMP_NO"));
			row.setEmail(rset.getString("EMAIL"));
			row.setPhone(rset.getString("PHONE"));
			row.setDeptCode(rset.getString("DEPT_CODE"));
			row.setJobCode(rset.getString("JOB_CODE"));
			row.setSalLevel(rset.getString("SAL_LEVEL"));
			row.setSalary(rset.getInt("SALARY"));
			row.setBonus(rset.getDouble("BONUS"));
			row.setManagerId(rset.getString("MANAGER_ID"));
			row.setHireDate(rset.getDate("HIRE_DATE"));
			row.setEntDate(rset.getDate("ENT_DATE"));
			row.setEntYn(rset.getString("ENT_YN"));
			
			empList.add(row);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(con);
		close(rset);
		close(stmt);
	}
	for(EmployeeDTO emp : empList)
	System.out.println(emp);
	   
   }


 public void findgender(String inputGender) {
	 
	 Connection con = getConnection();
 
     Statement stmt = null;
  
     ResultSet rset = null; 
     try { 
        stmt = con.createStatement();
 
        Scanner sc = new Scanner(System.in);
        System.out.print("찾으실 성별을 입력 하세요 : ");
        String empId = sc.nextLine();
        
//        String query = "SELECTd, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";
//        rset = stmt.executeQuery(query);
//      
//        if(rset.next()) {
//           System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
//        }
//        
     } catch (SQLException e) {
        e.printStackTrace();
     } finally {
       
        close(con);
        close(stmt);
        close(rset);
     } 
      
 }
	
	
	
	
	
	      
	
	
	}
	




