package com.haut.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ceshi {
public static void main(String[] args) {
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
	Date date = new Date();
	System.out.println(date.toString());
	System.out.println(format.format(date));
}
}
