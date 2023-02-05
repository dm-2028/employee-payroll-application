package EmployeePayrollApplication;

public class EmployeeController {
	private EmployeeView view;
	private EmployeeModel model;
	
	public EmployeeController(EmployeeModel model, EmployeeView view) {
		this.model = model;
		this.view = view;
	}
	
	public void run() {
		view.promptUser("Hello! Please press Enter to display departments:");
		view.displayDepartmentList(model.calculatePay());
		view.promptUser("Please press Enter to list employees:");
		view.displayEmployeeList(model.sortEmployees());
		view.promptUser("Press Enter to finish");
	}
}
