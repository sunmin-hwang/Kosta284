package coffee.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CoffeeOrderTest {
	static int cnt = 1;
	
	public static void main(String[] args) {
		List<String> coffees = new ArrayList<String>();
		coffees.add("Cappuccino");
		coffees.add("Americano");
		coffees.add("Espresso");
		coffees.add("Caramel Macchiato");
		coffees.add("Mocha");
		coffees.add("Cappuccino");
		coffees.add("Espresso");
		coffees.add("Latte");
		
		Stream<String> stream = coffees.stream();
		
		stream.filter(c -> c.charAt(c.length()-1) == 'o').sorted().distinct().forEach(c -> {
			System.out.println(cnt++ + ". " + c);
		});
	}
}
