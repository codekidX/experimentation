
public class Account {
	
	long accNum;
	double balance;
	Person accHolder;
	

	// getters and setters for acc number
	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	
	// getters and setters for name of acc holder
	public Person getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}
	
	

	// getters and setters for balance
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	// this method is also a getter
	double getBalance() {
		return this.balance;
	}
	
	/*
	 * 
	 * METHODS THAT ACCOUNT CLASS HAS BY DFAULT
	 * 
	 * */
	
	void deposit(double amount) {
		this.balance += amount;
	}
	
	void withdraw(double amount) {
		this.balance -= amount;
	}
	
	// if she really want to override
	
	// note there are 2 withdraw method.. infinite can be made unless the parameters passed is different
	boolean withdraw(int overDraftLimit) {
		if(balance > overDraftLimit) {
			// still not reached minimum balance
			return false;
		} else {
			// is below overdraft .. CAN'T WITHRAW ANYMORE
			return true;
		}
	}
}
