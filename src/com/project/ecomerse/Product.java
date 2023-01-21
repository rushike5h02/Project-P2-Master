package com.project.ecomerse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Product {
	
	// TO create the object of Connectiontest class for call that method
	  Connectiontest test=new  Connectiontest();
	  Connection connection = null;
      PreparedStatement ps = null;
  
     
     // Display the product list
	public void Productretrive() {
		try {
 			// connect the Connection of SQLDatabase
			Connection con=test.getConnectionDetails();
 		    
			// Product list should be asending Order
 			PreparedStatement ps=con.prepareStatement("select * from product order by Productname asc");
 		
 			ResultSet rs=ps.executeQuery();
 			
 			while(rs.next()) {
 				System.out.println("ProductID ="+rs.getInt(1));
				System.out.println("Productname="+rs.getString(2));
				System.out.println("ProductDiscription="+rs.getString(3));
				System.out.println("ProductQty="+rs.getInt(4));
                System.out.println("ProductPrice="+rs.getInt(5));
                System.out.println("-------------------------------------------");
 			}
 		
 			con.close();
 			ps.close();
 			rs.close();
 			
 		}
 		
 		catch(Exception e) {
 			e.printStackTrace();
 		}
	}
   //Add multiple products
	public void multipleproduct() {
		 try {
    		 Scanner sc=new Scanner(System.in);
    		System.out.println("Enter your ProductQty to ADD-->>");
    		int qty=sc.nextInt();
 			for(int j=1;j<=qty;j++) {
            
            System.out.println("enter your ProductID");
 			int productID=sc.nextInt();
 			System.out.println("Set your ProductName");
 			String ProductName=sc.next();
 			System.out.println("Enter your ProductDescription");
 			String ProductDiscription=sc.next();
            System.out.println("enter your ProductQty");
 			int ProductQty=sc.nextInt();
            System.out.println("enter your ProductPrice");
 			int ProductPrice=sc.nextInt();
 	     	// connect the Connection of SQLDatabase            
 			Connection con=test.getConnectionDetails();
 			PreparedStatement stmt = con.prepareStatement("insert into product(ProductID,Productname,ProductDescription,ProductQty,ProductPrice)values(?,?,?,?,?)");

 			// set the paramenter in table
 			stmt.setInt(1,productID );
 			stmt.setString(2,ProductName);
            stmt.setString(3,ProductDiscription);
            stmt.setInt(4,ProductQty);
            stmt.setInt(5,ProductPrice);
            System.out.println("-------------------------------------------");

 			int i=stmt.executeUpdate();
 			
 			System.out.println("Record is inserted."+i);

 			con.close();
 			stmt.close();
 		   }//------------------------ for loop End
 			System.out.println("Products Added succesfully....");
 		} catch (Exception e) {
 			System.out.println(e);
 		}
		
	}
	
	// To update the product
	public void getupdateproductlist() {
		
		try {
			// connect the Connection of SQLDatabase            
 			Connection con=test.getConnectionDetails();
			PreparedStatement stmt = con.prepareStatement("update product set Productname=? ,ProductDescription=?,ProductQty=?,ProductPrice=? where ProductID=?");
			
			Scanner sc=new Scanner (System.in);
			System.out.println("Enter your update Productname");
			String str1=sc.next();
			System.out.println("Enter your update ProductDescription");
			String str2=sc.next();
			System.out.println("Enter your update ProductQty");
			String str3=sc.next();
			System.out.println("Enter your update ProductPrice");
			String str4=sc.next();
			System.out.println("Enter your update ProductID");
			int id=sc.nextInt();
			
			stmt.setString(1, str1); 
			stmt.setString(2, str2); 
			stmt.setString(3, str3); 
			stmt.setString(4, str4); 
			stmt.setInt(5, id);
			
			int i=stmt.executeUpdate();
			System.out.println("Product updated succesfully...."+i);
			con.close();
			stmt.close();
			}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}
	
	//To Delete Product
	public void getDeleteProduct() {
		try {
			// connect the Connection of SQLDatabase            
 			Connection con=test.getConnectionDetails();
			PreparedStatement stmt = con.prepareStatement("delete from product where Productname=?");
			
			Scanner sc=new Scanner (System.in);
			System.out.println("Enter your Delete Productname");
			String str1=sc.next();
			stmt.setString(1, str1); 
			int i=stmt.executeUpdate();
			System.out.println("Product Deleted succesfully...."+i);
			con.close();
			stmt.close();
			}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}

}
