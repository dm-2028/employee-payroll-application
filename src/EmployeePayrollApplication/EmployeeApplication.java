package EmployeePayrollApplication;

public class EmployeeApplication {
	public static void main(String[] args) {
		EmployeeModel model = new EmployeeModel();
		EmployeeView view = new EmployeeView();
		
		EmployeeController controller = new EmployeeController(model, view);
		controller.run();
	}
}
