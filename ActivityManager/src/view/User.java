package view;


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
		@Override
		public String toString() {
			return "User [name=" + name + ", phone=" + phone + ", email=" + email + ", password=" + password
					+ ", getName()=" + getName() + ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail()
					+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ ", toString()=" + super.toString() + "]";
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

}
