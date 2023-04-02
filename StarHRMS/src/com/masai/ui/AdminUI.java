package com.masai.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.exception.SomthingWentWrongException;
import com.masai.exception.WrongCredentialsException;

public abstract class AdminUI {
	private static boolean login = false;

	
	public static boolean isLogin() {
		return login;
	}

	static void adminLogInUI(Scanner sr) throws InterruptedException {
		System.out.println("--------- LogIn To Admin -----------");
		System.out.println("=====================================");
		int i=0;
		String choice = "0";
		do {
			System.out.println("Enter Your Username :  ");
			String username = sr.next();
			System.out.println("Enter Your Password :  ");
			String password = sr.next();
			if(username.equals("Admin") && password.equals("Admin")) {
				 System.out.println("----------- Login Successfully !!! ------------");
				 login = true;			 
				 Thread.sleep(1000);
				 System.out.println("\n");
					System.out.println("-------Admine DashBord--------");
					System.out.println("------------------------------");
				 AdminUI.admin(sr);
				 break;
			}
			else {
				System.out.println("Wrong Credentials-----");
				System.out.println("=================================\r\n");
				if(i!=3) {
					System.out.println("Press 1: Wants to try again!!!");
					System.out.println("Press 0: Want to go back to Home paga\n");
					do {
						System.out.print("Enter your choice:  ");
						choice = sr.next();
						if(!choice.equals("1")&&!choice.equals("0")) {
							System.out.println("Opps ! Wrong input please try again...");
						}
					}while(!choice.equals("1")&&!choice.equals("0"));
					i++;
				}
				else {
					System.out.println("Already Try Three Times-------");
					System.out.println("Visit after some Time!!!------");
				}
			}
		}while(i!=3&&!choice.equals("0"));
	}
	
	static void adminMenu() throws InterruptedException {
		System.out.println("\nPlease Choose an Option ------------");
		System.out.println("Press 1 : < ---- > Add New Department ");
		System.out.println("Press 2 : < ---- > View All The Departments ");
		System.out.println("Press 3 : < ---- > View All The Employees ");
		System.out.println("Press 4 : < ---- > Update The Department ");
		System.out.println("Press 5 : < ---- > Add New Employee ");
		System.out.println("Press 6 : < ---- > Transfer employee to other department ");
		System.out.println("Press 7 : < ---- > Accept Leaves or Reject Leave Of Employee ");
		System.out.println("Press 8 : < ---- > Fire An Employee");
		System.out.println("Press 9 : < ---- > Delete Department ");
		System.out.println("Press 0 : < ---- > Exit -OR- Go Back To Home ");
	}
	
	
	
	abstract void addNewDepartmentUI(Scanner sr);
	abstract void viewAllDepartmentUI();
	abstract void viewAllEmployeeUI(Scanner sr);
	abstract void updateDepartmentUI(Scanner sr);
	abstract void addNewEmployeeUI(Scanner sr);
	abstract void transferemployeetootherdepartUI(Scanner sr);
	abstract void aceeptOrRejectLeavesOfEmployeeUI(Scanner sr);
	abstract void fireEmployeeUI(Scanner sr);
	abstract void deleteDepartmentUI(Scanner sr);
	

	static void admin(Scanner sr) throws InterruptedException {
		String choice = "0";
		while(login) {
			adminMenu();
			AdminUI adminUI = new AdminUIImpl();
		    System.out.print("Enter your selection : ");
		    choice = sr.next();
		    System.out.println();
		    switch(choice) {
		    		case "1":
		    			adminUI.addNewDepartmentUI(sr);
		    			break;
		    		
		    		case "2":
		    			adminUI.viewAllDepartmentUI();
		    			 break;
		    		
		    		case "3":
		    			 adminUI.viewAllEmployeeUI(sr);
		    			 break;
		    			 
		    		case "4":
		    			 adminUI.updateDepartmentUI(sr);
		    			 break;
		    		
		    		case "5":
		    			 adminUI.addNewEmployeeUI(sr);
		    			 break;
		    		
		    		case "6":
		    			adminUI.transferemployeetootherdepartUI(sr);
		    			break;
		    	
		    		case "7": 
		    			adminUI.aceeptOrRejectLeavesOfEmployeeUI(sr);
		    			break;
		    		
		    		case "8":
		    			adminUI.fireEmployeeUI(sr);
		    			break;
		    			
		    		case "9":
		    			 adminUI.deleteDepartmentUI(sr);
		    			 break;
		 
		    		case "0":
		    			  System.out.println("-------Thanks for Your Visit----------");
		    			  login = false;
		    			  break;
		    			 
		    		default:
		    			System.out.println("Opps wrong input! please try again");
		    			
		    }
		    Thread.sleep(1000);
		}
	}

}
