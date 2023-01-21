package com.project.ecomerse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Admin {
	
	//create object of Product,UserOpearationsn and Cart to call that methods
	Product p=new Product();
	UserOpearations us=new UserOpearations();
	Cart cart=new Cart();
	ReturnEcomerse re=new ReturnEcomerse();
	
	public void productinfo() {
		
		
		String choice="";
		while(!choice.equals("4")) {
			
		 System.out.println("**********Welcome to E-shop**********");
         System.out.println("Press '1' if you want to see list of products");
         System.out.println("Press '2' if you want to edit productlist ");
         System.out.println("Press '3' if you want to see list of userlist");
         System.out.println("Press '4' if you want to see list of purchase orders");
         
         Scanner sc1=new Scanner( System.in);
         choice=sc1.next();
         
         switch(choice) {
         
         case "1":
        	 p.Productretrive();
        	  break;
        	  
         case "2":
        	 System.out.println("---------Welcome to products menu------------");
        	 System.out.println("press '1' to Add the product");
        	 System.out.println("press '2' to update the product");
        	 System.out.println("press '3' to Delete the product");
        	
        	 Scanner sc2=new Scanner(System.in);
        	 int press=sc2.nextInt();
        	 // To Add the product
        	 if(press==1) {
        		 p.multipleproduct(); 
        	 }
        	 //To update the product
        	 else if(press==2) {
        		p.getupdateproductlist(); 
        	 }
        	 //TO delete the product
        	 else if(press==3) {
        		 p.getDeleteProduct();
        	 }
             break;
        	  
         case "3":
        	 us.getUserslist();
        	 break;
        	 
         case "4":
        	 cart.getbill();
             break;
         default:
             System.out.println("Inavlid input ");
         }
         
         
}
		
		// Returning to Ecomerse class
		re.getReturnEcomerse();

	}

}
