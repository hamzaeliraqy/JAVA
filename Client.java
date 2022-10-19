import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
	static Scanner input = new Scanner(System.in).useDelimiter(System.lineSeparator());
	protected String clientName;
	protected int clientNumber;
	protected float clientBalance;

	public Client() {
		
		
	}
	
	public boolean addClient() {
		try {
		System.out.println("Please Enter the Client's Name: ");
		clientName = input.next();
		System.out.println("Please Enter the Client Number: ");
		clientNumber = input.nextInt();
		System.out.println("Please Enter the Client's Balance: ");
		clientBalance = input.nextFloat();
		}catch(InputMismatchException e) {
			System.out.println("Invalid Entry");
		}
	
	return true;	
	}
	
	public String toString() {
		
		return "Client #: " + clientNumber + ", Name: " + clientName + ", Balance: $" + clientBalance;
	}
}
