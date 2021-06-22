package edu.aydin.oop.termproj1;


class Grad extends Student  {
	public static final int id = peopleExe.GRAD;

	Grad(int no, String fn, String ln, double gno) {
		super(no,fn, ln, gno);
	}
	
	public Grad() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getId() {
		return Grad.id;
	}
	
	@Override
	String write() {
		return getId() + "%" + getNo() + "%" + getFname() + "%" + getLname() +"%"+getGno()+"\n";

	}
	@Override
	public String getInfo() {
		return getId()+"_"+getMainInfo() +"+" +getGno();
	}
	@Override
	IUniversityPerson read() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
