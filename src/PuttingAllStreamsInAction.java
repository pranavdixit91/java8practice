import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import sampleclasses.Trader;
import sampleclasses.Transaction;

public class PuttingAllStreamsInAction {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		System.out.println("Initial List");
		System.out.println(transactions);

		// 1
		System.out.println();
		List<Transaction> solution1 = transactions.stream().filter(t -> (t.getYear() == 2011))
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		System.out.println("Solution 1:");
		System.out.println(solution1);

		// 2
		System.out.println();
		List<String> solution2 = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct()
				.collect(Collectors.toList());
		/*
		 * This can be completed in one map function as ...map(t ->
		 * t.getTrader().getCity())
		 */
		System.out.println("Solution 2:");
		System.out.println(solution2);

		// 3
		System.out.println();
		List<Trader> solution3 = transactions.stream().map(Transaction::getTrader)
				.filter(p -> p.getCity().equalsIgnoreCase("Cambridge")).distinct()
				.sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
		System.out.println("Solution 3:");
		System.out.println(solution3);

		// 4
		System.out.println();
		String solution4 = transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted()
				.reduce("", String::concat);
		String solution41 = transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted()
				.collect(Collectors.joining()); // Collectors.joining used StringBuilder internally which is more
												// efficient
		System.out.println("Solution 4:");
		System.out.println(solution4);
		System.out.println(solution41);

		// 5
		System.out.println();
		boolean solution5 = transactions.stream().map(Transaction::getTrader)
				.anyMatch(n -> n.getCity().equalsIgnoreCase("Milan"));
		boolean solution51 = transactions.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Milan")); // This solution is close to actual problem statement 
		System.out.println("Solution 5:");
		System.out.println(solution5);
		System.out.println(solution51);

		// 6
		System.out.println();
		System.out.println("Solution 6:");
		transactions.stream().filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
				.mapToInt(Transaction::getValue).forEach(System.out::println);

		// 7
		System.out.println();
		System.out.println("Solution 7:");
		transactions.stream().map(Transaction::getValue).max(Comparator.comparingInt(Integer::intValue))
				.ifPresent(System.out::println);
		System.out.println(transactions.stream().map(Transaction::getValue).reduce(0, Integer::max));

		// 8
		System.out.println();
		System.out.println("Solution 8:");
		transactions.stream().sorted(Comparator.comparingInt(Transaction::getValue)).findFirst()
				.ifPresent(System.out::println);
	}
}
