package model;

public class RatingAndReview {


		// attributes

		private double rating;
		private String review;
		private int activityID;
		
		// getters and setters
		
		public double getRating() {
			return rating;
		}
		public int getActivityID() {
			return activityID;
		}
		public  boolean setRating(double ratingInput) {
			if (ratingInput>10 || ratingInput<10 ) {
				return false;
			}
			this.rating = ratingInput;
			return true;
		}
		public String getReview() {
			return review;
		}
		public void setReview(String review) {
			this.review = review;
		}

		public void setActivityID(int activityID) {
			this.activityID = activityID;
		}
		@Override
		public String toString() {
			return ("Rating: "+this.rating+"	"+"Review: "+this.review);
		}
		
		// con't
		
		public RatingAndReview() {
			activityID=0;
			review = "non";
			rating = 0;
		}
		
		public RatingAndReview(int activityID,String review, double rating) {
			this.activityID= activityID;
			this.review = review;
			this.rating = rating;
		}
		
	}
	
	
	
	

