import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Application {

	public static void main(String[] args) {

		ArrayList<CreditCard> wallet = new ArrayList<CreditCard>(), wallet2 = new ArrayList<CreditCard>();
		ArrayList<ArrayList<CreditCard>> purse = new ArrayList<ArrayList<CreditCard>>(), purse2 = new ArrayList<ArrayList<CreditCard>>();

		/*******************************
		 * TEST CASE 1:
		 *******************************/
		System.out.println("********* Test Case 1 *********");
		Person person = new Person("Amanda", "TestCase1");
		wallet.add(newVisa(100));
		wallet.add(newMasterCard(100));
		wallet.add(newDiscover(100));
		purse.add(wallet);
		person.setPurse(purse);
		result(person);
		System.out.println("********* End of Test Case 1 *********");

		/*******************************
		 * TEST CASE 2:
		 *******************************/
		System.out.println("\r\n********* Test Case 2 *********");
		wallet.clear();
		purse.clear();
		person = new Person("Rebekah", "TestCase2");
		wallet.add(newVisa(100));
		wallet.add(newDiscover(100));
		wallet2.add(newMasterCard(100));
		purse.add(wallet);
		purse.add(wallet2);
		person.setPurse(purse);
		result(person);
		System.out.println("********* End of Test Case 2 *********");

		/*******************************
		 * TEST CASE 3:
		 *******************************/
		System.out.println("\r\n********* Test Case 3 *********");
		wallet.clear();
		purse.clear();
		wallet2.clear();
		person = new Person("Annie", "TestCase3");
		wallet.add(newVisa(100));
		wallet.add(newMasterCard(100));
		wallet.add(newDiscover(100));
		purse.add(wallet);
		person.setPurse(purse);
		Person person2 = new Person("Amber", "TestCase3");
		wallet2.add(newVisa(100));
		wallet2.add(newMasterCard(100));
		purse2.add(wallet2);
		person2.setPurse(purse2);
		result(person);
		System.out.println();
		result(person2);
		System.out.println("********* End of Test Case 3 *********");

	}

	private static void result(Person person1) {
	HashMap<Integer, String> which = new HashMap<Integer, String>();
	if(person1.getPurse().size() > 1) {
		which.put(1,"'s first wallet has ");
	} else {
		which.put(1,"'s wallet has ");
	}
	which.put(2, "'s second wallet has ");

	System.out.print(person1.getFirstName() + " " + person1.getLastName() + " has " + person1.getPurse().size() + ((person1.getPurse().size() > 1) ? " wallets. \r\n" : " wallet. \r\n"));
	int whichWallet = 0;
		for(ArrayList<CreditCard> wallet : person1.getPurse()) {
		int visaCount = 0, masterCardCount = 0, discoverCount = 0;
		double visaInterest = 0, masterCardInterest = 0, discoverInterest = 0, totalInterest = 0;
		whichWallet++;
			for(CreditCard card : wallet) {
				if(card.getClass() == Visa.class) {
					Visa visa = (Visa) card;
					double balance = visa.getBalance();
					visaInterest = visa.calcInterest(balance);
					visaCount += 1;
				} else if (card.getClass() == MasterCard.class) {
					MasterCard masterCard = (MasterCard)card;
					double balance = masterCard.getBalance();
					masterCardInterest = masterCard.calcInterest(balance);
					masterCardCount += 1;
				} else {
					Discover discover = (Discover)card;
					double balance = discover.getBalance();
					discoverInterest = discover.calcInterest(balance);
					discoverCount += 1;
				}
			}

	totalInterest = visaInterest + masterCardInterest + discoverInterest;
	int totalCards = visaCount + masterCardCount + discoverCount;
	System.out.print("\r\n" + person1.getFirstName() + which.get(whichWallet)
			+ totalCards + ((totalCards > 1) ? " cards in it: " : " card in it: ")
			+ ((visaCount > 0) ? visaCount + ((visaCount > 1) ? " Visa cards" : " Visa card") + ((masterCardCount + discoverCount > 0) ? ", " : ". \r\n") : "")
			+ ((masterCardCount > 0) ? masterCardCount + ((masterCardCount > 1) ? " MasterCards" : " MasterCard") + ((discoverCount > 0) ? ", " : ". \r\n") : "")
			+ ((discoverCount > 0) ? discoverCount + ((discoverCount > 1) ? " Discover cards. \r\n" : " Discover card. \r\n") : "")
			+ "The monthly interest charged for each card is as follows:\r\n"
			+ ((visaCount > 0) ? "Visa: " + usd(visaInterest) + "\r\n" : "")
			+ ((masterCardCount > 0) ? "MasterCard: " + usd(masterCardInterest) + "\r\n" : "")
			+ ((discoverCount > 0) ? "Discover: " + usd(discoverInterest) + "\r\n" : "")
			+ "The total monthly interest from this wallet is: " + usd(totalInterest) + ".\r\n");
			
		}
		
	}

	private static Visa newVisa(double balance) {
		Visa visa = new Visa(balance);
		return visa;
	}
	
	private static MasterCard newMasterCard(double balance) {
		MasterCard masterCard = new MasterCard(balance);
		return masterCard;
	}
	
	private static Discover newDiscover(double balance) {
		Discover discover = new Discover(balance);
		return discover;
	}
	
	private static String usd(double amount) {
		NumberFormat usd = NumberFormat.getCurrencyInstance();
		return usd.format(amount);
	}
	
}