package edu.aydin.oop.termproj1;

import java.util.Scanner;

abstract class IUniversityPerson {
	private int no;
	private String fname, lname;

	public static IUniversityPerson strToPeople(String d) {
		IUniversityPerson result = null;
		String[] pStr = d.split("%");
		if (Integer.parseInt(pStr[0]) == 0) {
			result = new Faculty(Integer.parseInt(pStr[1]), pStr[2], pStr[3]);
		} else if (Integer.parseInt(pStr[0]) == 1) {
			result = new Staff(Integer.parseInt(pStr[1]), pStr[2], pStr[3], pStr[4]);
		} else if (Integer.parseInt(pStr[0]) == 2) {
			result = new Grad(Integer.parseInt(pStr[1]), pStr[2], pStr[3], Double.parseDouble(pStr[4]));
		} else if (Integer.parseInt(pStr[0]) == 3) {
			result = new UnderGrad(Integer.parseInt(pStr[1]), pStr[2], pStr[3], Double.parseDouble(pStr[4]));
		}

		return result;
	}
	IUniversityPerson(){
		
	}
	IUniversityPerson(int no, String fn, String ln) {
		this.no = no;
		fname = fn;
		lname = ln;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	abstract String write();

	abstract int getId();

	abstract IUniversityPerson read();

	abstract String getInfo();
	
	abstract IUniversityPerson takeInsert();

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMainInfo() {
		return getNo() + "_" + getFname() + "_" + getLname();
	}

	@SuppressWarnings("resource")
	public void getInsert() {
			
			Scanner get = new Scanner(System.in);
			System.out.println("Enter Number: ");
			setNo(get.nextInt()) ;
			System.out.println("Enter First Name: ");
			setFname(get.next());
			System.out.println("Enter Last Name: ");
			setLname(get.next());
			
		}
}
