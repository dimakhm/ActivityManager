package controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.ActivityDataManagment;
import model.LogInDataManagment;
import model.ReportDataManagment;
import view.ElementarySchoolActivity;
import view.HighSchoolActivity;
import view.OtherActivity;
//import java.util.Random;

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
	
	
	//@SuppressWarnings("resource")
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
		        System.out.print("9.) Add new activity \n");
		        System.out.print("10.) Exit\n");
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
		        //CODE HERE - Add new activity
		    	addNewActivity();
		         break;
		         
		    case 10: 
		        System.out.println("Exiting Program...");
		        input.close();
		        System.exit(1);
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

		@SuppressWarnings("resource")
		Scanner input6 = new Scanner(System.in);
	   	System.out.println("enter the activity ID :");
		int line6 = input6.nextInt();
		
		ReportDataManagment d = new ReportDataManagment();
		if (d.ReportUserByActiviy(line6)==0)
			System.out.println("wrong activity ID, please try again");
		//input6.close();
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
			ActivityDataManagment.reduceCapicity(line20);
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
		@SuppressWarnings("resource")
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
    	//input4.close();
	}
	
	public static void deleteReview()throws Exception
	{
		@SuppressWarnings("resource")
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
    	//input5.close();
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
	
	
	public static void addNewActivity() throws Exception
	{
		
		@SuppressWarnings("resource")
		Scanner inputNumber = new Scanner(System.in);
		int typeOfActivity;
		
		
	   	System.out.println("Please enter the type of activity: \n"
	   			+ "For Other activity press 1 \n"
	   			+ "For High chool Activity press 2 \n"
	   			+ "For Elamentry school activity press 3\n"
	   			+ "Please Enter your choise: ");

	   	typeOfActivity = inputNumber.nextInt();


	    switch(typeOfActivity){

	    case 1:
	    	
	    	
			Scanner input2 = new Scanner(System.in);
			Scanner input3 = new Scanner(System.in);
			Scanner input4 = new Scanner(System.in);
			
			
			int randType = 0;
			// Generate Random type number from 100-999
			while(randType < 100)
			{ 
	        Random rand = new Random(); 
	        randType = rand.nextInt(1000); 
			}
			

			OtherActivity Other = new OtherActivity();
	    	Other.setActivityID(randType);
	        System.out.println("Enter name: ");
	        Other.setName(input2.nextLine());
	        System.out.println("Enter location: ");
	        Other.setLocation(input2.nextLine());
	        System.out.println("Enter maximum capacity: ");
	        Other.setMaxCapicity(input3.nextInt());
	        System.out.println("Enter price: ");
	        Other.setPrice(input4.nextDouble());
	        System.out.println("Enter description: ");
	        Other.setDescription(input2.nextLine());
	        System.out.println("Enter guide's name: ");
	        Other.setGuide(input2.nextLine()); 
	        System.out.println("Enter catagory: ");
	        Other.setCategory(input2.nextLine());  
	        System.out.println("Enter age range: ");
	        Other.setAgeRange(input2.nextLine());
	        
	        
	        ActivityDataManagment.addOtherActivity(Other);
	        
	    	
        	break;
	    case 2:

	    	
			Scanner input5 = new Scanner(System.in);
			Scanner input6 = new Scanner(System.in);
			Scanner input7 = new Scanner(System.in);

			
			int randType1 = 0;
			// Generate Random type number from 100-999
			while(randType1 < 100)
			{ 
	        Random rand = new Random(); 
	        randType1 = rand.nextInt(1000); 
			}
			

			HighSchoolActivity Other1 = new HighSchoolActivity();
	    	Other1.setActivityID(randType1);
	        System.out.println("Enter name: ");
	        Other1.setName(input5.nextLine());
	        System.out.println("Enter location: ");
	        Other1.setLocation(input5.nextLine());
	        System.out.println("Enter maximum capacity: ");
	        Other1.setMaxCapicity(input6.nextInt());
	        System.out.println("Enter price: ");
	        Other1.setPrice(input7.nextDouble());
	        System.out.println("Enter description: ");
	        Other1.setDescription(input5.nextLine());
	        System.out.println("Enter study units: ");
	        Other1.setStudyUnits(input6.nextInt()); 
	        System.out.println("Enter final exams preperations: ");
	        Other1.setFinalExam(input5.nextLine());  
	        System.out.println("Enter school association: ");
	        Other1.setSchoolAssociation(input5.nextLine());
	        
	    
		    ActivityDataManagment.addHighSchoolActivity(Other1);
		      
	    	break;
	    	
	    case 3:
	    	
	    	Scanner input8 = new Scanner(System.in);
			Scanner input9 = new Scanner(System.in);
			Scanner input10 = new Scanner(System.in);
			
			
			int randType2 = 0;
			// Generate Random type number from 100-999
			while(randType2 < 100)
			{ 
	        Random rand = new Random(); 
	        randType2 = rand.nextInt(1000); 
			}
			
			
			ElementarySchoolActivity Other2 = new ElementarySchoolActivity();
	    	Other2.setActivityID(randType2);
	        System.out.println("Enter name: ");
	        Other2.setName(input8.nextLine());
	        System.out.println("Enter location: ");
	        Other2.setLocation(input8.nextLine());
	        System.out.println("Enter maximum capacity: ");
	        Other2.setMaxCapicity(input9.nextInt());
	        System.out.println("Enter price: ");
	        Other2.setPrice(input10.nextDouble());
	        System.out.println("Enter description: ");
	        Other2.setDescription(input8.nextLine());
	        System.out.println("Enter certification: ");
	        Other2.setCertification(input8.nextLine()); 
	        System.out.println("Enter transport availability: ");
	        Other2.setTransport(input8.nextLine());  
	        System.out.println("Enter accessibility help: ");
	        Other2.setAccessable(input8.nextLine());
	    	
	     
	    	
	    	ActivityDataManagment.addElamentryShcoolActivity(Other2);
        	break;

	    default :
            System.out.println("This is not a valid Menu Option! Please try again!");
            
            break;
		
	} // func end
	}
}// class end