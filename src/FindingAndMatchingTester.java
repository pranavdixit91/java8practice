import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import sampleclasses.DbEmployee;

public class FindingAndMatchingTester {

	public static void main(String[] args) {
		List<DbEmployee> DbEmployees = new ArrayList<>();
		DbEmployees.add(new DbEmployee("Senior Analyst", "Pranav", new String[] { "Phaltan", "Pune" }));
		DbEmployees.add(new DbEmployee("Senior Analyst", "Pranav", new String[] { "Phaltan", "Pune" }));
		DbEmployees.add(new DbEmployee("Senior Analyst", "Pranav", new String[] { "Phaltan", "Pune" }));
		DbEmployees.add(new DbEmployee("Senior Analyst", "Sachin", new String[] { "Vidarbha", "Pune" }));
		DbEmployees.add(new DbEmployee("AVP", "Swapnil", new String[] { "Sangli", "Pune" }));
		DbEmployees.add(new DbEmployee("AVP", "Bhushan", new String[] { "Kolhapur", "Pune" }));
		DbEmployees.add(new DbEmployee("AVP", "Vinayak", new String[] { "UP", "Pune" }));
		DbEmployees.add(new DbEmployee("Associate", "Mrunal", new String[] { "Karjat", "Pune" }));
		DbEmployees.add(new DbEmployee("Associate", "Abhijit", new String[] { "Indore", "Pune" }));
		DbEmployees.add(new DbEmployee("Associate", "Tanay", new String[] { "Jodhpur", "Pune" }));

		System.out.println("Initial List Of Employees");
		DbEmployees.stream().forEach(System.out::println);

		// Checking anyMatch
		System.out.println();
		System.out.println("Is there any Senior Analyst ? - "+ DbEmployees.stream().anyMatch(DbEmployee::isSeniorAnalyst));
		
		// Checking allMatch
		System.out.println();
		System.out.println("Are they ALL Senior Analysts ? - "+ DbEmployees.stream().allMatch(DbEmployee::isSeniorAnalyst));
		
		// Checking noneMatch
		System.out.println();
		System.out.println("There are NO any directors in the List, right ? - "+ DbEmployees.stream().noneMatch(employee -> employee.getDesignation().equalsIgnoreCase("Director")));
		
		// Checking findAny
		System.out.println();
		System.out.print("Print any employee from the list - ");
		DbEmployees.stream().findAny().map(DbEmployee::getName).ifPresent(System.out::println);
		
		// Checking Comparator
		System.out.println();
		System.out.println("Sorted List of Employees According to their Names ");
		DbEmployees.stream().sorted(Comparator.comparing(DbEmployee::getName).reversed()).map(DbEmployee::getName).forEach(System.out::println);
		
		// Checking findFirst
		System.out.println();
		System.out.println("Sorted List of Employees According to their Names (FIND FIRST Employee with the name Descending)");
		DbEmployees.stream().sorted(Comparator.comparing(DbEmployee::getName).reversed()).map(DbEmployee::getName).findFirst().ifPresent(System.out::println);
		
		// Checking findFirst after Slicing the Stream
		System.out.println();
		System.out.println("Sorted List of Employees According to their Names (FIND FIRST Employee with the name Descending After Truncating first 4 Names)");
		DbEmployees.stream().sorted(Comparator.comparing(DbEmployee::getName).reversed()).map(DbEmployee::getName).skip(4).findFirst().ifPresent(System.out::println);
		
	}
}
