package edu.aydin.oop.termproj1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class peopleExe {
	
	public static final int FACULTY 	= 0;
	public static final int STAFF 		= 1;
	public static final int GRAD 		= 2;
	public static final int UNDERGRAD 	= 3;


	public static void save(IUniversityPerson person) { // DÝREK ADAMI YOLLUYOZ
		try {
			ArrayList<IUniversityPerson> liste = getList();
			String data = "";
			if (liste != null) {
				for (IUniversityPerson f : liste) { // VAR OLAN DEÐERLERÝ GÖSTER
					data = data + f.write();
				}
			}
			data = data + person.write(); // YENÝ GELEN DEGERÝ YAZ
			FileOutputStream fos = new FileOutputStream("people.bin");
			fos.write(data.getBytes()); // .BIN ÝÇÝN BYTE CEVÝR
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("no file");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<IUniversityPerson> getList() {
		FileInputStream fis;
		ArrayList<IUniversityPerson> list = new ArrayList<IUniversityPerson>();

		try {
			fis = new FileInputStream("people.bin");
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			String data = new String(buffer);
			fis.close();
			if (data.length() >1) { //saçma sapan bi hatadan dolayý
				String[] personStr = data.split("\n");
				for (String d : personStr) {
					IUniversityPerson f = IUniversityPerson.strToPeople(d);
					list.add(f);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean delete(IUniversityPerson delPerson) {
		try {
			ArrayList<IUniversityPerson> people = getList();

			for (IUniversityPerson p : people) { // VAR OLAN LISTEDEN ISTEDIGIMI SILDIM
				if (p.getId() == delPerson.getId() && p.getNo() == delPerson.getNo()) {
					people.remove(p);
					break;	
				}
			}
			String data = ""; // KALAN DATAYI TEKRAR BOÞ DATAYA ATIYORUM SONRA TEKRAR ÝÇÝNE YAZIYORUM
			for (IUniversityPerson f : people) {
				data = data + f.write();
			}
			FileOutputStream fos;
			fos = new FileOutputStream("people.bin");
			fos.write(data.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean delete(int id, int no) {
		try {
			ArrayList<IUniversityPerson> people = getList();

			for (IUniversityPerson p : people) { // VAR OLAN LISTEDEN ISTEDIGIMI SILDIM
				if (p.getId() == id && p.getNo() == no) {
					people.remove(p);
					break;
				}
			}
			String data = ""; // KALAN DATAYI TEKRAR BOÞ DATAYA ATIYORUM SONRA TEKRAR ÝÇÝNE YAZIYORUM
			for (IUniversityPerson f : people) {
				data = data + f.write();
			}
			FileOutputStream fos;
			fos = new FileOutputStream("people.bin");
			fos.write(data.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean update(IUniversityPerson updtPerson, int id, int no) {
		try {
			peopleExe.delete(id, no);
			peopleExe.save(updtPerson);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
