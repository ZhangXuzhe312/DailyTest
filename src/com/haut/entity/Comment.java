package com.haut.entity;

public class Comment {
private int cid;
private int cline;
private String cdetail;
private String cname;
private String cdate;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getCline() {
	return cline;
}
public void setCline(int cline) {
	this.cline = cline;
}
public String getCdetail() {
	return cdetail;
}
public void setCdetail(String cdetail) {
	this.cdetail = cdetail;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCdate() {
	return cdate;
}
public void setCdate(String cdate) {
	
	this.cdate = cdate;
}
public Comment(int cid, int cline, String cdetail, String cname, String cdate) {
	super();
	this.cid = cid;
	this.cline = cline;
	this.cdetail = cdetail;
	this.cname = cname;
	this.cdate = cdate;
}
public Comment() {
	super();
	// TODO Auto-generated constructor stub
}




}
