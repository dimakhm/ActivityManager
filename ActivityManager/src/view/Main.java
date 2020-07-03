package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import controller.AdminController;
import controller.UserController;
import model.Activity;
import model.Admin;
import model.ElementarySchoolActivity;
import model.HighSchoolActivity;
import model.OtherActivity;
import model.RatingAndReview;
import model.User;




public class Main {
	
	
	AdminController adminController;
	UserController userController;
	Scanner input;
	
	
	Main()
	{
		this.adminController=new AdminController();
		this.userController=new UserController();
		input = new Scanner(System.in);
		
	}
	
	
	


	public static void main(String[] args) throws Exception {
		Main main=new Main();
		main.printHeader();
		main.mainMenu();
		
		
		
		
		
	}
	
	
	
	
	
	
	private void mainMenu() throws Exception {


		    int choice;
		    while(true){
		        System.out.println("\n ---Select your chiose---\n");
		        System.out.print("1.) User LogIn \n");
		        System.out.print("2.) Admin LogIn\n");
		        System.out.print("3.) Sign Up\n");
		        System.out.print("4.) Exit\n");
		        System.out.print("\nEnter Your Menu Choice: ");

		        choice = input.nextInt();



		    switch(choice){

		    case 1:
		    	User user=new User();
		        System.out.print("Please Enter The mail: ");
		        user.setEmail(input.next()); 
		        System.out.print("\nPlease Enter The password: ");
		        user.setPass(input.next()); 
		        user = userController.signIn(user);
		        
		        if (user.getEmail().equals("non")) {
			        System.out.print("LogIn Fail try again ");
		        	break;

				}
		        this.userMenu(user);	


		        
	        	break;

		    case 2: 

		    	Admin admin=new Admin();
		        System.out.print("Please Enter The mail: ");
		        admin.setEmail(input.next()); 
		        System.out.print("\nPlease Enter The password: ");
		        admin.setPass(input.next()); 
		        admin = adminController.signIn(admin);
		        
		        if (admin.getEmail().equals("non")) {
			        System.out.print("LogIn Fail try again ");
		        	break;
				}
		        
		        this.adminMenu(admin);
		    	

		        
		        
		    case 3:
		    	User newUser=new User();
		        System.out.println("enter email ");
		        newUser.setEmail(input.next());
		        System.out.println("enter pass ");
		        newUser.setPass(input.next());
		        System.out.println("enter name ");
		        newUser.setName(input.next());
		        System.out.println("enter phone ");
		        newUser.setPhone(input.next());
		        Boolean valid=userController.signUpUser(newUser);
		        if (valid) {
					System.out.println("yes");
			        this.userMenu(newUser);	

				}
				System.out.println("shit");


		        break;

		   

		    case 4: 

		        System.out.println("Exiting Program...");
		        input.close();
		   
		       System.exit(1);
		    default :
		             System.out.println("This is not a valid Menu Option! Please Select Another");
		             break;

		    }


		    }
    }
	
	
	
	
	
	
	private void printHeader() {

        System.out.println("+-----------------------------------+");
        System.out.println("|      Welcome to Or Activity          |");
        System.out.println("|        Manager Java App           |");
        System.out.println("+-----------------------------------+");
    }
	
	
	
