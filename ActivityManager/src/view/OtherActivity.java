package view;


public class OtherActivity extends Activity{
	
	
	

	// attributes
	private String guide;
	private String category;
	private String ageRange;
	
	
	// C'tor + get\set
	
	public OtherActivity(int activityID)
	{
		this.activityID=activityID;
	}
	
	
	@Override
	public String toString() {
		return "OtherActivity [guide=" + guide + ", category=" + category + ", ageRange=" + ageRange + ", activityID="
				+ activityID + ", name=" + name + ", location=" + location + ", currentCapicity=" + currentCapicity
				+ ", maxCapicity=" + maxCapicity + ", price=" + price + ", description=" + description + "]";
	}


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

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
	public OtherActivity( ) 
	{
		super();
		guide = "non";
		category = "non";
		ageRange = "non";
	}
	
	public OtherActivity(int activityID, String name, String location, int currentCapicity, int maxCapicity, double price,
			String description, String guide,String categorty,String ageRange) 
	{
		super(activityID,name, location, currentCapicity,maxCapicity, price, description);
		this.guide=guide;
		this.category=categorty;
		this.ageRange=ageRange;
	}
	
	// methods

	public void showActivityInfo() {
		System.out.println("Activity ID: "+this.activityID+"	"+"Name: "+this.name+"	"+"price: "+this.price+"	"+"info: "+this.description);
	}
	
	public void prerequisites() {
		System.out.println("Please check you have all the needed equipment");
	}

}
