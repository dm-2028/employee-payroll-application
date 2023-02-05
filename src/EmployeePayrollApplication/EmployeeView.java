package EmployeePayrollApplication;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeView {
	Scanner s = new Scanner(System.in);
	
	public void displayDepartmentList(Map<EmployeeType, Integer> departmentPay) {
		departmentPay.forEach((department, payroll) -> {
			System.out.println(department.getType() + ": $" + payroll);
		});
		System.out.println();
	}
	
	public void displayEmployeeList(List<Employee> sortedEmployees) {
		sortedEmployees.forEach(employee -> {
			System.out.println("Name: " + employee.getName() + " | Rate: $" + employee.getHourlyRate() + " | Weekly Pay: $" + employee.getWeeklyPay());
		});
		System.out.println();
	}
	
	public void promptUser(String stringPrompt) {
		System.out.println(stringPrompt);
		s.nextLine();
	}
}
