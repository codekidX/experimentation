
public class MainProgram {
	
	static Account Kathy;
	static Account Smith;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// creates a new account
		Smith = new Account();
		Smith.balance = 2000d;
		
		// creates a new account
		Kathy = new Account();
		Kathy.balance = 3000d;
		
		
		//  3.1 b
		Smith.deposit(3000d);
		
		// 3.1 c
		
		// pass only 2000 and see it will not withraw  | 2 DIFFERENT DATATYPES |
		Kathy.withdraw(2000d);
		
		// 3.1 d
		System.out.println("Smith's balance : " + Smith.getBalance());
		System.out.println("Kathy's balance : " + Kathy.getBalance());
	}

	// 3.1 e
	@Override
	public String toString() {
		return "MainProgram [toString()=" + super.toString() + "]";
	}
	

}
