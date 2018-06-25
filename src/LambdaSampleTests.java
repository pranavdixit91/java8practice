import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaSampleTests {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(i);
		}
		
		List<Integer> list1 = new ArrayList<>(list);
		List<Integer> list2 = new ArrayList<>(list);
		System.out.println(list);
		System.out.println(list1);
		System.out.println(list2);
		
		// Using Anonyous Classes
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		//Using Lambda Expressions Part 1
		list1.sort((Integer o1, Integer o2) -> (o2.compareTo(o1)));
		
		//Using Lambda Expressions Part 2
		list2.sort((o1, o2)->(o2.compareTo(o1)));
		
		System.out.println(list);
		System.out.println(list1);
		System.out.println(list2);
	}
}
