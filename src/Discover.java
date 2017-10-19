public class Discover implements CreditCard {

	protected double balance;
	private final double interest = .01;
	
	public Discover() {}
	
	public Discover(double balance) {
		this.balance = balance;
	}
	
	@Override
	public double calcInterest(double amount) {
		double calcInterest = amount * interest;
		return calcInterest;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterest() {
		return interest;
	}
	
}
