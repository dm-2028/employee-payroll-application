package EmployeePayrollApplication;

public enum EmployeeType {
	INTERN("Intern"),
	FLOOR_WORKER("Floor Worker"),
	SUPERVISOR("Supervisor"),
	MANAGER("Manager"),
	EXECUTIVE("Executive");
	
	private String employeeType;
	
	EmployeeType(String employeeType){
		this.employeeType = employeeType;
	}
	
	public String getType() {
		return employeeType;
	}
}
