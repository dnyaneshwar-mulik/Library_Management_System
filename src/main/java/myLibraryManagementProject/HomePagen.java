package myLibraryManagementProject;

import java.util.Scanner;

public class HomePagen {

	Scanner sc = new Scanner(System.in);

	Adminn objAdmin = new Adminn();

	public void display() {
		System.out.println(".:: Welcome to Library Management System ::.");
		System.out.println("1. Login");
		System.out.println("2. Sign up");
		System.out.println("3. Exit");
		System.out.println("enter your choice");
		System.out.println();
		int a = sc.nextInt();
		switch (a) {
		case 1:
			objAdmin.login();
			display();
			break;

		case 2:
			objAdmin.signUp();
			display();
			break;

		case 3:
			break;
		default:
	        System.out.println("Invalid choice. Please try again.");
	        break;
		}
	}

}
