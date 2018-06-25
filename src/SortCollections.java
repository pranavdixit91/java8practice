import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class SortCollections {

	public static void main(String[] args) {
		List<Employee> listEmployees = new ArrayList<>();
		Map<String, String> employeeMap = new HashMap<>();

		listEmployees.add(new Employee("Pranav"));
		listEmployees.add(new Employee("Zampya"));
		listEmployees.add(new Employee("Aai"));
		listEmployees.add(new Employee("Arnav"));
		listEmployees.add(new Employee("Ganesh"));

		System.out.println(listEmployees);

		List<String> listEmployees1 = listEmployees.stream().parallel().map(n -> n.getName().toLowerCase())
				.collect(Collectors.toList());

		System.out.println(listEmployees1);

		// Using Method References
		List<String> listEmployeesStartsWithA = listEmployees.stream().parallel().filter(Employee::startWithA)
				.map(n -> n.getName().toUpperCase()).collect(Collectors.toList());

		// Using Lambdas for Filtering 
		List<String> listEmployeesStartsWithALambda = listEmployees.stream().parallel()
				.filter(s -> s.getName().startsWith("A")).map(n -> n.getName().toUpperCase())
				.collect(Collectors.toList());

		// Using Lambdas for Map Function
		List<Employee> listEmployeesStartsWithALambdaForMap = listEmployees.stream().parallel()
				.filter(s -> s.getName().startsWith("A")).map(Employee::convertAtoa)
				.collect(Collectors.toList());

		for (Employee key : listEmployees) {
			employeeMap.put(key.getName(), Employee.class.getName());
		}

		System.out.println("Starts with A" + listEmployeesStartsWithA);

		System.out.println("Starts with A (Lambda)" + listEmployeesStartsWithALambda);
		
		System.out.println("Starts with A (Lambda for Map)" + listEmployeesStartsWithALambdaForMap);

		Set<Entry<String, String>> employeeEntrySet = employeeMap.entrySet();

		for (Entry entry : employeeEntrySet) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

}

class Employee {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Boolean startWithA() {
		return name.startsWith("A");
	}

	public Employee convertAtoa() {
		return new Employee(name.replace("A", "a"));
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
}
