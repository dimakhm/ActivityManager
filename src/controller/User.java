package controller;

import java.util.Scanner;

import model.ActivityDataManagment;
import model.LogInDataManagment;
import model.RatingDataManagment;
import model.UserDataManagment;
import view.RatingAndReview;

public class User extends Account {
	
	
	// attributes
	
	private String name;
	private String phone;

/////////////////////
	
	// C'tor + getters + setters
	
	
	public User(String email, String password, String name, String phone) {
		super(email, password);
		this.name = name;
		this.phone = phone;
	}
	public User() {
		super("non", "non");
		this.name = "non"; 
		this.phone = "non";

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
///////////////////////
	
	// methods
	
	public static void showRatingAndReview(int activityID)
	{
		// need to check if possible (capicity)
		try {
			RatingDataManagment.showRatingAndReview(activityID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	public static void AvtivityRergister(User user,int activityID)
	{
		// need to check if possible (capicity)
		try {
			UserDataManagment.RegisterUserToAvctivity(user, activityID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static User userlogIn(String email, String pass) throws Exception {
		User userLogin = new User();
		System.out.println("validation with DataBase...");
		userLogin=LogInDataManagment.userlogIn(email, pass);
		return userLogin;
	}
	public static void userMenu(User user) {
		  Scanner input = new Scanner(System.in);
		   // boolean mainLoop = true; לא יודע מה זה עושה.. למחוק אולי

		    int choice;
		    while(true){
		        System.out.println("_______________________________________________ \n");
		        System.out.println("Hey " + user.getName()+ ",please make a choise!\n");
		        System.out.print("1.) show Other activities \n");
		        System.out.print("2.) show high school activities\n");
		        System.out.print("3.) show elemantry school activities\n");
		        System.out.print("4.) register to activity by activityID\n");
		        System.out.print("5.) watch activity review & rating by activityID\n");
		        System.out.print("6.) write your own review and rate!\n");
		        System.out.print("7.) Exit\n");
		        System.out.print("\nEnter Your Menu Choice: ");

		        choice = input.nextInt();




		    switch(choice){

		    case 1:
		    	try {
					ActivityDataManagment.getOtherActivities();
				} catch (Exception e) {
					e.printStackTrace();
				}
		        
		    	
	        	break;// code after User log in

		    case 2: 
		    	try {
					ActivityDataManagment.getHighSchoolActivities();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	break;// code after User log in


		    case 3:
		    	try {
					ActivityDataManagment.getElemntartActivities();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	break;// code after User log in
		    	
		    	
		    case 4: 
		    	int activityIDinput;
		    	  System.out.print("Please Enter activityID you want: ");
		    	  activityIDinput = input.nextInt();
		    	  User.AvtivityRergister(user, activityIDinput);
		    	  System.out.print("Excellent! registration is successfully done");
		    	  System.out.print("____________________________________________");
		    	  break;



		    case 5:
		    	
		    	int actID;
		    	 System.out.print("Please Enter activityID you want: ");
		    	 actID = input.nextInt();
		    	 User.showRatingAndReview(actID);
		    	  
		    	
		    	break;
		        
		    case 6:

		    	
		    	
		    	double rat;
		    	String rev;
		    	int id;
		    	System.out.print("Please Enter the activityID  : ");
		    	id=input.nextInt();
			    System.out.print("Please Enter the total rating (1-10): ");
			    rat=input.nextDouble();
			    input.nextLine(); // This line you have to add (It consumes the \n character)
			    System.out.print("Please Enter the review");
			    rev = input.nextLine();   
			    
			    RatingAndReview opinion=new RatingAndReview(id, rev, rat);
		    	
				try {
					RatingDataManagment.insertRatingAndReview(opinion);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.print("\nExcellent! we sure your opinion will help other");
		    	System.out.print("\n_______________________________________________");
		    	
		    	
		        break;
		        
		    	
		    	
		        
		        
		    case 7: 
		        System.out.println("Exiting Program...");
		        input.close();
		        System.exit(1);
		         break;
		    default :
		             System.out.println("This is not a valid Menu Option! Please Select Another");
		             break;

		    }


		    }




		    
		// TODO Auto-generated method stub

	}
	
	
	
	
///////////////////////	
	
	

	
}
