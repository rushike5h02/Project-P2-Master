package com.project.ecomerse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserOpearations {
	
	// TO create the object of Connectiontest class for call that method
	  Connectiontest test=new  Connectiontest();
	  Connection connection = null;
      PreparedStatement ps = null;
      
      
	// User registration from input
	public void getUserRegistration() {
		
		 try {
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter your follwing details-------->>");
	            System.out.println("enter your Firstname");
				String Firstname=sc.next();
				System.out.println("enter your Lastname");
				String Lastname=sc.next();
				System.out.println("enter your Mobileno");
				int Mobileno=sc.nextInt();
				System.out.println("Set your Username");
				String Username=sc.next();
				System.out.println("Set your Password");
				int Password=sc.nextInt();
				
				// connect the Connection of SQLDatabase
				Connection con=test.getConnectionDetails();
				PreparedStatement stmt = con.prepareStatement("insert into users(Firstname,Lastname,Mobileno,Username,Password)values(?,?,?,?,?)");

				
				stmt.setString(1,Firstname); //1 first parameter in query.
				stmt.setString(2, Lastname);
	            stmt.setInt(3, Mobileno);
	            stmt.setString(4, Username);
	            stmt.setInt(5, Password);
				

				int i=stmt.executeUpdate();
				System.out.println("Record is inserted."+i);

				con.close();
				stmt.close();
				
				System.out.println("User ragistration succefully....");
			} catch (Exception e) {
				System.out.println(e);
			}
		
	}
	
	// To Display the UserList
	public void getUserslist() {
		
		 try {
   		    // connect the Connection of SQLDatabase
   		    Connection con=test.getConnectionDetails();
   			//select query
   			PreparedStatement ps=con.prepareStatement("select * from users");
   			
   			ResultSet rs=ps.executeQuery();
   			
   			while(rs.next()) {
   				System.out.println("Firstname="+rs.getString(1));
  				System.out.println("Lastname="+rs.getString(2));
  				System.out.println("Mobileno="+rs.getInt(3));
  				System.out.println("Username="+rs.getString(4));
                System.out.println("Password="+rs.getInt(5));
                System.out.println("-------------------------------------------------");
   			}
   		
   			con.close();
   			ps.close();
   			rs.close();
   			
   		}
   		
   		catch(Exception e) {
   			e.printStackTrace();
   		}
        
	
		
	}

}
