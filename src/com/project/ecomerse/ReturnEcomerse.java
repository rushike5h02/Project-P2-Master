package com.project.ecomerse;

import java.util.Scanner;

public class ReturnEcomerse {
	public void getReturnEcomerse() {
		  Scanner s=new Scanner(System.in);
	         Ecomerse e=new Ecomerse();
	         System.out.println("press '1'  to continue while close the shop enter '2' button");
	         int enter =s.nextInt();
	        if(enter==1) {
	        	e.Ecomerse();
	        }
	        //Exit
	        else if(enter==2){
	        	 System.out.println("************ Thank you for visiting E-Cart*****************");
	        }
	}

}
