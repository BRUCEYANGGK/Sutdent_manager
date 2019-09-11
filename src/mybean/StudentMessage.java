package mybean;

public class StudentMessage {
private String StudentNumber;
private String StudentName;
private String StudentSex;
private String StudentID;
private String StudentAddress;
private String StudentApartment;
private String StudentAcademy;
private String StudentMajor;
private String StudentClass;
private String backNews;
public StudentMessage(String studentNumber2, String studentName2, String studentSex2, String studentID2,
		String studentAddress2, String studentApartment2, String studentAcademy2, String studentMajor2,
		String studentClass2) {
	// TODO Auto-generated constructor stub
	this.StudentNumber=studentNumber2;
	this.StudentName=studentName2;
	this.StudentSex=studentSex2;
	this.StudentID=studentID2;
	this.StudentAddress=studentAddress2;
	this.StudentApartment=studentApartment2;
	this.StudentAcademy=studentApartment2;
	this.StudentMajor=studentMajor2;
	this.StudentClass= studentClass2;
}
public void StudentMessage() {
	this.StudentNumber=null;
	this.StudentName=null;
	this.StudentSex=null;
	this.StudentID=null;
	this.StudentAddress=null;
	this.StudentApartment=null;
	this.StudentAcademy=null;
	this.StudentMajor=null;
	this.StudentClass= null;
}
public String getStudentNumber() {
	return StudentNumber;
}
public void setStudentNumber(String studentNumber) {
	StudentNumber = studentNumber;
}
public String getStudentName() {
	return StudentName;
}
public void setStudentName(String studentName) {
	StudentName = studentName;
}
public String getStudentSex() {
	return StudentSex;
}
public void setStudentSex(String studentSex) {
	StudentSex = studentSex;
}
public String getStudentID() {
	return StudentID;
}
public void setStudentID(String studentID) {
	StudentID = studentID;
}
public String getStudentAddress() {
	return StudentAddress;
}
public void setStudentAddress(String studentAddress) {
	StudentAddress = studentAddress;
}
public String getStudentApartment() {
	return StudentApartment;
}
public void setStudentApartment(String studentApartment) {
	StudentApartment = studentApartment;
}
public String getStudentAcademy() {
	return StudentAcademy;
}
public void setStudentAcademy(String studentAcademy) {
	StudentAcademy = studentAcademy;
}
public String getStudentMajor() {
	return StudentMajor;
}
public void setStudentMajor(String studentMajor) {
	StudentMajor = studentMajor;
}
public String getStudentClass() {
	return StudentClass;
}
public void setStudentClass(String studentClass) {
	StudentClass = studentClass;
}
public String getBackNews() {
	return backNews;
}
public void setBackNews(String backNews) {
	this.backNews = backNews;
}

}
