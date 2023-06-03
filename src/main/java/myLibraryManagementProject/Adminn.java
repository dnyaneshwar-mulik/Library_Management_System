package myLibraryManagementProject;

import java.util.Scanner;

public class Adminn {
	
	String adminId = "root";
	String adminPass = "123";

	Scanner sc = new Scanner(System.in);
	
	Studentsn objStudents = new Studentsn();
	Booksn objBooks = new Booksn();
	
	public void signUp() {
		System.out.println(".:: Signup Page ::.");
	    System.out.print("Enter your username ");
	    String a = sc.next();
	    System.out.print("Enter your password ");
	    String b = sc.nextLine();
	    System.out.println("Sign up successful ");
	  }

	public void login() {
		System.out.println(".:: Login Page ::.");
		System.out.println("Enter username ");
		String a = sc.nextLine();

		System.out.println("Enter Password = ");
		String b = sc.nextLine();

		if (adminId.equals(a) && adminPass.equals(b)) {
			System.out.println();
			System.out.println(a+"Successfully logged in");
			System.out.println();
			adminPage();
		} else {
			System.out.println("Incorrect id & password, please enter corrrect credintials");
		}
	}

	public void adminPage() {
		System.out.println();
		System.out.println(".:: Administrator Page ::.");
		System.out.println();
		System.out.println("1. Student details ");
		System.out.println("2. Books record ");
		System.out.println("3. Manage Books");
		System.out.println("4. Exit");
		System.out.println("Enter your choice");
		System.out.println();

		int c = sc.nextInt();
		
		switch (c)
		{
		case 1:
			System.out.println(".:: Student Page ::.");
			System.out.println();
			System.out.println("1. Add Students info");
			System.out.println("2. Display students details");
			System.out.println("3. Exit");
			System.out.println("enter an option from below");
			
			int d=sc.nextInt();
				switch (d) 
				{
				case 1: 
					objStudents.studentAdd();
					adminPage();
					break;
				
				case 2:
					objStudents.showStudents();
					adminPage();
					break;
				
				case 3:
					break;
				}
			
		case 2:
			System.out.println(".:: Book Page ::.");
			System.out.println();
			System.out.println("1. add books");
			System.out.println("2. dsiplay list of books");
			System.out.println("3. exit");
			System.out.println("enter your option");
			int e=sc.nextInt();
			switch (e) {
			case 1: objBooks.addBooks();
			adminPage();
			break;
				
			case 2: objBooks.showBooks();
			adminPage();
			break;
			
			case 3:
			adminPage();
			break;
			}
			break;
		
		case 3:
			System.out.println(".:: Book Management ::.");
			System.out.println();
			System.out.println("enter any option");
			System.out.println("1. issue books");
			System.out.println("2. return books");
			System.out.println("3. exit");
			
			int f=sc.nextInt();
			switch (f) {
			case 1: objBooks.issueBooks();
			adminPage();
			break;
			case 2: objBooks.returnBooks();
			adminPage();
			break;
			}
		break;
		}
	}

}
