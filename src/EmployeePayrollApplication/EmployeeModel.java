package EmployeePayrollApplication;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

public class EmployeeModel {

	private List<Employee> employees;
	
	public EmployeeModel(){
		employees = parseDummyData();
	}
	
	public EmployeeModel(List<Employee> employees) {
		this.employees = employees;
	}
	
	public Map<EmployeeType, Integer> calculatePay() {
		//first sums employee pay grouped by employeeType and adds to a map,
		//then sorts the map according to total payroll;
		Map<EmployeeType, Integer> payrolls = employees.stream()
				.collect(Collectors.groupingBy(Employee::getType,
						Collectors.summingInt(Employee::getWeeklyPay)))
				.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
		
		return payrolls;
	}
	
	public List<Employee> sortEmployees() {
		employees.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				//convert to lowercase so that case is ignored when alphabetizing
				return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
			}
		});
		return employees;
	}
	
	private List<Employee> parseDummyData(){
		String filename = "/MOCK_DATA.json";
		String json = "";
		List<Employee> employees = new ArrayList<Employee>(1000);
		InputStream stream = this.getClass().getResourceAsStream(filename);
		try (Scanner s = new Scanner(stream).useDelimiter("\\A")) {
			json = s.hasNext() ? s.next() : "";
			s.close();
		}
		JSONArray jsonArray = new JSONArray(json);
		JSONObject objectToParse;
		String name;
		boolean fullTime;
		int hours;
		int employeeType;
		for(int i = 0; i < jsonArray.length(); i++) {
			objectToParse = (JSONObject) jsonArray.get(i);
			name = objectToParse.getString("first_name");
			fullTime = objectToParse.getBoolean("full_time");
			hours = objectToParse.getInt("hours");
			employeeType = objectToParse.getInt("type");
			employees.add(new Employee(name, EmployeeType.values()[employeeType], hours, fullTime));
		}
		return employees;
	}
}
