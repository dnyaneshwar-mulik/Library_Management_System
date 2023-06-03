package myLibraryManagementProject;

import java.util.Scanner;

public class Studentsn{
	final int total_std=5;
	int [] sRollNo = new int [total_std];
	String[] sName= new String[total_std];
	Scanner stusc = new Scanner(System.in);
	
	public void studentAdd() {
		System.out.println("Add roll no.& student name");
		for(int i=0; i<total_std;i++) {
			System.out.println("enter roll no.");
			sRollNo[i]= stusc.nextInt();
			System.out.println("enter name ");
			sName[i]=stusc.next();
		}
		System.out.println();
		System.out.println("data stored");
	}
	public void showStudents() {
		System.out.println("list of students");
		for(int j=0; j<total_std; j++) {
			System.out.println(j+1+"> "+sRollNo[j]+" - "+sName[j]);
		}
	}

}
