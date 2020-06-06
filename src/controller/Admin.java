package controller;

import java.util.Scanner;
import model.LogInDataManagment;

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
	public static void adminMenu() {
		  Scanner input = new Scanner(System.in);
		   // boolean mainLoop = true; לא יודע מה זה עושה.. למחוק אולי

		    int choice;
		    while(true){
		        System.out.println("_____________________________ \n");
		        System.out.print("1.) make a report of activities \n");
		        System.out.print("2.) .\n");
		        System.out.print("3.) .....\n");
		        System.out.print("4.) .....\n");
		        System.out.print("5.) ......\n");
		        System.out.print("6.) Exit\n");
		        System.out.print("\nEnter Your Menu Choice: ");

		        choice = input.nextInt();




		    switch(choice){

		    case 1:
		    	System.out.println("football");
		        
		    	
	        	break;// code after User log in

		    case 2: 
		    	System.out.println("football");
	        	break;// code after User log in


		    case 3:
		    	System.out.println("football");

	        	break;// code after User log in

		    case 4: 
		    	System.out.println("football");
	        	break;// code after User log in


		    case 5:
		    	System.out.println("football");

		        break;

		    case 6: 
		        System.out.println("Exiting Program...");
		        input.close();
		        System.exit(1);;
		         break;
		    default :
		             System.out.println("This is not a valid Menu Option! Please Select Another");
		             break;

		    }
		    }
	}//menu end
	
	
}// class end


