import java.util.stream.Stream;

public class FibonacciInfiniteStream {
	public static void main(String[] args) {
		System.out.println("Fibonacci Tuple Series (Limit 10):");
		Stream.iterate(new int[] { 0, 1 }, (t -> new int[] { t[1], t[0] + t[1] })).limit(10)
				.forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

		System.out.println();
		System.out.println("Fibonacci Series (Limit 10):");
		Stream.iterate(new int[] { 0, 1 }, (t -> new int[] { t[1], t[0] + t[1] })).limit(10).map(t -> t[0])
				.forEach(System.out::println);
	}
}
