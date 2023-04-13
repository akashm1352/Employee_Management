import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import ExceptionPac.CharException;

public class Emp_Manage {
	
	//Add Employee Method
	public static boolean addEmp(Emp em) {
		boolean flag = false;
		try {
		//jdbc code
		Connection con = Con_Build.createCon();
		String q = "insert into sec_pro_emp.emp(id,name,sal,loc) values(?,?,?,?)";
		// PreparedStatement
		PreparedStatement pstm = con.prepareStatement(q);
		
		//Set the value of parameter
		pstm.setInt(1, em.id);
		pstm.setString(2, em.name);
		pstm.setInt(3, em.getSal());
		pstm.setString(4, em.loc);
		
		//Execute
		pstm.executeUpdate();
		
		//flag 
		flag = true;
		
		
		} catch (Exception e) {

			e.printStackTrace();
		}
		return flag;
		
	}
	
	//Delete emp method
	public static boolean removeEmp(int id) {
		
		boolean flag = false;
		
		try {
			if(id==111) {
				//Connection jdbc
				Connection con = Con_Build.createCon();
				String qAll = "delete from sec_pro_emp.emp";
				//Statement
				Statement stmtAll = con.createStatement();
				//Execute
				stmtAll.executeUpdate(qAll);
				// Flag
				flag = true;
			}
			else {
		// jdbc code
		Connection con = Con_Build.createCon();
		String q = "delete from sec_pro_emp.emp where id=?";
		
		//PreparedStatement
		PreparedStatement pstm = con.prepareStatement(q);
		
		//Set value for id
		pstm.setInt(1, id);
		//Execute
		pstm.executeUpdate();
		// Flag
		flag = true;
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
		
	}
	
	//Display emp method
	public static void getEmp(int eid) {
		
		
		try {
			// Connection jdbc
			Connection con = Con_Build.createCon();
			
			if(eid==111) {
			
			String q = "select * from sec_pro_emp.emp";
			
			// Statement
			Statement stmt = con.createStatement();
			
			// ResultSet 
			ResultSet rs = stmt.executeQuery(q);
			
			//get data
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int sal = rs.getInt(3);
				String loc = rs.getString(4);
				System.out.println("--------------------------------");
				System.out.println(id+"  "+name+"  "+sal+"  "+loc);
				System.out.println("--------------------------------");
				
				}
			}
			else {
				
				String q = "select * from sec_pro_emp.emp where id = ?";
				PreparedStatement pstmt = con.prepareStatement(q);
				pstmt.setInt(1, eid);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					int sal = rs.getInt(3);
					String loc = rs.getString(4);
					System.out.println("--------------------------------");
					System.out.println(id+"  "+name+"  "+sal+"  "+loc);
					System.out.println("--------------------------------");
					
				}
				else {
					System.out.println("Id id invalid....!!!!");
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//Update method
	public static boolean updateEmp(int id) {
		boolean flag = false;
		String name = "";
		int sal = 0;
		String loc = "";
		
			// creating Scanner Class object
			Scanner sc = new Scanner(System.in);
			try {
				
			System.out.println("Enter Employee Name : ");
			name = sc.next();
			for(int i = 0; i<name.length(); i++) {
				char ch = name.charAt(i);
				if(!(ch>='A' && ch<='Z') && !(ch>='a' && ch<='z')) {
					try {
					throw new CharException();
					}
					catch(CharException c) {
						System.out.println("Please enter alphabetical name.....");
						System.out.println();
						updateEmp(id);
					}
				}
				else {
					
				}
			}
			
			System.out.println("Enter Employee Salary : ");
			try {
			sal = sc.nextInt();
			}
			catch(InputMismatchException e) 
			{
				System.out.println();
				System.out.println("Please enter Numerical Salary..!!!");
				System.out.println();
				updateEmp(id);
			}
			System.out.println("Enter Employee Location : ");
			loc = sc.next();
			for(int i = 0; i<loc.length(); i++) {
				char ch = loc.charAt(i);
				if(!(ch>='A' && ch<='Z') && !(ch>='a' && ch<='z')) {
					try {
					throw new CharException();
					}
					catch(CharException c) {
						System.out.println("Please enter alphabetical location name.....");
						System.out.println();
						updateEmp(id);
					}
				}
				else {
					
				}
			}
		
			//Connection jdbc
			Connection con = Con_Build.createCon();
		
			String q = "update sec_pro_emp.emp set name=?, sal=?, loc=? where id = ?";
		
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value in query
			pstmt.setString(1, name);
			pstmt.setInt(2, sal);
			pstmt.setString(3, loc);
			pstmt.setInt(4,id);
			
			//Execute
			pstmt.executeUpdate();
			flag = true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return flag;
		
	}

	
}
