import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import sampleclasses.DbEmployee;

public class MapFlatMapFunctions {
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

		// Mapping each person with his Designation
		System.out.println();
		System.out.println("After Mapping each person with his Designation: ");
		DbEmployees.stream().map(n -> n.getDesignation()).forEach(System.out::println);

		// Mapping each person with his Name
		System.out.println();
		System.out.println("After Mapping each person with his Name: ");
		DbEmployees.stream().map(DbEmployee::getName).forEach(System.out::println);

		// Mapping each person with his Name (Distinct)
		System.out.println();
		System.out.println("After Mapping each person with his Name (Distinct): ");
		DbEmployees.stream().map(DbEmployee::getName).distinct().forEach(System.out::println);

		// Mapping each person with his Customised String
		System.out.println();
		System.out.println("After Mapping each person with his Customised String: ");
		DbEmployees.stream().map(n -> n.getName() + " is " + n.getDesignation()).distinct()
				.forEach(System.out::println);

		// Mapping each person with No Of Cities Using MAP Function
		System.out.println();
		System.out.println("After Mapping each person with No Of Cities: (Using MAP Functions)");
		DbEmployees.stream().map(DbEmployee::getCitiesLivedIn).map(Arrays::stream).forEach(System.out::println);

		// FLAT Mapping each person with No Of Cities Using Flat Map Function
		System.out.println();
		System.out.println("After Mapping each person with No Of Cities: (Using FLAT MAP Functions)");
		DbEmployees.stream().map(DbEmployee::getCitiesLivedIn).flatMap(Arrays::stream).distinct()
				.forEach(System.out::println);

		// FLAT Mapping each person no of distinct characters from all the names
		System.out.println();
		System.out.println("After FLAT Mapping each person no of distinct characters from all the names");
		Stream<String> uniqueCharacters  = DbEmployees.stream().map(DbEmployee::getName).map(name -> name.split("")).flatMap(Arrays::stream).map(String::toUpperCase).distinct();
		System.out.println("Below Characters are used :");
		uniqueCharacters.forEach(System.out::println);
	}
}
