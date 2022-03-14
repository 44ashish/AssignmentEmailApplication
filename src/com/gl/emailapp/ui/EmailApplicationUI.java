package com.gl.emailapp.ui;
import java.util.Scanner;

import com.gl.emailapp.Employee;
import com.gl.emailapp.service.CredentialsGenerator;
public class EmailApplicationUI {
	public void init() {

		Employee employee = buildUI(); //[1] [2]
		callService(employee);	 // [3]	
	}
	
	private Employee buildUI() {
		
		buildWelcomeSection();		
		Employee employee =	buildEmployeeDetailsSection();		
		return employee;
	}
	
	private void buildWelcomeSection() {

		System.out.println("---------------------------------");
		System.out.println("Welcome to Email Generator Services !!");
		System.out.println("---------------------------------");
				
	}
	
	private Employee buildEmployeeDetailsSection() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter employee's first name: ");
		String firstName = sc.nextLine();
		
		System.out.println("Enter employee's last name: ");
		String lastName = sc.nextLine();
				
		System.out.println("Employee's department: ");
		
		System.out.println("1: Technical");
		System.out.println("2: Admin");
		System.out.println("3: Human Resource");
		System.out.println("4: Legal");
		System.out.println("Select 1/2/3/4 for employee's department");
		
		int departmentID = sc.nextInt();
		String departmentName = getDepartmentName(departmentID);
		
		Employee employee = new Employee(firstName,
			lastName, departmentName);
		
		sc.close();
		
		return employee;
	}
	
	private String getDepartmentName(int departmentID) {
		
		if (departmentID == 1) {
			return "Technical";
		}else if (departmentID == 2) {
			return "Admin";
		}else if (departmentID == 3) {
			return "Human Resource";
		}else if (departmentID == 4) {
			return "Legal";
		}else {
			return "";
		}
	}
	
	private void callService(Employee employee) {
		
		CredentialsGenerator gen = new CredentialsGenerator(employee);
		
		gen.generateEmailID();
		gen.generatePassword();
		
		gen.showCredentials();
		
	}
}
