package controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.ActivityDataManagment;
import model.LogInDataManagment;
import model.ReportDataManagment;

public class Admin extends Account {

	
	// C'tor
	
	
	public Admin(String email, String password) {
		super(email, password);
	}

////////////////////////
	
	
	// methods
	
	public static Boolean adminlogIn(String email, String pass) throws Exception {
		Boolean valid;
		System.out.println("validation with DataBase...");
		valid=LogInDataManagment.adminlogIn(email, pass);
		return valid;
	}
	
	
	@SuppressWarnings("resource")
	public static void adminMenu() throws Exception {
	
		Scanner input = new Scanner(System.in);
		   // boolean mainLoop = true; לא יודע מה זה עושה.. למחוק אולי

		    int choice;
		    while(true){
		        System.out.println("_____________________________ \n");
		        System.out.print("1.) make a report of Users \n");
		        System.out.print("2.) make a report of activities by rating \n");
		        System.out.print("3.) make a report of activities by most subscribe  \n");// חוגים לפי הכי הרבה נרשמים
		        System.out.print("4.) make a report of registered users by activity ID\n");// נרשמים של כל חוג
		        System.out.print("5.) delete user from Activity\n");
		        System.out.print("6.) delete Activity\n");
		        System.out.print("7.) delete Review\n");
		        System.out.print("8.) Show all activities\n");
		        System.out.print("9.) Exit\n");
		        System.out.print("\n Enter Your Menu Choice: ");

		        choice = input.nextInt();




		    switch(choice){

		    case 1:
		    	reportAllUsers();   	
		   	   	break;// code after User log in

		    case 2: 
		    	reportActByRating();	        	
		    	break;// code after User log in
	        	
		    case 3: 
		    	reportActByCapacity();
	        	break;// code after User log in

		    case 4: 
		    	reportActByName();		    	
	        	break;// code after User log in


		    case 5:
		    	deleteUser();     
	        	break;// code after User log in

		    case 6: 
		    	deleteActivity();
	        	break;// code after User log in


		    case 7:
		    	deleteReview();

		        break;
		        
		    case 8:
		    	showAllActivities();
		    	

		        break;

		    case 9: 
		        System.out.println("Exiting Program...");
		       
		         break;
		         
		    default :
		             System.out.println("This is not a valid Menu Option! Please Select Another");
		             break;

		    }
		    }
		    
	}//menu end
	
	
	
	
		
		
	public static void reportAllUsers()throws Exception
	{
		ReportDataManagment a = new ReportDataManagment();
    	a.getAllUsers();		
	}
		
	public static void reportActByRating()throws Exception
	{
		ReportDataManagment b = new ReportDataManagment();
    	b.listActivitiesByRating();	
	}
	
	public static void reportActByCapacity()throws Exception
	{
		ReportDataManagment c = new ReportDataManagment();
		c.ReportActByCapcity();
	}
	
	public static void reportActByName()throws Exception
	{
		Scanner input6 = new Scanner(System.in);
	   	System.out.println("enter the activity ID :");
		int line6 = input6.nextInt();
		
		ReportDataManagment d = new ReportDataManagment();
		if (d.ReportUserByActiviy(line6)==0)
			System.out.println("wrong activity ID, please try again");
		input6.close();
	}
	
	
	public static void deleteUser()throws Exception
	{
		@SuppressWarnings("resource")
		Scanner input3 = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner input20 = new Scanner(System.in);
	    System.out.println("enter the email of the user you wish to delete from Activity:");
		String line1 = input3.nextLine();
		System.out.println("enter the activity ID:");
		int line20 = input20.nextInt();
		if (ActivityDataManagment.deleteUserFromActivity(line1,line20)==1)
		{
			JOptionPane.showMessageDialog(null, "delete user from Activity successfully");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Wrong details! please try again");
		}
		 
	       
		//input3.close();
		//input20.close();
	}
	
	
	public static void deleteActivity()throws Exception
	{
		Scanner input4 = new Scanner(System.in);
       	System.out.println("enter the ActivityID of the Activity you wish to delete from Activity List:");
    	int line2 = input4.nextInt();
    	    	
    	if (ActivityDataManagment.deleteActivity(line2 )==1)
		{
			JOptionPane.showMessageDialog(null, "Activity deleted successfully");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Wrong activity ID! please try again");
		}
    	input4.close();
	}
	
	public static void deleteReview()throws Exception
	{
		Scanner input5 = new Scanner(System.in);
	   	System.out.println("enter the SerialNumber of the review you wish to delete from review List:");
		int line3= input5.nextInt();
		
    	if (ActivityDataManagment.deleteReview(line3)==1)
		{
			JOptionPane.showMessageDialog(null, "Review deleted successfully");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Wrong review Serial Number! please try again");
		}
    	input5.close();
	}
	
	
	public static void showAllActivities()throws Exception
	{
		ActivityDataManagment e = new ActivityDataManagment();
		List<ReportDataManagment> listFromData = new ArrayList<>();
		listFromData = e.getAllActivity();
		for (int i=0; i<listFromData.size(); i++)
		{
			System.out.println(listFromData.get(i).toString());		
		}
	}
	
	
	

}// class end