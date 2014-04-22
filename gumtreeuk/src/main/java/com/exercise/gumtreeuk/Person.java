package com.exercise.gumtreeuk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
	
	private String name;
	private String surname;
	private boolean male;
	private Date birthday;
	
	public Person (String fullname,String gender,String birth){
		//get name and surname
		String [] fname=fullname.split(" ");
		this.name=fname[0];
		this.surname=fname[1];
		//get gender
		this.male="male".equals(gender.trim().toLowerCase());
		//get birthday
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		try {
			this.birthday=format.parse(birth.trim());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
