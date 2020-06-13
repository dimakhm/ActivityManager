package Start;

import java.util.Scanner;


import controller.Admin;
import controller.User;
import model.LogInDataManagment;


public class Main {

    boolean exit;

	public static void main(String[] args) throws Exception
	{
		@SuppressWarnings("unused")
		DBconncet db= DBconncet.getConnection();
		Main main=new Main();	
		
		
		main.printHeader();
		  Scanner input = new Scanner(System.in);

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
		    	while(user.getEmail().equals("non"))// the database return an empty user object with "non" email
		    	{
		        System.out.print("Please Enter The mail: ");
		        user.setEmail(input.next()); 
		        System.out.print("\nPlease Enter The password: ");
		        user.setPass(input.next()); 
		        user=User.userlogIn(user.getEmail(),user.getPassword());
		        }
		    	User.userMenu(user);// code after User log in
		    	
	        	break;

		    case 2: 
		    	Boolean loop=false;
		    	while(!loop)
		    	{
		    	String email2, pass2;
		        System.out.print("Please Enter The mail: ");
		        email2 = input.next();
		        System.out.print("\nPlease Enter The password: ");
		        pass2 = input.next();
		        loop=Admin.adminlogIn(email2,pass2);}
		    	Admin.adminMenu();
		        break; // code Admin User log in
		    	

		    case 3:

		    	User newUser=new User();
		        // Gather Input
		        System.out.println("enter email ");
		        newUser.setEmail(input.next());
		        System.out.println("enter pass ");
		        newUser.setPass(input.next());
		        System.out.println("enter name ");
		        newUser.setName(input.next());
		        System.out.println("enter phone ");
		        newUser.setPhone(input.next());
		        
		        LogInDataManagment.SingUpUserToDataBase(newUser);
		        
		    	User.userMenu(newUser);// send to User Menu

		        
		        // This will Multiply the Numbers

		        User.userMenu(newUser);
		        break;

		   

		    case 4: 
		        System.out.println("Exiting Program...");
		        input.close();
		        System.exit(1);
		         break;
		    default :
		             System.out.println("This is not a valid Menu Option! Please Select Another");
		             break;

		    }


		    }

		    
		    


		    

		   
		
	}// Main end
	
	
	
	
	


	private void printHeader() {

        System.out.println("+-----------------------------------+");
        System.out.println("|      Welcome to Activity          |");
        System.out.println("|        Manager Java App           |");
        System.out.println("+-----------------------------------+");
    }
	
	
	
	
}//Class end
