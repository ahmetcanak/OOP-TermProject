package edu.aydin.oop.termproj1;

import java.util.Scanner;

@SuppressWarnings("resource")

public class peopleControl {
	public static boolean peopleInsert() {
		int choose = 99;
		System.out.println("What type of person will you add?");
		System.out.println("0. FACULTY");
		System.out.println("1. STAFF");
		System.out.println("2. GRAD");
		System.out.println("3. UNDERGRAD");
		Scanner get = new Scanner(System.in);

		choose = get.nextInt();
		if (choose == peopleExe.FACULTY) {
			peopleExe.save(new Faculty().takeInsert());
		} else if (choose == peopleExe.STAFF) {
			peopleExe.save(new Staff().takeInsert());
		} else if (choose == peopleExe.GRAD) {
			peopleExe.save(new Grad().takeInsert());
		} else if (choose == peopleExe.UNDERGRAD) {
			peopleExe.save(new UnderGrad().takeInsert());
		}
		peopleMenu();
		return false;
	}

	public static boolean peopleUpdate() {

		int choose = 99;
		System.out.println("What type of person will you update?");
		System.out.println("0. FACULTY");
		System.out.println("1. STAFF");
		System.out.println("2. GRAD");
		System.out.println("3. UNDERGRAD");
		Scanner get = new Scanner(System.in);
		choose = get.nextInt();
		for (IUniversityPerson f : peopleExe.getList()) {
			if (f.getId() == choose)
				System.out.println(f.getInfo());
		}
		System.out.println("Which person you want to update?");
		System.out.println("Enter number.");
		int tnum = get.nextInt();
		if (choose == peopleExe.FACULTY) {
			peopleExe.update((new Faculty().takeInsert()), peopleExe.FACULTY, tnum);
		} else if (choose == peopleExe.STAFF) {
			System.out.println("What is new phone number?");
			peopleExe.update((new Staff().takeInsert()), peopleExe.STAFF, tnum);

		} else if (choose == peopleExe.GRAD) {
			peopleExe.update((new Grad().takeInsert()), peopleExe.GRAD, tnum);

		} else if (choose == peopleExe.UNDERGRAD) {
			peopleExe.update((new UnderGrad().takeInsert()), peopleExe.UNDERGRAD, tnum);
		}
		System.out.println("\tYou can see the new list below.");
		for (IUniversityPerson f : peopleExe.getList()) {
			System.out.println(f.getInfo());
		}
		peopleMenu();
		return false;
	}

	public static boolean peopleRemove() {
		int choose = 99;
		System.out.println("What type of person will you remove?");
		System.out.println("0. FACULTY");
		System.out.println("1. STAFF");
		System.out.println("2. GRAD");
		System.out.println("3. UNDERGRAD");
		Scanner get = new Scanner(System.in);
		choose = get.nextInt();
		System.out.println("\tYou can see the list below.");
		for (IUniversityPerson f : peopleExe.getList()) {
			if (f.getId() == choose)
				System.out.println(f.getInfo());
		}
		System.out.println("Which person you want to remove?");
		System.out.println("Enter number.");
		int tnum = get.nextInt();

		if (choose == peopleExe.FACULTY) {
			peopleExe.delete(peopleExe.FACULTY, tnum);
		} else if (choose == peopleExe.STAFF) {
			peopleExe.delete(peopleExe.STAFF, tnum);

		} else if (choose == peopleExe.GRAD) {
			peopleExe.delete(peopleExe.GRAD, tnum);

		} else if (choose == peopleExe.UNDERGRAD) {
			peopleExe.delete(peopleExe.UNDERGRAD, tnum);

		}
		peopleMenu();
		return false;
	}

	public static boolean peopleDisplay() {
		Scanner get = new Scanner(System.in);
		int choose = 0;
		int choose2 = 0;
		System.out.println("Do you want to display only one type?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		choose2 = get.nextInt();
		if (choose2 == 1) {
			System.out.println("Which type?");
			System.out.println("0. Faculty");
			System.out.println("1. Staff");
			System.out.println("2. Grad");
			System.out.println("3. Undergrad");
			choose = get.nextInt();

			if (choose == 0) {
				for (IUniversityPerson f : peopleExe.getList()) {
					if (f.getId() == peopleExe.FACULTY)
						System.out.println(f.getInfo());
				}
			} else if (choose == 1) {
				for (IUniversityPerson f : peopleExe.getList()) {
					if (f.getId() == peopleExe.STAFF)
						System.out.println(f.getInfo());
				}
			} else if (choose == 2) {
				for (IUniversityPerson f : peopleExe.getList()) {
					if (f.getId() == peopleExe.GRAD)
						System.out.println(f.getInfo());
				}
			} else if (choose == 3) {
				for (IUniversityPerson f : peopleExe.getList()) {
					if (f.getId() == peopleExe.UNDERGRAD)
						System.out.println(f.getInfo());
				}
			}
		}

		if (choose2 == 2) {
			for (IUniversityPerson f : peopleExe.getList()) {
				System.out.println(f.getInfo());
			}
		}
		peopleMenu();
		return false;
	}

	public static boolean peopleMenu() {
		System.out.println("\tYou have returned to menu.;");
		System.out.println("\t1. Display whole data list.");
		System.out.println("\t2. Add a person to the list.");
		System.out.println("\t3. Update a data of a person from the list.");
		System.out.println("\t4. Remove a data of a person from the list.");
		System.out.println("\t5. EXIT");
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
		} else if (choose == 5) {
			System.exit(1);
		}
		peopleMenu();
		return false;
	}

}
