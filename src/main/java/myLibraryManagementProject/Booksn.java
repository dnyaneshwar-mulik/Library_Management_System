package myLibraryManagementProject;

import java.util.Scanner;

public class Booksn extends Studentsn {

	int total_Books = 3;
	String[] bName = new String[total_Books];

	Scanner sc = new Scanner(System.in);
	Studentsn objStudents = new Studentsn();

	public void addBooks() {
		System.out.println(".:: Add Books ::.");
		for (int i = 0; i < total_Books; i++) {
			System.out.println("enter book name");
			bName[i] = sc.next();
		}
		System.out.println();
		System.out.println("books added");
	}

	public void showBooks() {

		System.out.println("Books available in library");

		for (int j = 0; j < total_Books; j++) {
			System.out.println(j + 1 + "> " + bName[j]);
		}

	}

	public void issueBooks() {

		System.out.println("issue book to student");

		System.out.println("enter stud roll no. and book name");
		int issue_std = sc.nextInt();
		String issue_book = sc.next();
		//for (int j = 0; j < total_Books; j++) {
			//if (bName[j].equals(issue_book)) {
			//	for (int k = j; k < total_Books; k++) {
			//		bName[k] = bName[k + 1];
			//	}
			System.out.println("book "+issue_book+" issued to "+issue_std);
			//} else {
			//	System.out.println("book unavailable");
			//}
		//}
	}

	public void returnBooks() {

		System.out.println("return book to library");
		System.out.println("enter stud roll no.");
		int issue_std = sc.nextInt();

		System.out.println("enter book name");
		String issue_book = sc.next();

		System.out.println("roll number " + issue_std + "submitted " + issue_book + " this book to library");
	}
}
