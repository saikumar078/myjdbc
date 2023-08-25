package com.jsp.Dto;

public class Student {
private int id;
private String name;
private long mblNo;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getMblNo() {
	return mblNo;
}
public void setMblNo(long mblNo) {
	this.mblNo = mblNo;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", mblNo=" + mblNo + "]";
}

}
