package Database;

import java.sql.*;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		post();
		getdelete();
		updatedata();
		getresult();
		getresults();
	}

	public static void getresults() throws Exception{
		try {
			
			Connection conn= getconnection();
			PreparedStatement get= conn.prepareStatement("SELECT * FROM employeedetails LIMIT 4");
		     ResultSet result= get.executeQuery();
		    while(result.next()) {

		    	System.out.println(result.getString(2)+ " "+ result.getString(3)
		    	+result.getString(4)+" "+result.getString(5)
		    	+result.getString(6)+" "+result.getString(7)
		    	+result.getString(8)+" "+result.getString(9)
		    	+result.getString(10)+" "+ result.getString(11)); 
		    } 	
		    
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("Getting result successfully");
		}
	}
	
	public static void getdelete() throws Exception{
		try {
			Connection conn= getconnection();
			Statement mystatement= conn.createStatement();
			String deletevalue="delete from employeedetails where id=2";
			mystatement.executeUpdate(deletevalue);
			mystatement.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("deleted successfully");
		}
	}
	
	public static void updatedata() throws Exception{
	
		
		try {
			Connection conn= getconnection();
			String update=("update employeedetails set firstname='varun', lastname='kumar', Emailid='varunkumar@gmail.com', "
					+ "mobilenumber='7898654254', Address='Gachibowli' where id=2"); 
			Statement mystatement= conn.createStatement();
			mystatement.executeUpdate(update);
			mystatement.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("updating the data successfully");
		}
	}
	
	public static void getresult() throws Exception{
		try {
			
			Connection conn= getconnection();
			PreparedStatement get= conn.prepareStatement("SELECT firstname, lastname, Emailid, mobilenumber FROM employeedetails LIMIT 1");
			
			ResultSet result = get.executeQuery();
			
			ArrayList array= new ArrayList();
			while(result.next()) {
				System.out.println(result.getString("firstname"));
				System.out.println(result.getString("lastname"));
				System.out.println(result.getString("Emailid"));
				System.out.println(result.getInt("mobilenumber"));
			
				
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("Getting result successfully");
		}
	}
	public static void  post() throws Exception {
		String user= "admin";
		String passwd="admin";
		String role="Engineer";
		String var1="manoj";
		String var2="kumar";
		String mail="manojkumar@gmail.com";
		int number= 567896456;
		int Empid= 556678;
		String address="shapurnagar";
		int pin=1111;
		
		
		try {
			Connection conn= getconnection();
            PreparedStatement post= conn.prepareStatement("INSERT INTO employeedetails(username, password, role, firstname, lastname,"
            		+ "Emailid, mobilenumber, Employeeid, Address, Pincode) VALUES ('"+user+"','"+passwd+"','"+role+"','"+
            		var1+"','"+var2+"','"+mail+"','"+number+"','"+Empid+"','"+address+"','"+pin+"')");
            
            post.executeUpdate();
            post.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("inserted the values");
		}
		
	}
	public static void createtable() throws Exception{
		try {
			Connection conn= getconnection();
            PreparedStatement create= conn.prepareStatement("CREATE TABLE IF NOT EXISTS employeedetails(Id int NOT NULL AUTO_INCREMENT, username varchar(60),"
            		+ "password varchar(60), role varchar(60),firstname varchar(60),lastname varchar(60), Emailid varchar(100),"
            		+ "mobilenumber int(10) NOT NULL, Employeeid int(10) NOT NULL, Address varchar(200), Pincode int(10) NOT NULL, PRIMARY KEY(Id))");
            create.executeUpdate();
            create.close();
            System.out.println("update successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static Connection getconnection() throws SQLException {
		try {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/employee";
		String user="root";
		String password="admin";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("connected successfull");
		return conn;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
		
		
	}

}
