package self.bank;

public class Account {
	private int balance;

	public Account() { }

	public Account(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	
	public void deposit(int balance) {
		this.balance += balance;
	}
	
	public void withdraw(int balance) {
		this.balance -= balance;
	}
	
	public String toString() {
		return balance +"";
	}
}
