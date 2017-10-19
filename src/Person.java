import java.util.ArrayList;

public class Person {

	protected String firstName;
	protected String lastName;
	protected ArrayList<ArrayList<CreditCard>> purse;
	
	public Person() {}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<ArrayList<CreditCard>> getPurse() {
		return purse;
	}

	public void setPurse(ArrayList<ArrayList<CreditCard>> purse) {
		this.purse = purse;
	}
	
}