	public void userMenu(User user) throws Exception
	{
		System.out.println("_______________________________________________ \n");
        System.out.println("Hey " + user.getName()+ ",please make a choise!\n");
        
        int choice;
	    while(true){
	      
	        System.out.print("1.) show Other activities \n");
	        System.out.print("2.) show high school activities\n");
	        System.out.print("3.) show elemantry school activities\n");
	        System.out.print("4.) register to activity by activityID\n");
	        System.out.print("5.) watch activity review & rating by activityID\n");
	        System.out.print("6.) write your own review and rate!\n");
	        System.out.print("7.) contact us\n");
	        System.out.print("8.) Exit\n");
	        System.out.print("\nEnter Your Menu Choice: ");


	        choice = input.nextInt();




	    switch(choice){

	    case 1: //show Other activities
	    	
	    	
    	List<OtherActivity> list = new ArrayList<OtherActivity>(); 
	    	
	    	

	    	try {
			list=userController.getOtherActivities();
			} catch (Exception e) {
				e.printStackTrace();
		}
    	
	    	
	    	for (int i = 0; i < list.size(); i++) {
			(list.get(i)).showActivityInfo();
			}
	    	
	    	
        	break;

	    case 2: //show high school activities

List<HighSchoolActivity> list2 = new ArrayList<HighSchoolActivity>(); 
	    	
	    	

	    	try {
			list2=userController.getHighSchoolActivity();
			} catch (Exception e) {
				e.printStackTrace();
		}
    	
	    	
	    	for (int i = 0; i < list2.size(); i++) {
			(list2.get(i)).showActivityInfo();
			}
	    	
	    	
	    	
	    	
	    	break;


	    case 3: //show elemantry school activities
	    	
List<ElementarySchoolActivity> list3 = new ArrayList<ElementarySchoolActivity>(); 
	    	
	    	

	    	try {
			list3=userController.getElementarySchoolActivity();
			} catch (Exception e) {
				e.printStackTrace();
		}
    	
	    	
	    	for (int i = 0; i < list3.size(); i++) {
			(list3.get(i)).showActivityInfo();
			}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	break;
	    	
	    	
	    	
	    case 4: //register to activity by activityID

	    	int activityIDinput;
	    	  System.out.print("Please Enter activityID you want: ");
	    	  activityIDinput = input.nextInt();
	    	  Boolean valid=userController.RegisterUserToAvctivity(user, activityIDinput);
	    	  if(!valid)
	    	  {
	    		  System.out.println("sorry, activity is full");
	    		  break;
	    	  }

    		  System.out.println("registation complete");

    	  System.out.print("____________________________________________\n");

	    	  break;



	    case 5: // show review

	    	
  	int actID;
	    	 System.out.print("Please Enter activityID you want: ");
	    	 actID = input.nextInt();
	    	 List<RatingAndReview> list5 = new ArrayList<RatingAndReview>(); 
		    	
		    	

		    	try {
				list5=userController.getRatingAndReview(actID);
				} catch (Exception e) {
					e.printStackTrace();
			}
	    	
		    	
		    	for (int i = 0; i < list5.size(); i++) {
		    		System.out.println(list5.get(i));
				}	    
		    	
		    	System.out.println("\n\nYou are welcome to write your opinion!\n");
	    	
	    	break;
	        
	    case 6: // insert review

	    	    	
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
		    userController.addRatingAndReview(opinion);
		    
		    
		
		    System.out.println("Excellent! we sure your opinion will help other");
	    	System.out.print("\n_______________________________________________\n");
   	
	    	
	        break;
	        
	    	
	    	
	        
	        
	    case 7: // contact us

	    	 ContactBox contact=new ContactBox();
	    	 System.out.print("how can we help you? ");
			   String text= input.nextLine();   
	    	 input.nextLine();
	    	 contact.setText(text);
	    	 contact.send(user);
	         break;   

	         
	    case 8:  // exit 

	        System.out.println("Exiting Program...");
	        input.close();
	        System.exit(1);
	         break;   
	         
	         
	    default :
	             System.out.println("This is not a valid Menu Option! Please Select Another");
	             break;

	    }
        
	
		
		
		
	}//while(user menu) end
	
	
	
	
	}//user menu end
	
	
	
	
	
