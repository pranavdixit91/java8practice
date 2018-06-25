import java.util.ArrayList;
import java.util.List;

import sampleclasses.DbEmployee;

public class FilteringAndSlicingExamples {
	public static void main(String[] args) {
		List<DbEmployee> DbEmployees = new ArrayList<>();
		DbEmployees.add(new DbEmployee("Senior Analyst", "Pranav", new String[] {"Phaltan","Pune"}));
		DbEmployees.add(new DbEmployee("Senior Analyst", "Pranav", new String[] {"Phaltan","Pune"}));
		DbEmployees.add(new DbEmployee("Senior Analyst", "Pranav", new String[] {"Phaltan","Pune"}));
		DbEmployees.add(new DbEmployee("Senior Analyst", "Sachin", new String[] {"Vidarbha","Pune"}));
		DbEmployees.add(new DbEmployee("AVP", "Swapnil", new String[] {"Sangli","Pune"}));
		DbEmployees.add(new DbEmployee("AVP", "Bhushan", new String[] {"Kolhapur","Pune"}));
		DbEmployees.add(new DbEmployee("AVP", "Vinayak", new String[] {"UP","Pune"}));
		DbEmployees.add(new DbEmployee("Associate", "Mrunal", new String[] {"Karjat","Pune"}));
		DbEmployees.add(new DbEmployee("Associate", "Abhijit", new String[] {"Indore","Pune"}));
		DbEmployees.add(new DbEmployee("Associate", "Tanay", new String[] {"Jodhpur","Pune"}));

		System.out.println("Initial List Of Employees");
		DbEmployees.stream().forEach(System.out::println);

		// Example of Filter
		System.out.println();
		System.out.println("After Filtering Senior Analyst::");
		DbEmployees.stream().filter(DbEmployee::isSeniorAnalyst).forEach(System.out::println);

		// Example of Distinct
		System.out.println();
		System.out.println("After Filtering DISTINCT Senior Analyst::");
		DbEmployees.stream().filter(DbEmployee::isSeniorAnalyst).distinct().forEach(System.out::println);

		// Example of LIMIT
		System.out.println();
		System.out.println("After Limiting to 7 Employees::");
		DbEmployees.stream().limit(7).forEach(System.out::println);

		// Example of SKIP
		System.out.println();
		System.out.println("After Skipping first 4 Employees::");
		DbEmployees.stream().skip(4).forEach(System.out::println);
	}
}