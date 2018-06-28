import java.util.stream.IntStream;

public class PythagorasUsingStreams {
	public static void main(String[] args) {

		System.out.println("Pythgoras Triplets from 1 to 100 :");
		IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> (Math.sqrt(a * a + b * b) % 1 == 0))
						.mapToObj(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }))
				.forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
	}
}
