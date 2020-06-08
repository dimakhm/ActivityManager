package view;

public class OtherActivity extends Activity{
	
	
	

	// attributes
	private String guide;
	private String category;
	private int ageRange;
	
	
	// C'tor + get\set
	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(int ageRange) {
		this.ageRange = ageRange;
	}
	public OtherActivity( ) 
	{
		super();
		guide = "non";
		category = "non";
		ageRange = 1;
	}
	
	public OtherActivity(int activityID, String name, String location, int currentCapicity, int maxCapicity, int price,
			String description, String guide,String categorty,int ageRange) 
	{
		super(activityID,name, location, currentCapicity,maxCapicity, price, description);
		this.guide=guide;
		this.category=categorty;
		this.ageRange=ageRange;
	}
	
	// methods

	public void showActivityInfo() {
		// TODO Auto-generated method stub

	}
	
	public void prerequisites() {
		// TODO Auto-generated method stub

	}
	
}
