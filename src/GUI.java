import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GUI extends JFrame implements ActionListener {

	private Transaction transferObject;
    private StringBuilder sbAllData;
    private LinkedList<Account> globalAccounts;
    
	private JLabel showAllData; 
	
	private JButton showAllButton;
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton transferButton;
	
	private JTextField accDeposit;
	private JTextField accWithdraw;
	private JTextField acc1Transfer;
	private JTextField acc2Transfer;
	private JTextField depositInput;
	private JTextField withdrawInput;
	private JTextField transferAmount;
	private String a = "";
	public GUI(LinkedList<Account> accounts) throws FileNotFoundException, IOException {
		super("bankingSystem");
		setLayout(null);
		
        transferObject = new Transaction();
        sbAllData = new StringBuilder();
        globalAccounts = accounts;
        
        LinkedList<Account> accounts1 = new LinkedList<Account>(); 
        String currentDir = System.getProperty("user.dir");
		String file = currentDir + "\\Accounts.csv";
        //String file = "C:\\Users\\mmerk\\eclipse-workspace\\Assignments4CS021\\Accounts.csv";  
		 
		 ReadAccounts readAcc = new ReadAccounts(file);
		 LinkedList<String> fnList = readAcc.getFirstName();
		 LinkedList<String> LnList = readAcc.getLastName();
		 LinkedList<Integer> accNumList = readAcc.getAccountNum();
		 LinkedList<Integer> balanceList = readAcc.getBalances();
        
		 for (int i = 0; i < fnList.size(); i++){
			 accounts.add(new Account(fnList.get(i), LnList.get(i), accNumList.get(i), balanceList.get(i) ));
		 }
		
		 for (int i = 0; i < fnList.size(); i++){
			 
			 a +=  accounts.get(i).getFirstName() + " " + 
			       accounts.get(i).getLastName()  + " " + 
			       accounts.get(i).getAccountNum()  + " £" +
			       accounts.get(i).getBalance()  + " " +
			       "    ";
		 }
		 
		 //System.out.println(a);	
		showAllData = new JLabel();
		showAllData.setBounds(50, 60, 400, 100);
		add(showAllData);
		
		showAllData = new JLabel("Data will be shown here");
		showAllData.setBounds(210, 10, 800, 30);
		add(showAllData);
		
		showAllButton = new JButton("Show All");
		showAllButton.setBounds(50, 10, 100, 30);
		add(showAllButton);
        showAllButton.addActionListener(this);


	    depositButton = new JButton("Deposit");
	    depositButton.setBounds(370, 50, 100, 30);
	    add(depositButton);
	    depositButton.addActionListener(this);
	       
	    accDeposit = new JTextField("Account number Deposit");
	    accDeposit.setBounds(50, 50, 150, 30);
	    add(accDeposit);
		
	    depositInput = new JTextField("Enter amount to deposi");
	    depositInput.setBounds(210, 50, 150, 30);
	    add(depositInput);

	    withdrawButton = new JButton("Withdraw");
	    withdrawButton.setBounds(370, 90, 100, 30);
	    add(withdrawButton);
	    withdrawButton.addActionListener(this);

	    accWithdraw = new JTextField("Account number Withdraw");
	    accWithdraw.setBounds(50, 90, 150, 30);
	    add(accWithdraw);


	    withdrawInput = new JTextField("Enter amount to withdraw");
	    withdrawInput.setBounds(210, 90, 150, 30);
	    add(withdrawInput);

	       
	    transferButton = new JButton("Transfer");
	    transferButton.setBounds(540, 130, 100, 30);
	    add(transferButton);
	    transferButton.addActionListener(this);


	    acc1Transfer = new JTextField("Enter account number 1");
	    acc1Transfer.setBounds(50, 130, 150, 30);
	    add(acc1Transfer);


	    acc2Transfer = new JTextField("Enter account number 2");
	    acc2Transfer.setBounds(210, 130, 150, 30);
	    add(acc2Transfer);


	    transferAmount = new JTextField("Enter transfer Amount");
	    transferAmount.setBounds(370, 130, 150, 30);
	    add(transferAmount);


	        
		showAllButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showAllData.setText(a);
		}
		});
		
		depositButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int targetValue = Integer.parseInt(accDeposit.getText());
						 for (int i = 0; i < accNumList.size(); i++) {
					            int currentValue = accNumList.get(i);
					            if (currentValue == targetValue) {
					                if (i + 1 < accNumList.size()) {
					                    int nextValue = accNumList.get(i + 1);
					                    accounts.get(i).deposit(Integer.parseInt(depositInput.getText()));
					                }
					                else {
					                	accounts.get(i).deposit(Integer.parseInt(depositInput.getText()));
					                }
					                break; 
					            }
					        }	
						 a = "";
						 for (int i = 0; i < fnList.size(); i++){
							 
							 a +=  accounts.get(i).getFirstName() + " " + 
							       accounts.get(i).getLastName()  + " " + 
							       accounts.get(i).getAccountNum()  + " £" +
							       accounts.get(i).getBalance()  + " " +
							       "    ";
						 }
				showAllData.setText(a);
		}
		});
	
	
	withdrawButton.addActionListener(new ActionListener(){
	    @Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	    	int targetValue = Integer.parseInt(accWithdraw .getText());
	    	for (int i = 0; i < accNumList.size(); i++) {
	            int currentValue = accNumList.get(i);
	            if (currentValue == targetValue) {
	                if (i + 1 < accNumList.size()) {
	                    int nextValue = accNumList.get(i + 1);
	                    accounts.get(i).withdraw(Integer.parseInt( withdrawInput.getText()));
	                }
	                else {
	                	accounts.get(i).withdraw(Integer.parseInt( withdrawInput.getText()));
	                }
	                break; 
	            }
	        }	
		 a = "";
		 for (int i = 0; i < fnList.size(); i++){
			 
			 a +=  accounts.get(i).getFirstName() + " " + 
			       accounts.get(i).getLastName()  + " " + 
			       accounts.get(i).getAccountNum()  + " £" +
			       accounts.get(i).getBalance()  + " " +
			       "    ";
		 }
		 showAllData.setText(a);

		}
	});
	transferButton.addActionListener(new ActionListener(){
        
        
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
    	int targetValue = Integer.parseInt(acc1Transfer.getText());
    	int targetValue1 = Integer.parseInt(acc2Transfer.getText());
    	
    	int ftargetValue = 0;
    	boolean bftargetValue = false;
    	
    	int ftargetValue1 = 0;
    	boolean bftargetValue1 = false;
    	
    	for (int i = 0; i < accNumList.size(); i++) {
            int currentValue = accNumList.get(i);
            if (currentValue == targetValue) {
                if (i + 1 < accNumList.size()) {
                    int nextValue = accNumList.get(i + 1);
                    ftargetValue = i;
                    bftargetValue = true; 
                }
                else {
                    ftargetValue = i;
                    bftargetValue = true; 
                }
                break; 
            }
            
        }	
    	for (int i = 0; i < accNumList.size(); i++) {
            int currentValue1 = accNumList.get(i);
            if (currentValue1 == targetValue1) {
                if (i + 1 < accNumList.size()) {
                    int nextValue1 = accNumList.get(i + 1);
                    ftargetValue1 = i;
                    bftargetValue1 = true; 
                }
                else {
                    ftargetValue1 = i;
                    bftargetValue1 = true; 
                }
                break; 
            }
            
        }
    	
    	if(bftargetValue1 &&  bftargetValue)
    	{
    		accounts.get(ftargetValue).withdraw(Integer.parseInt(transferAmount.getText()));
    		accounts.get(ftargetValue1).deposit(Integer.parseInt(transferAmount.getText()));
    		
    		bftargetValue1 = false;
    		bftargetValue = false;
    	}
	 a = "";
	 for (int i = 0; i < fnList.size(); i++){
		 
		 a +=  accounts.get(i).getFirstName() + " " + 
		       accounts.get(i).getLastName()  + " " + 
		       accounts.get(i).getAccountNum()  + " £" +
		       accounts.get(i).getBalance()  + " " +
		       "    ";
	 }
showAllData.setText(a);
}
});
}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

	

