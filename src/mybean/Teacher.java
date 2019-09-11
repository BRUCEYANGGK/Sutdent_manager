package mybean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruce
 *
 */
public class Teacher {
private String teacherNumber;
private String teacherName;
private String academyName;
private String backNews;
private List<Teacher> list = new ArrayList<Teacher>();
public void Teacher() {
	
}
public String getTeacherNumber() {
	return teacherNumber;
}
public void setTeacherNumber(String teacherNumber) {
	this.teacherNumber = teacherNumber;
}
public String getTeacherName() {
	return teacherName;
}
public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
}
public String getBackNews() {
	return backNews;
}
public void setBackNews(String backNews) {
	this.backNews = backNews;
}
public String getAcademyName() {
	return academyName;
}
public void setAcademyName(String academyName) {
	this.academyName = academyName;
}
public List<Teacher> getList() {
	return list;
}
public void setList(List<Teacher> list) {
	this.list = list;
}

}
