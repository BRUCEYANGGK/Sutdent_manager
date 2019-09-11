package mybean;

import java.util.ArrayList;
import java.util.List;

public class GetStudent {
private List<StudentMessage> list =new ArrayList<StudentMessage>();
public void GetStudent() {
	this.list=null;
}
public List<StudentMessage> getList() {
	return list;
}
public void setList(List<StudentMessage> list) {
	this.list = list;
}

}
