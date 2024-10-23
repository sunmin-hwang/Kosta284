package step1;

@FunctionalInterface
interface Workable{
	String monthPayment(String ename, double weekSal);
}

class Employee{//Workable을 매개변수로 Hasing
	public void work(Workable w) {
		String result = w.monthPayment("Smith", 2000.0);
		System.out.println("Result => " + result);
	}
	
}
public class LambdaTest2 {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.work((a, b) -> {
			//구현체를 작성...
			double salary = b * 4 + 100.0;
			return a + " 씨의 월급은 " + salary;
		});
	}
}
