import java.util.ArrayList;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class MethodReferencesTest {

	public static void main(String[] args) {
	ArrayList<Apple> apples = new ArrayList<>();
	apples.add(new Apple("RED", 10));
	apples.add(new Apple("GREEN", 30));
	apples.add(new Apple("GREEN", 20));
	
	System.out.println(apples);
	
	apples.sort(comparing((Apple::getWeight)).reversed());
	
	System.out.println(apples);
	
	apples.sort(comparing(Apple::getColor).reversed().thenComparing(Apple::getWeight));
	
	System.out.println(apples);
	
	Predicate<Apple> isHeavyPredicate = Apple::IsHeavy;
	
	System.out.println("Heavy Apple : " + apples.stream().filter(isHeavyPredicate).count());
	
	System.out.println("Green Apple : " + apples.stream().filter(Apple::IsGreen).count());
	
	System.out.println("Green Apple which is Heavy : " + apples.stream().filter(isHeavyPredicate.and(Apple::IsGreen)).count());
	
	System.out.println(apples);
	}
}

class Apple {
	private String color;
	private int weight;
	
	
	
	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}

	public Apple(String color, int weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public Boolean IsGreen() {
		return this.color.equalsIgnoreCase("GREEN");
	}
	
	public Boolean IsHeavy() {
		return this.weight > 20;
	}
	
}
