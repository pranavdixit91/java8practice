import java.util.Arrays;
import java.util.Optional;

public class ReduceExamplesJava8Tester {
	public static void main(String[] args) {
		int[] numbers = new int[] { 10, 20, 35, 7, 3, 5, 88, 59, 37, 29, 13, 9, 67, 76 };

		System.out.println("Initial Array:");
		Arrays.stream(numbers).forEach(System.out::println);

		// Using Reduce Operation to SUM-UP the integers
		Integer sum = Arrays.stream(numbers).boxed().reduce(0, (x, y) -> (x + y));
		System.out.println();
		System.out.println("Sum of all Numbers is - " + sum);

		// Using Reduce Operation to SUM-UP the integers Using MEthod Refernces
		Integer addition = Arrays.stream(numbers).boxed().reduce(0, Integer::sum);
		System.out.println();
		System.out.println("Sum of all Numbers is (Using Method References)- " + addition);

		// Using Reduce Operation to SUM-UP the integers Using Method Refences and
		// OPTIONAL
		Optional<Integer> additionWithOptional = Arrays.stream(numbers).boxed().reduce(Integer::sum);
		System.out.println();
		additionWithOptional.ifPresent(additionInternal -> System.out
				.println("Sum of all Numbers is (Using Method References and Optional SUM)- " + additionInternal));

		// Using Reduce Operation to find MAX number the integers Using MEthod Refernces
		Integer max = Arrays.stream(numbers).boxed().reduce(0, Integer::max);
		System.out.println();
		System.out.println("MAX of all Numbers is (Using Method References)- " + max);

		// Using Reduce Operation to SUM-UP the integers Using MEthod Refernces
		Integer min = Arrays.stream(numbers).boxed().reduce(Integer.MAX_VALUE, Integer::min);
		System.out.println();
		System.out.println("MIN of all Numbers is (Using Method References)- " + min);
	}
}
