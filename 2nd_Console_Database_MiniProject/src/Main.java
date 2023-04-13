import java.util.InputMismatchException;
import java.util.Scanner;

import ExceptionPac.CharException;

public class Main {
	public static void main(String[] args) {
		
		start();
		
	}
	
	public static void start() {
		
		Scanner sc = new Scanner(System.in);


			System.out.println("Press 1 for ADD Employee detail : ");
			System.out.println("Press 2 for REMOVE Employee detail : ");
			System.out.println("Press 3 for UPDATE Employee detail : ");
			System.out.println("Press 4 for SEE Employee detail : ");
			System.out.println("Press 5 for Exit App : ");
			try
			{
			int num = sc.nextInt();

			if(num==1) 
			{
				//Taking inputs
				try 
				{
					System.out.println("Enter ID of Employee to ADD : ");
					int id = sc.nextInt();

					System.out.println("Enter name of Employee to ADD : ");
					String name = sc.next();
					
					for(int i = 0; i<name.length(); i++) {
						char ch = name.charAt(i);
						if(!(ch >= 'A' && ch <= 'Z') && !(ch >= 'a' && ch <= 'z')) {
							try {
								throw new CharException();
								}
								catch(CharException c) {
									System.out.println("Please enter alphabetical name......");
									System.out.println();
									start();
								}
						}
						else {
							
						}
					}
					
					System.out.println("Enter salary of Employee to ADD : ");
					int sal = sc.nextInt();
					
					System.out.println("Enter location of Employee to ADD : ");
					String loc = sc.next();
					for(int i = 0; i<loc.length(); i++) {
						char ch = loc.charAt(i);
						if(!(ch>='A' && ch<='Z') && !(ch>='a' && ch<='z')) {
							try {
							throw new CharException();
							}
							catch(CharException c) {
								System.out.println("Please enter alphabetical location name.....");
								System.out.println();
								start();
							}
						}
						else {
							
						}
					}

					// Creating object of Emp class
					Emp em = new Emp(id,name,sal,loc);
					//Method called
					boolean flag = Emp_Manage.addEmp(em);
					//Flagging
					if(flag) {
						System.out.println("Employee Added Successfully..!!");
					}
					else {

						System.out.println("Something went wrong..!!");
					}
					//System.out.println(em);

					System.out.println();
					System.out.println("##########################################");
					System.out.println();

				}
				catch(InputMismatchException e) 
				{
					System.out.println();
					System.out.println("Please enter valid input..!!!");
					System.out.println("##########################################");
					System.out.println();
					start();
				}
				start();
			}
			else if(num==2) {
				System.out.println("Enter emp_id to Remove 1 Employee : ");
				System.out.println("<><><><><><>  OR  <><><><><><><><><>");
				System.out.println("Enter 111 to Remove All Employees : ");
				
				int id = sc.nextInt();
				// Remove method called
				boolean flag = Emp_Manage.removeEmp(id);
				//Flagging
				if(flag) {
					System.out.println("Employee Removed Successfully..!!");
				}
				else {

					System.out.println("Something went wrong..!!");
				}
				

				System.out.println();
				System.out.println("##########################################");
				System.out.println();
				start();
			}
			else if(num==3) {

				System.out.println("Enter Emp_ID to change Employee details : ");
				
				int id = sc.nextInt();
				boolean flag = Emp_Manage.updateEmp(id);
				if(flag) {
					System.out.println("Employee details Updated....!!");
				}
				else {
					System.out.println("Something went wrong..!!!!");
				}

				System.out.println();
				System.out.println("##########################################");
				System.out.println();
				start();
			}
			else if(num==4) {
				System.out.println("Enter 111 to get all Employee details : ");
				System.out.println("<><><><><><><><>  OR  <><><><><><><><><>");
				System.out.println("Enter emp_id to get Employee details : ");
				int eid = sc.nextInt();
				Emp_Manage.getEmp(eid);

				System.out.println();
				System.out.println("##########################################");
				System.out.println();
				start();
			}
			else if(num==5) {
				exit();
			}
			else {
				System.out.println("Invaild Input enter number in range 1 to 5 only...!!!");
				System.out.println();
				start();
			}
			}
			catch(InputMismatchException e){
				System.out.println("Please enter number input only..!!!");
				System.out.println();
				start();
			}
		
			
	}
	
	public static void exit() {
		
		System.out.println();
		System.out.println("##########################################");
		System.out.println();
		System.out.println("ThankYou for using our App..!!!");
		System.out.println("Visit soon......");
		
	}
	
}
