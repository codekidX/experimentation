
public class ComplexProgram {
	
	static Account Kathy;
	static Account Smith;

	/*
	 * 
	 *  SAME OUTPUT BUT USED 'Person' data model
	 * 
	 * */
	
	public static void main(String[] args) {
		
		
		// creates a new account
		Smith = new Account();
		Smith.balance = 2000d;
		
		// add smith's name and age to the account using Person data model
		Person smithPerson = new Person();
		smithPerson.setName("Smith");
		smithPerson.setAge(32f);
		
		// now set this Person as accountHolder in Account Class (Smith)
		Smith.accHolder = smithPerson;
		
		// creates a new account
		Kathy = new Account();
		Kathy.balance = 3000d;
		
		// add kathy's name and age to the account using Person data model
		Person kathyPerson = new Person();
		kathyPerson.setName("Kathy");
		kathyPerson.setAge(22f);
		
		// now set this Person as accountHolder in Account Class (Smith)
		Kathy.accHolder = kathyPerson;
		
		
		//  3.1 b
		Smith.deposit(3000d);
		
		// 3.1 c
		
		// pass only 2000 and see it will not withraw  | 2 DIFFERENT DATATYPES |
		Kathy.withdraw(2000d);
		
		// 3.1 d
		System.out.println(Smith.accHolder.getName() +"'s balance : " + Smith.getBalance());
		System.out.println(Kathy.accHolder.getName() + "'s balance : " + Kathy.getBalance());
	}

	// 3.1 e
	@Override
	public String toString() {
		return "ComplexProgram [toString()=" + super.toString() + "]";
	}
}
