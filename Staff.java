package edu.aydin.oop.termproj1;

import java.util.Scanner;

class Staff extends IUniversityPerson {
	public static final int id = 1;
	private String phoneNo;

	Staff(int no, String fn, String ln, String phoneNo) {
		super(no, fn, ln);
		this.setPhoneNo(phoneNo);
	}

	public Staff() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	String write() {
		return getId() + "%" + getNo() + "%" + getFname() + "%" + getLname() + "%" + getPhoneNo() + "\n";

	}

	@Override
	IUniversityPerson read() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getId() {
		return Staff.id;
	}

	public String getInfo() {
		return getId() + "_" + getMainInfo() + "+" + getPhoneNo();
	}

	@SuppressWarnings("resource")
	@Override
	IUniversityPerson takeInsert() {
		this.getInsert();
		System.out.println("Enter Phone Number: ");
		Scanner get = new Scanner(System.in);
		setPhoneNo(get.next());
		
		
		return this;
	}

}
