import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsCreationExamples {
	public static void main(String[] args) throws IOException {
		// From Collections
		System.out.println("From Collections:");
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		Stream<Integer> intStream = intList.stream();
		intStream.forEach(System.out::println);

		// Numerical Streams
		System.out.println();
		System.out.println("Numerical Streams:");
		IntStream intStreamNumeric = IntStream.range(0, 11);
		intStreamNumeric.forEach(System.out::println);

		// From Values
		System.out.println();
		System.out.println("From Values:");
		Stream<String> strStream = Stream.of("I", "AM", "STREAM", "FROM", "VALUES");
		strStream.forEach(System.out::println);

		// From Arrays
		System.out.println();
		System.out.println("From Arrays:");
		String[] stringArrays = new String[] { "I", "AM", "STREAM", "FROM", "ARRAYS" };
		Stream<String> stringStream = Arrays.stream(stringArrays);
		stringStream.forEach(System.out::println);

		// From Files
		System.out.println();
		System.out.println("From Files:");
		Files.lines(Paths.get("C:\\Users\\Pandya\\Documents\\CP.txt")).filter(t -> t.length() > 0).map(t -> t.length())
				.forEach(System.out::println);

	}
}
