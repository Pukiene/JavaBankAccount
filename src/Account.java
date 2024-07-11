
public class Account extends Customer{
	 private int balance;
	 private int accountNumber;
	 


		
		public Account(String FName, String Lname, int accNum , int accBal) {
		setFirstName(FName);
		setLastName(Lname);
		this.accountNumber = accNum;
		this.balance = accBal;
	}


			public int getBalance(){
				return balance;
			}

			public int getAccountNum() {
				return accountNumber;
			}

			public void deposit(int amount) {
				        if (amount > 0) {
				            this.balance += amount;
				            System.out.println("Deposit of £" + amount + " successful. New balance: £" + this.balance);
				       } else {
				            System.out.println("Deposit amount must be positive.");
				       }
				    }

			public void withdraw(double amount) {
				       if (amount > 0 && amount <= this.balance) {
				          this.balance -= amount;
				           System.out.println("Withdrawal of £" + amount + "successful. New balance: £" + this.balance);
				       } else {
				            System.out.println("Insufficient funds or invalid withdrawal amount.");
				        }
				    }
}
