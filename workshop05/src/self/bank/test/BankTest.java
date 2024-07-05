package self.bank.test;

import self.bank.Account;
import self.bank.Address;
import self.bank.BankService;
import self.bank.Customer;

public class BankTest {

	public static void main(String[] args) {
		BankService service = new BankService(5);
		service.addCustomer(new Customer("James", 111, new Address(123, "AA", "BB"), new Account(10000)));
		service.addCustomer(new Customer("Tomas", 222, new Address(456, "CC", "DD"), new Account(12345)));
		
		System.out.println(service.getCustomer(111).toString());
		
		service.showAll();
	}

}
