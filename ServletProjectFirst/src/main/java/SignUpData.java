
public class SignUpData {
	
	private String name, password, email, mobile, dob;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public SignUpData(String name, String password, String email, String mobile, String dob) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.dob = dob;
	}

	public SignUpData() {
	
	}
	

}
