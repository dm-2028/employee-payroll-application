package EmployeePayrollApplication;

/*
 * Class to represent an Employee. Employee type is represented by an enum.
 * I had considered making Employee an abstract class and extending for each
 * type, but since the only difference between employees is the pay rate, the 
 * enum removes the need for the boilerplate code of multiple different classes
 * and simplifies displaying the employee type String
 */
public class Employee {

	private String name;
	private EmployeeType type;
	private int hours;
	private boolean fullTime;
	
	public Employee(String name, EmployeeType type, int hours, boolean fullTime) {
		this.name = name;
		this.hours = hours;
		this.type = type;
		this.fullTime = fullTime;
	}
	
	public String getName() {
		return name;
	}
	
	public EmployeeType getType() {
		return type;
	}
	
	public int getHours() {
		return hours;
	}
	
	public boolean getFullTime() {
		return fullTime;
	}
	
	public int getWeeklyPay() {
		if(!fullTime || hours <=40) {
			return getHourlyRate() * hours + getBonus();
		}else {
			return ((3 * hours - 40) * getHourlyRate())/2 + getBonus(); 		
		}
	}
	
	public int getHourlyRate() {
		switch(type) {
			case INTERN: return 10;
			case FLOOR_WORKER: return 20;
			case SUPERVISOR: return 25;
			case MANAGER: return 35;
			case EXECUTIVE: return 50;
			default: return 0;
		}
	}
	
	public int getBonus() {
		if(type == EmployeeType.MANAGER ||
				type == EmployeeType.EXECUTIVE) {
			return 50;
		}else return 0;
	}
}



	
