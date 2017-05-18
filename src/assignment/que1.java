package assignment;

import java.sql.*;
import java.util.Scanner;

public class que1 {
	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		String query=null;
		int chk=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Driver is loaded");
			//class not found exception
			//Reason: jar file not present
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");

			System.out.println("Connection Established");

			//	create statement
			Statement st=conn.createStatement();



			System.out.println("Employee Management");
			System.out.println("----------------------------------------------------");
			boolean a=true;
			while(a){
				System.out.println("1 . Display All Employees\n 2 . Display First Employee\n3 . Display Last Employee\n4 . Display All Departments\n5 . Display First Department\n6 . Display Last Department \n7 . Exit");
				switch (sc.nextInt()) 
				{
				case 2:
					query=" select * from emp where rownum=1";
					break;
				case 1:
					query="select * from emp";
					break;
				case 3:
					query=" select * from emp where id=(select max(id) from emp)";
					break;
				case 4:
					query="select dept from emp";
					break;
				case 5:
					query="select dept from emp where rownum=1";
					break;
				case 6:
					query="select * from emp ";
					st.executeQuery(query);

					ResultSet rs= st.executeQuery(query);

					int id=0;
					String name=null;
					String dept=null;
					while (rs.next()) {
						 id=rs.getInt(1);
						name=rs.getString(2);
						dept=rs.getString(3);
						

					}
					System.out.println(id+" : "+name+" : "+dept);
					rs.close();
					st.close();
					conn.close();
					chk=1;
					break;
				case 7: System.exit(0);


				default:System.out.println("Enter correct Input");
				break;
						}
				if(chk==0){
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
				}
				chk=0;
				System.out.println("Do you want to continue?? If no then press n");
				String ch=sc.next();
				if(ch.equalsIgnoreCase("n")){
					a=false;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
