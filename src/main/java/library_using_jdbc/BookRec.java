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

import com.mysql.cj.jdbc.Driver;

public class BookRec {
	Scanner scanner = new Scanner(System.in);

	public void bookrec() throws SQLException, IOException {
		System.out.println(".:: Book Page ::.");
		System.out.println("\n1. add books");
		System.out.println("2. view  books");
		System.out.println("3. exit");
		int e = scanner.nextInt();
		switch (e) {
		case 1:
			BookRec bRec = new BookRec();
			bRec.Addbooks();
			bRec.bookrec();
			break;

		case 2:
			BookRec bRec1 = new BookRec();
			bRec1.viewbooks();
			bRec1.bookrec();
			break;

		case 3:
			Admin back = new Admin();
			back.adminPage();
			break;
		}
	}

	public Connection getConnection() throws SQLException, IOException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));
		return connection;
	}

	void Addbooks() throws SQLException, IOException {
		System.out.println("enter id");
		int id = scanner.nextInt();
		System.out.println("enter book name");
		String book_names = scanner.next();
		System.out.println("enter publisher");
		String publisher = scanner.next();
		System.out.println("enter quantity");
		int quantity = scanner.nextInt();

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into books_rec values(?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, book_names);
		preparedStatement.setString(3, publisher);
		preparedStatement.setInt(4, quantity);
		preparedStatement.execute();
		System.out.println("books added successfully");

	}

	void viewbooks() throws SQLException, IOException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from books_rec");

		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " "
					+ resultSet.getInt(4));
		}

		connection.close();
		System.out.println("***** book details ******");

	}

}
