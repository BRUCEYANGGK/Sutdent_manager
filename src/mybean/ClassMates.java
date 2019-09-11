package mybean;

import java.util.ArrayList;
import java.util.List;

public class ClassMates {
private String classNumber;
private String studentName;
private String studentNumber;
private String backNews="";
private List<ClassMates> list = new ArrayList<ClassMates>();
public ClassMates() {
	
}
public String getClassNumber() {
	return classNumber;
}
public void setClassNumber(String classNumber) {
	this.classNumber = classNumber;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentNumber() {
	return studentNumber;
}
public void setStudentNumber(String studentNumber) {
	this.studentNumber = studentNumber;
}
public String getBackNews() {
	return backNews;
}
public void setBackNews(String backNews) {
	this.backNews = backNews;
}
public List getList() {
	return list;
}
public void setList(List list) {
	this.list = list;
}

}