	public void adminMenu(Admin admin)
	{
		System.out.println("_______________________________________________ \n");
        System.out.println("Hey admin,please make a choise!\n");
       
        int choice;
	    while(true){
	    		System.out.print("1.) make a report of Users \n");
		        System.out.print("2.) make a report of activities by rating \n");
		        System.out.print("3.) make a report of activities by most subscribe  \n");
		        System.out.print("4.) make a report of registered users by activity ID\n");
		        System.out.print("5.) delete user from Activity\n");
		        System.out.print("6.) delete Activity\n");
		        System.out.print("7.) delete Review\n");
		        System.out.print("8.) Add new activity \n");
		        System.out.print("\n Enter Your Menu Choice: ");

		        choice = input.nextInt();
	
	switch(choice){
	    case 1:
	    	
	List<User> listuser = new ArrayList<User>(); 
	    	
	    	

	    	try {
	    		listuser=adminController.getAllUser();
			} catch (Exception e) {
				e.printStackTrace();
		}
    	
	    	
	    	for (int i = 0; i < listuser.size(); i++) {
			(listuser.get(i)).printUser();
			}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	        
	    	
        	break;

	    case 2: 
	    	
	    	
	    	
	    	
	    	break;


	    case 3:
	    	
	    	
	    	
	    	
	    	
	    	break;
	    	
	    	
	    case 4: 
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	  break;



	    case 5: //delete user from Activity

	    	 String email;
	    	  input.nextLine();
	    	 System.out.print("Please Enter the user's mail : ");
	    	 email = input.nextLine();
	    	 int actID;
	    	 System.out.print("Please Enter Activity Id:   ");
	    	 actID = input.nextInt();
	    	 adminController.deleteUserFromActivity(email, actID);
    	 	 System.out.println("\n"+ email+" has been deleted from this activitiy\n" );

    	  
	    	
	    	break;
	        
	    case 6: //delete Activity

	    	
	    	
	    	
	    	
	    		
	    	 int actID2;
	    	 System.out.print("Please Enter activityID you want to delete: ");
	    	 actID2 = input.nextInt();
	    	 adminController.deleteActiviry(actID2);
	    	 System.out.println("\nActivity "+actID2+" deleted\n");
	    	

	    	
	        break;
	        
	    	
	    	
	        
	        
	    case 7: //delete Review
	    	
	    	
	    	
	    	
	    	 int serial;
	    	 System.out.print("Please Enter review serial you want to delete: ");
	    	 serial = input.nextInt();
	    	 adminController.deleteReview(serial);
	    	 System.out.println("\nreview serial "+serial+" deleted\n");
	         break;   

	         
	    case 8: //Add new activity
	    	
	    	
	    	 Random rand = new Random();
	    	 int activityID= rand.nextInt(5000);
	    	 System.out.println(activityID);
	    	 
	    	 
	    	  String name;
	    	  String location;
	    	  int maxCapicity;
	    	  double price;
	    	  String description;

	    	
	    	
	    	
		    //input.nextLine();
	    	 input.nextLine();
	    	System.out.println("Enter name: ");
	    	name = input.nextLine();
	        System.out.println("Enter location: ");
	        location = input.nextLine();
	        System.out.println("Enter maximum capacity: ");
	        maxCapicity = input.nextInt();
	        System.out.println("Enter price: ");
	        price = input.nextDouble();
	        input.nextLine();
	        System.out.println("Enter description: ");
	        description = input.nextLine();
	       
	        
        
	         Activity activity;	
	         
	    	 String type;

	    	 input.nextLine();

	    	 System.out.print("Please Enter activity type (other/high school/elementary school) : ");
	    	 type = input.nextLine();
	    	 
	    	 activity=adminController.getAvtivity(type);  // using ActivityFactory: Factory Design Pattern 

	    	 activity.setPrice(price);
	    	 activity.setActivityID(activityID);
	    	 activity.setName(name);
	    	 activity.setDescription(description);
	    	 activity.setLocation(location);
	    	 activity.setMaxCapicity(maxCapicity);
	    	 activity.setCurrentCapicity(0);
	    	 
	        if (activity instanceof OtherActivity) {
				
	        	String guide;
	        	String category;
	        	String ageRange;
	        	System.out.println("Enter guide: ");
	        	guide = input.nextLine();
		        System.out.println("Enter category: ");
		        category = input.nextLine();
		        System.out.println("Enter age range : ");
		        ageRange = input.nextLine();

		        ((OtherActivity) activity).setGuide(guide);
		        ((OtherActivity) activity).setCategory(category);
		        ((OtherActivity) activity).setAgeRange(ageRange);
		        
		        adminController.addOtherActivity((OtherActivity) activity);
		        
	        	
	        	break;
	        }
	        	else if(activity instanceof HighSchoolActivity ) {
	        		String teacher;
		        	String profession;
		        	String remote;
		        	int studyUnits;
		        	String exam;
		        	String school;
		        	System.out.println("Enter teacher: ");
		        	teacher = input.nextLine();
			        System.out.println("Enter profession: ");
			        profession = input.nextLine();
			        System.out.println("Is it remote class (yes/no) : ");
			        remote = input.nextLine();
			        System.out.println("Enter number of study Units (1-5): ");
			        studyUnits = input.nextInt();
			        exam = input.nextLine();
			        System.out.println("Is it include Bagrut exam prepration?: ");
			        exam = input.nextLine();
			        System.out.println("Enter the school this relate to : ");
			        school = input.nextLine();

			        ((HighSchoolActivity) activity).setTeacher(teacher);
			        ((HighSchoolActivity) activity).setStudyUnits(studyUnits);
			        ((HighSchoolActivity) activity).setSchoolAssociation(school);
			        ((HighSchoolActivity) activity).setRemoteClass(remote);
			        ((HighSchoolActivity) activity).setProfession(profession);
			        ((HighSchoolActivity) activity).setFinalExam(exam);
			        
			        
			        adminController.addHighSchoolActivity((HighSchoolActivity) activity);
			        
			        
	        	}else if( activity instanceof ElementarySchoolActivity) {
	        		
	        		String teacher;
		        	String profession;
		        	String remote;
		        	String cert;
		        	String trans;
		        	String acces;
		        	System.out.println("Enter teacher: ");
		        	teacher = input.nextLine();
			        System.out.println("Enter profession: ");
			        profession = input.nextLine();
			        System.out.println("Is it remote class (yes/no) : ");
			        remote = input.nextLine();
			        System.out.println("is there a oficial certifiation : ");
			        cert = input.nextLine();
			         
			        System.out.println("Is it include transportation services?: ");
			        trans = input.nextLine();
			        System.out.println("is the activity accessible");
			        acces = input.nextLine();
			        
			        ((ElementarySchoolActivity) activity).setTransport(trans);
			        ((ElementarySchoolActivity) activity).setTeacher(teacher);
			        ((ElementarySchoolActivity) activity).setRemoteClass(remote);
			        ((ElementarySchoolActivity) activity).setProfession(profession);
			        ((ElementarySchoolActivity) activity).setCertification(cert);
			        ((ElementarySchoolActivity) activity).setAccessable(acces);
			       
			        adminController.addElemetarySchoolActivity((ElementarySchoolActivity) activity);


	        	}
	        
	        	
	        
	        
	        

	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	 
	    	 
	    	 
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	         break;   
	         
	         
	    default :
	             System.out.println("This is not a valid Menu Option! Please Select Another");
	             break;

	    }
        
	
		
		
		
	}//while(user menu) end
	   
	    
	    
	    
	    
	    
	    
	    
	   
	    
	    
	}//admin menu end
	
	

		
		
		
		
		
 

	
	
	
	
	
	
	
	
	
	
}//class end
