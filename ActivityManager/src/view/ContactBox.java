package view;

import model.User;

public class ContactBox {

	String text;
	
	
	public void send(User user)
	{
		System.out.println("Your message sent to city.muni@org.il Please check " +user.getEmail()+ " for reply soon!\n");
	}



	public void setText(String text) {
		this.text = text;
	}
	
}