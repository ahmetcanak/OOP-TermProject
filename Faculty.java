package edu.aydin.oop.termproj1;

class Faculty extends IUniversityPerson {
	private static final int id = 0;

	Faculty(int no, String fn, String ln) {
		super(no, fn, ln);
	}
	
	public Faculty() {
		// TODO Auto-generated constructor stub
	}

	String write() {

		return getId() + "%" + getNo() + "%" + getFname() + "%" + getLname() + "\n";
	}

	IUniversityPerson read() {

		return null;
	}
	
	public int getId() {
		return Faculty.id;
	}
	
	public String getInfo() {
		return getId()+"_"+getMainInfo();
	}

	@Override
	IUniversityPerson takeInsert() {
		this.getInsert();
		return this;
	}
	
}