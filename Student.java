package edu.aydin.oop.termproj1;

import java.util.Scanner;

abstract class Student extends IUniversityPerson {
	private double gno;
	Student(int no,String fn, String ln, double gno) {
		super(no,fn, ln);
		this.gno = gno;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public double getGno() {
		return gno;
	}
	public void setGno(double gno) {
		this.gno = gno;
	}
	
	@SuppressWarnings("resource")
	@Override
	IUniversityPerson takeInsert() {
		this.getInsert();
		System.out.println("Enter GNO: ");
		Scanner get = new Scanner(System.in);
		setGno(get.nextDouble());
		
		return this;
	}
}
