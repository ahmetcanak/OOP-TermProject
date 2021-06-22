package edu.aydin.oop.termproj1;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

@SuppressWarnings("resource")
public class TermProject1 {

	public static void main(String[] args) {
		mainmenu();
	}

	static boolean login() {
		try {
			Scanner keyIn = new Scanner(System.in);
			System.out.println("please enter your user name: ");
			String uname = keyIn.next();
			System.out.println("please enter your password: ");
			String upass = keyIn.next();

			Scanner inFile = new Scanner(new File("users.txt"));
			while (inFile.hasNextLine()) {
				String line = inFile.nextLine(); // satýr atlýyor yani up[0] deðiþmesine gerek yok. her zaman ilk
				String[] up = line.split(":"); // elemaný alýyor.
				if (up[0].equals(uname) && up[1].equals(upass)) {
					System.out.println("succesfully login.");
					return true;
				}
			}
			System.out.println("user, password does not match.");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error has been accored.");
			return false;
		}
	}

	static boolean register() {
		try {
			Scanner keyIn = new Scanner(System.in);
			String users = "";
			Scanner inFile = new Scanner(new File("users.txt"));
			while (inFile.hasNextLine()) {
				users = users + inFile.nextLine();
			}
			System.out.println("please enter your user name: ");
			String uname = keyIn.next();
			System.out.println("please enter your password: ");
			String upass = keyIn.next();
			users = users + "\n" + uname + ":" + upass;
			FileOutputStream fos = new FileOutputStream("users.txt");
			fos.write(users.getBytes()); // .BIN ÝÇÝN BYTE CEVÝR
			fos.close();
			mainmenu();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error has been accored.");
			return false;
		}
	}

	public static boolean mainmenu() {
		int logreg = 0;
		Scanner logget = new Scanner(System.in);
		System.out.println("\n\tWelcome to the University Data Storage");
		System.out.println("1. Login");
		System.out.println("2. Register");
		logreg = logget.nextInt();
		if (logreg == 1) {

			if (login()) { // true gelirse calýsacak.
				System.out.println("\tThis program contains the data of Faculty, Staff and Students data.");
				System.out.println("\tYou can access the data and make some arrangements on data.");
				System.out.println("\tSuch as;");
				System.out.println("\t1. Display whole data list.");
				System.out.println("\t2. Add a person to the list.");
				System.out.println("\t3. Update a data of a person from the list.");
				System.out.println("\t4. Remove a data of a person from the list.");
				System.out.println("\n\tChoose by typing their line number.");
				int choose = 0;
				Scanner get = new Scanner(System.in);
				choose = get.nextInt();
				if (choose == 1) {
					peopleControl.peopleDisplay();
				} else if (choose == 2) {
					peopleControl.peopleInsert();
				} else if (choose == 3) {
					peopleControl.peopleUpdate();
				} else if (choose == 4) {
					peopleControl.peopleRemove();
				}
			} else {
				System.out.println("Want to try again?");
				System.out.println("1. Try Again.");
				System.out.println("2. EXIT");
				Scanner get = new Scanner(System.in);
				int choose = get.nextInt();
				if (choose != 1) {
					(new Scanner(System.in)).close();
					System.exit(1);
				}
			}
			(new Scanner(System.in)).close();
			System.exit(1);
		} else if (logreg == 2) {
			register();
		}
		return false;
	}
}
