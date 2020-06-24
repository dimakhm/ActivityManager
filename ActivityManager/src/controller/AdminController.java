package controller;


import java.sql.SQLException;

import model.ActivityRepository;
import model.LogInRepository;
import model.RatingAndReviewRepository;
import view.Admin;


public class AdminController
{
	RatingAndReviewRepository ratingAndReviewRepository;
	LogInRepository logInRepository;
	ActivityRepository activityRepository;

	public AdminController()
	{
		this.ratingAndReviewRepository=new RatingAndReviewRepository();
		this.activityRepository=new ActivityRepository();
		this.logInRepository=new LogInRepository();
	}

	public Admin signIn(Admin admin) {
		
		try {
			admin=logInRepository.adminlogIn(admin.getEmail(),admin.getPassword());
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return admin;
		
	}

	public void deleteActiviry(int activityID) {
		
		try {
			activityRepository.deleteActivity(activityID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	public void deleteUserFromActivity(String email, int activityID) {

		try {
			activityRepository.deleteUserFromActivity(email, activityID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void deleteReview(int SerialNumber ) {

		try {
			ratingAndReviewRepository.deleteReview(SerialNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
		
	}// class end
	
	



	

