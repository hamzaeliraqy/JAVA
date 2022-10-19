import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Bank {
	static Scanner input = new Scanner(System.in).useDelimiter(System.lineSeparator());
	List<Client> clients = new ArrayList<Client>();
	protected String bankName;
	public Bank() {
		
	}
	
	public boolean addClient() {
		
		Client client = new Client();
		
		client.addClient();
		clients.add(client);
		
		return false;
	}
	
	public String toString() {
		try {
		System.out.println("Bank Information:");
		if(bankName == null) {
			bankName = "Unknown";
			System.out.println("Name: " + bankName );
		}
		else {
			System.out.println("Name: " + bankName);
		}
		System.out.println("Client List:");
		if(clients.isEmpty()) {
			System.out.println("No Clients in Bank");
		}
		else {
			Client c;
			for (int i = 0; i < clients.size(); i++) {

				for (int j = clients.size() - 1; j > i; j--) {

					if (clients.get(i).clientNumber > clients.get(j).clientNumber) {
						
						c = clients.get(i);
						clients.set(i, clients.get(j));
						clients.set(j, c);
						
					}
				}

			}
			
		for(int i = 0; i < clients.size(); i++) {
			System.out.println(clients.get(i).toString());
		}
		}
		}catch(NullPointerException e) {
			System.out.println("Error");
		}
		return "";
	}
	
	public void setBankName() {
		try {
		System.out.println("Please Enter the Bank's Name: ");
		bankName = input.next();
		}catch(InputMismatchException b) {
			System.out.println("Invalid Entry");
		}
	}
	
	public void findClient() {
		try {
		int inputCode;
		int index = 0;
		boolean found = false;
		System.out.println("Please Enter the Client Number to Search for: ");
		inputCode = input.nextInt();
		if(inputCode != 0) {
			for(int j = 0; j < clients.size(); j++) {
				if(clients.get(j).clientNumber == inputCode) {
					index = j;
					found = true;
					break;
				}
			}
			if(found == true) {
				System.out.println("Client found at index " + index);
				System.out.println(clients.get(index).toString());
			}
			if(found == false) {
				System.out.println("Client not found in Bank");
			}
			
		}
		
		}catch(NullPointerException n) {
			System.out.println("Error");
		}
	}

}
