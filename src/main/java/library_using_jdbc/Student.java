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

public class Student {
	Scanner scanner = new Scanner(System.in);
	public void studentpage() throws SQLException, IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n.:: Student Page ::.");
		System.out.println("\n1. Add Students info");
		System.out.println("2. Display students details");
		System.out.println("3. Exit");
		int stpgc=scanner.nextInt();
		switch (stpgc) {
		case 1:
			Student stuadd = new Student();
			stuadd.AddStudents();
			stuadd.studentpage();
			break;
			
		case 2:
			Student stuadd1 = new Student();
			stuadd1.ViewStudents();
			stuadd1.studentpage();
			break;
			
		case 3:
			Admin adstud2 = new Admin();
			adstud2.adminPage();
			break;

		default:
			System.out.println("invalid option");
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

	void AddStudents() throws SQLException, IOException {
		
		System.out.println("enter rollno");
		int rollno = scanner.nextInt();
		System.out.println("enter name");
		String name = scanner.next();
		System.out.println("enter branch");
		String branch = scanner.next();
		System.out.println("enter mobile");
		long mobile = scanner.nextLong();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into student values(?,?,?,?)");
		preparedStatement.setInt(1, rollno);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, branch);
		preparedStatement.setLong(4, mobile);
		preparedStatement.execute();
		connection.close();
		System.out.println("student added successfully");

	}
	void ViewStudents() throws SQLException, IOException{
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getLong(4));
		}
		
		connection.close();
		System.out.println("***** student details ******");
		
	}
	
}