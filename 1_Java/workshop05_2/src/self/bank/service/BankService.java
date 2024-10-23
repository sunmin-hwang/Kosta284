package self.bank.service;

import self.bank.Customer;
/*
 싱글톤 : 하나의 클래스로부터 오직 하나의 인스턴스만 생성되도록 강제하는 패턴
 1. 일단 객체생성을 해당 클래스에서 하나는 한다.
    private static으로 지정해서 객체를 생성
 2. 다른 곳에서는(다른 클래스에서는) 객체생성이 안되도록 막아둔다.
    private 생성자(){ }
 3. 생성한 객체는 여기 저기서 갖다 쓸 수 있도록 static한 기능을 만들어준다.
    public static BankService getInstance(){} !!!
 */
public class BankService {
	
	public static final int MAX_CUSTOMERS = 100;
	public Customer[] customers;
	public int numberOfCustomers;	
	
	//1.
	private static BankService bank = new BankService();
	
	//2.
	private BankService() {
		System.out.println("SingleTone Pattern.....");
		customers =new Customer[MAX_CUSTOMERS];
		numberOfCustomers = 0;
	}	

	//3.
	public static BankService getInstance() {
		return bank;
	}
	
	public void addCustomer(Customer cust) {		
		if(numberOfCustomers==MAX_CUSTOMERS) {
			System.out.println("더이상 회원을 받을수 없습니다...");
			return;
		}
		customers[numberOfCustomers++] = cust;
	}
	
	public Customer getCustomer(int ssn) {		
		Customer cust = null;
		
		for(int i=0; i<numberOfCustomers; i++) {
			if(customers[i].getSsn()==ssn) cust = customers[i];
		}
		return cust;
	}
	
	public void showAll() {
		if(numberOfCustomers == 0) {
			System.out.println("회원이 아무도 없습니다.");
			return;
		}
		for(int i=0; i<numberOfCustomers; i++) {
			System.out.println(customers[i].toString());
		}			
	}
}
