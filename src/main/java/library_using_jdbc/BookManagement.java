package library_jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.text.View;

import com.mysql.cj.jdbc.Driver;

public class BookManagement {
	Scanner scanner = new Scanner(System.in);
	public void bookmanagepage() throws SQLException, IOException {
		
		System.out.println(".:: Book Statistics ::.");
		System.out.println("1. issue book");
		System.out.println("2. view issued book");
		System.out.println("3. return book");
		System.out.println("4. view returned books");
		System.out.println("5. exit ");
		int bmc  = scanner.nextInt();
		switch (bmc) {
		case 1:
			BookManagement issueadd = new BookManagement();
			issueadd.issuebooksmethod();
			issueadd.bookmanagepage();
			break;
		
		case 2:
			BookManagement issueview = new BookManagement();
			issueview.Viewissuedbooks();
			issueview.bookmanagepage();
			break;
			
		case 3:
			BookManagement returnbook = new BookManagement();
			returnbook.returnbooksmethod();
			returnbook.bookmanagepage();
			break;
			
		case 4:
			BookManagement viewreturn = new BookManagement();
			viewreturn.Viewreturnedbooks();
			viewreturn.bookmanagepage();

		case 5:
			Admin b2a = new Admin();
			b2a.adminPage();
			break;
		default:
			System.out.println("invalid choice");
			break;
		}
	}
	public Connection getConnection() throws SQLException, IOException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Connection connection = DriverManager.getConnection(
				properties.getProperty("url"),
				properties.getProperty("username"),
				properties.getProperty("password"));
		return connection;
	}
	public void issuebooksmethod() throws SQLException, IOException {
		System.out.println("enter rollno");
		int rollno = scanner.nextInt();
		System.out.println("enter name");
		String nameString = scanner.next();
		System.out.println("enter book name");
		String bookString = scanner.next();
	
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into issuedbook values(?,?,?)");
		preparedStatement.setInt(1, rollno);
		preparedStatement.setString(2, nameString);
		preparedStatement.setString(3, bookString);
		preparedStatement.execute();
		connection.close();
		System.out.println(bookString+" issued to "+nameString);
	}
	public void Viewissuedbooks() throws SQLException, IOException{
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("select * from issuedbook");
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
		}
		
		connection.close();
		System.out.println("***** books issued to above students ******");
		
	}
	public void returnbooksmethod() throws SQLException, IOException {
		System.out.println("enter rollno");
		int rollno1 = scanner.nextInt();
		System.out.println("enter name");
		String nameString1 = scanner.next();
		System.out.println("enter book name");
		String bookString1 = scanner.next();
	
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into returnedbooks values(?,?,?)");
		preparedStatement.setInt(1, rollno1);
		preparedStatement.setString(2, nameString1);
		preparedStatement.setString(3, bookString1);
		preparedStatement.execute();
		connection.close();
		System.out.println(bookString1+" returned by "+nameString1);
	}
	public void Viewreturnedbooks() throws SQLException, IOException{
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("select * from returnedbooks");
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
		}
		
		connection.close();
		System.out.println("***** books returned by above students ******");
		
	}
}
