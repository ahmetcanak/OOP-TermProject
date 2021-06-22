package edu.aydin.oop.termproj1;

class UnderGrad extends Student {
	public static final byte id = 3;

	UnderGrad(int no, String fn, String ln, double gno) {
		super(no, fn, ln, gno);
	}

	public UnderGrad() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getId() {
		return UnderGrad.id;
	}

	@Override
	public String getInfo() {
		return getId() + "_" + getMainInfo() + "+" + getGno();
	}

	@Override
	String write() {
		return getId() + "%" + getNo() + "%" + getFname() + "%" + getLname() + "%" + getGno() + "\n";
	}

	@Override
	IUniversityPerson read() {
		// TODO Auto-generated method stub
		return null;
	}
}
