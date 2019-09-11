package mybean;

public class Login {
	private String StuNumber;
	private String StuName;
	private String password;
	private String backNews;
	private boolean success=false;
	public void Login() {
		
	}
	public String getStuNumber() {
		return StuNumber;
	}
	public void setStuNumber(String stuNumber) {
		StuNumber = stuNumber;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBackNews() {
		return backNews;
	}
	public void setBackNews(String backNews) {
		this.backNews = backNews;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
