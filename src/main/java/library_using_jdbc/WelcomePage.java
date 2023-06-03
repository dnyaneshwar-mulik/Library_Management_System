package library_jdbc;

import java.io.IOException;
import java.security.PublicKey;
import java.sql.SQLException;
import java.util.Scanner;

public class WelcomePage {
	public void display() throws SQLException, IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println(".:: Welcome to Library Management System ::.");
		System.out.println("1. Sign Up");
		System.out.println("2. Sign In");
		System.out.println("3. Exit");

		int a = scanner.nextInt();
		switch (a) {
		case 1:
			WelcomePage wPage = new WelcomePage();
			wPage.signup();
			break;

		case 2:
			WelcomePage wPage2 = new WelcomePage();
			wPage2.signin();
			break;

		case 3:
			break;

		default:
			System.out.println("invalid choice");
			break;
		}
	}

	public void signup() throws SQLException, IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.println(".:: Admin Signup Page ::.");
		System.out.println("enter id");
		int id = scanner.nextInt();
		System.out.println("enter name");
		String nameString = scanner.next();
		System.out.println("enter email");
		String emailString = scanner.next();
		System.out.println("enter password");
		String passwordString = scanner.next();

		System.out.println(nameString + " sign up successful \n");

		WelcomePage signin = new WelcomePage();
		signin.display();

	}

	public void signin() throws SQLException, IOException {
		Scanner scanner = new Scanner(System.in);
		String emailString = "admin@mail.com";
		String passwordString = "admin123";

		System.out.println("\n.:: Login Page ::.");
		System.out.println("\nEnter Email =");
		String a = scanner.nextLine();
		System.out.println("\nEnter Password = ");
		String b = scanner.nextLine();

		if (a.equalsIgnoreCase(emailString) && b.equalsIgnoreCase(passwordString)) {
			System.out.println(a + "\nSuccessfully Signed in");

			Admin ad = new Admin();
			ad.adminPage();
		} else {
			System.out.println("\nIncorrect email/password");
			WelcomePage signin1 = new WelcomePage();
			signin1.signin();

		}
	}

	public static void main(String[] args) throws SQLException, IOException {
		WelcomePage disp = new WelcomePage();
		disp.display();
	}

}
