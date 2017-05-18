package jdbcDemo;

import java.sql.*;
import java.util.Scanner;



public class Demo {

	public static void main(String[] args) {
		//load driver
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loaded");
		//class not found exception
		//Reason: jar file not present
		 Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");

		 System.out.println("Connection Established");
		
	//	create statement
		Statement st=conn.createStatement();
		
		
		System.out.println("Enter Id,name ,Dept for emp");
		String q="insert into emp values("+sc.nextInt()+",'"+sc.next()+"','"+sc.next()+"')";
		st.executeUpdate(q);
		String query="select * from emp";
		st.executeQuery(query);
		ResultSet rs= st.executeQuery(query);
	
		
		while (rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String dept=rs.getString(3);
			System.out.println(id+" : "+name+" : "+dept);

		}
		rs.close();
		st.close();
		conn.close();
		
		
		
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
