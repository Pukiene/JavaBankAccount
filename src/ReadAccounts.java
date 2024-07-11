import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReadAccounts {

    public String url = "C:\\Users\\mmerk\\eclipse-workspace\\Assignments4CS021\\Accounts.csv"; // Path to CSV file
    
   public ReadAccounts(String csvPath) { // Constructor csvPath
       this.url = csvPath;
   }

	    public LinkedList<String> getFirstName(/*String url*/) throws FileNotFoundException, IOException {
	        LinkedList<String> firstNames = new LinkedList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
	            br.readLine(); 
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(",");
	                firstNames.add(values[0]);
	            }
	        }
	        return firstNames;
	    }

	    public LinkedList<String> getLastName(/*String url*/) throws FileNotFoundException, IOException {
	        LinkedList<String> Last_name = new LinkedList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
	            String line;
	            br.readLine(); 
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(",");
	                Last_name.add(values[1]);
	            }
	        }
	        return Last_name;
	    }

	    public LinkedList<Integer> getAccountNum(/*String url*/) throws FileNotFoundException, IOException {
	        LinkedList<Integer> accountNumber = new LinkedList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
	            String line;
	            br.readLine(); 
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(",");
	                accountNumber.add(Integer.parseInt(values[2]));
	            }
	        }
	        return accountNumber;
	    }

	    public LinkedList<Integer> getBalances(/*String url*/) throws FileNotFoundException, IOException {
	        LinkedList<Integer> balance = new LinkedList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
	            String line;
	            br.readLine(); 
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(",");
	                balance.add(Integer.parseInt(values[3]));
	            }
	        }
	        return balance;
	    }
	}


