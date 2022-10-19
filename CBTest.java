import java.util.InputMismatchException;
import java.util.Scanner;

public class LabTest {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int choice;
		Bank bk = new Bank();
		
		
		do {
			choice = 0;
			try {
				
			System.out.println("Please select one of the following:");
			System.out.println("1: Add Client to Bank");
			System.out.println("2: Display Clients in the Bank");
			System.out.println("3: Set Bank Name");
			System.out.println("4: Search for a Client");
			System.out.println("5: Exit");
			choice = input.nextInt();
				
			switch(choice) {
			
			case 1:
					bk.addClient();
				break;
			case 2:
					bk.toString();
				break;
			case 3:
					bk.setBankName();
				break;
			case 4:
					bk.findClient();
				break;
			case 5:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid Entry");
				break;
				
			}
			}catch(InputMismatchException e) {
				System.out.println("Your choice is invalid");
				input.next();
			}
		
		}while(choice != 5);
		
		
	}
	
}
