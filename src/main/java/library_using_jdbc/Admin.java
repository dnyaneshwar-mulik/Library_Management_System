package library_jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
	public void adminPage() throws SQLException, IOException {
		Scanner scanner=new Scanner(System.in);
		System.out.println();
		System.out.println("\n.:: Administrator Page ::.");
		System.out.println();
		System.out.println("1. Student details ");
		System.out.println("2. Books record ");
		System.out.println("3. Books Management");
		System.out.println("4. Exit");
		System.out.println();
		int adchoice = scanner.nextInt();
		switch (adchoice) {
		case 1:
			Student studentpageq = new Student();
			studentpageq.studentpage();
			break;
		case 2:
			BookRec bkpg = new BookRec();
			bkpg.bookrec();
			break;
		case 3:
			BookManagement bkmg = new BookManagement();
			bkmg.bookmanagepage();
			break;
			
		case 4:
			WelcomePage adminobj = new WelcomePage();
			adminobj.display();

		default:
			break;
		}
	}
	
}