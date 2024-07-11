import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		//Account account1 = new Account("jeffrey" , "ting", 1, 2000);
		//Account account2 = new Account("Hiran" , "Patel", 2, 1000);
		
		
		//System.out.println(account1.getBalance());
		//System.out.println(account2.getBalance());
		
		//account1.deposit(250);
		//System.out.println(account1.getBalance());
		
		//account2.withdraw(500);
		
		//Transaction t = new Transaction();
        //t.transfer(account1, account2, 250);
		//System.out.println(account1.getBalance());
		//System.out.println(account2.getBalance());
    
		 LinkedList<Account> accounts = new LinkedList<Account>();
		 String currentDir = System.getProperty("user.dir");
		 String file = currentDir + "\\Accounts.csv";
		 //String file = "C:\\Users\\mmerk\\eclipse-workspace\\Assignments4CS021\\Accounts.csv";
		 
		 ReadAccounts readAcc = new ReadAccounts(file);
		 LinkedList<String> fnList = readAcc.getFirstName();
		 LinkedList<String> LnList = readAcc.getLastName();
		 LinkedList<Integer> accNumList = readAcc.getAccountNum();
		 LinkedList<Integer> balanceList = readAcc.getBalances();
		 
		 //ReadAccounts readAcc = new ReadAccounts();
		// LinkedList<String> fnList = readAcc.getFirstName(file);
		 //LinkedList<String> LnList = readAcc.getLastName(file);
		 //LinkedList<Integer> accNumList = readAcc.getAccountNum(file);
		//LinkedList<Integer> balanceList = readAcc.getBalances(file);
		 
		 //System.out.println(fnList);
		 //System.out.println(LnList);
		 //System.out.println(accNumList);
		 //System.out.println(balanceList);
		 
		 for (int i = 0; i < fnList.size(); i++){
			// System.out.println(fnList.get(i) + LnList.get(i)+ accNumList.get(i)+ balanceList.get(i));
			 accounts.add(new Account(fnList.get(i), LnList.get(i), accNumList.get(i), balanceList.get(i) ));
		 }
		 
		 //System.out.println(accounts.get(0).getFirstName());
		 //System.out.println(accounts.get(3).getFirstName());
		 //System.out.println(accounts.get(11).getFirstName());
		 //System.out.println(accounts.get(0).getBalance());	 
		 //accounts.get(0).deposit(500);
		 //System.out.println(accounts.get(0).getBalance());
		 
		 //accounts.get(0).withdraw(500);
		 //System.out.println(accounts.get(0).getBalance());
		

		 
		 GUI gui = new GUI(accounts);
		 gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 gui.setSize(850, 220);
		 gui.setVisible(true);
}
}