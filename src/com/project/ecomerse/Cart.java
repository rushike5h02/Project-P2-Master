package com.project.ecomerse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Cart {

	// TO create the object of Connectiontest class for call that method
	  Connectiontest test=new  Connectiontest();
	  Connection connection = null;
      PreparedStatement ps = null;
	
	// To Display the Orders
	public void getcartdeatails() {
		 try {
   			Connection con=test.getConnectionDetails();
   			//select query
   			PreparedStatement ps=con.prepareStatement("select * from orders");
   			
   			ResultSet rs=ps.executeQuery();
   			
   			while(rs.next()) {
   				System.out.println("ProductID ="+rs.getInt(1));
  				System.out.println("Productname="+rs.getString(2));
  				System.out.println("ProductDiscription="+rs.getString(3));
  				System.out.println("ProductQty="+rs.getInt(4));
                System.out.println("ProductPrice="+rs.getInt(5));
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
	// To Buy the product
	public void getBuyproduct() {
		try {
   		    Scanner sc=new Scanner(System.in);
   		    System.out.println("How much ProductQty to purchase-->>");
   		    int qty=sc.nextInt();
			for(int j=1;j<=qty;j++) {
           
            System.out.println("Enter your ProductID");
			int productID=sc.nextInt();
			System.out.println("Enter your ProductName");
			String ProductName=sc.next();
			System.out.println("Enter your ProductDiscription");
			String ProductDiscription=sc.next();
            System.out.println("Enter your ProductQty");
			int ProductQty=sc.nextInt();
            System.out.println("Enter your ProductPrice");
			int ProductPrice=sc.nextInt();
                        
			Connection con=test.getConnectionDetails();
			PreparedStatement stmt = con.prepareStatement("insert into orders(ProductID,Productname,ProductDiscription,ProductQty,ProductPrice)values(?,?,?,?,?)");

			// set the paramenter in table
			stmt.setInt(1,productID );
			stmt.setString(2,ProductName);
            stmt.setString(3,ProductDiscription);
            stmt.setInt(4,ProductQty);
            stmt.setInt(5,ProductPrice);
			

			int i=stmt.executeUpdate();
			
			System.out.println("Record is inserted."+i);

			con.close();
			stmt.close();
		   }//------------------------ for loop End
			System.out.println("Prouct added to cart succefully.....");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	public void getbill() {
		 try {
	   			Connection con=test.getConnectionDetails();
	   			//select query
	   			PreparedStatement ps=con.prepareStatement("select ProductID ,Productname,ProductDiscription,ProductQty,ProductPrice,ProductQty*ProductPrice as TotalPrice from orders");
	   			
	   			ResultSet rs=ps.executeQuery();
	   			
	   			while(rs.next()) {
	   				System.out.println("ProductID ="+rs.getInt(1));
	  				System.out.println("Productname="+rs.getString(2));
	  				System.out.println("ProductDiscription="+rs.getString(3));
	  				System.out.println("ProductQty="+rs.getInt(4));
	                System.out.println("ProductPrice="+rs.getInt(5));
	                System.out.println("TotalPrice="+rs.getInt(6));
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
	public void getTotalbillrecipt() {
		 Cart v=new  Cart();
		 System.out.println("****************** My Orders **************** ");
		 System.out.println("------------Selected Your Product---------------- ");
		 v.getcartdeatails();
		 System.out.println("------------Bill Product---------------- ");
		 v.getbill();
	}
}



