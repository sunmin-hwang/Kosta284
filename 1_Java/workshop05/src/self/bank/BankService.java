package self.bank;

public class BankService {
	public static final int MAX_CUSTOMER = 100;
	public int numberOfCustomers;
	
	public Customer[] customers;
	public int cidx;
	
	public BankService(int size) {
		customers = new Customer[size];
	}

	public void addCustomer(Customer customer) {
		customers[cidx++] = customer;
	}
	
	public Customer getCustomer(int ssn) {
		Customer customer = null;
		for(Customer cus : customers) {
			if(cus == null) break;
			if(cus.getSsn() == ssn) customer = cus;
		}
		return customer;
	}
	
	public void showAll() {
		for(Customer customer : customers) {
			if(customer == null) break;
			System.out.println(customer.toString());
		}
	}
}
