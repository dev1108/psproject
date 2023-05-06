
public class NewUser {
	
	private String name;
	private String email;
	private String mobile_number;
	
	public NewUser() {
		
	}
	
	public NewUser(String name, String email, String mobile_number) {
		this.name = name;
		this.email = email;
		this.mobile_number = mobile_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	@Override
	public String toString() {
		return "NewUser [name=" + name + ", email=" + email + ", mobile_number=" + mobile_number + "]";
	}
	
	

}
