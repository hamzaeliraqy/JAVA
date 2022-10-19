import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main Method 
 * 
 * @author Hamza Eliraqy
 */
public class Assign1 {

	static Scanner input = new Scanner(System.in).useDelimiter(System.lineSeparator());
	static LocalDate date;

	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		try {
			int choice;
			do {

				choice = 0;
				System.out.println("Please select one of the following: ");
				System.out.println("1: Add Item to Inventory");
				System.out.println("2: Display Current Inventory");
				System.out.println("3: Buy Item(s)");
				System.out.println("4: Sell Item(s)");
				System.out.println("5: Search for Item");
				System.out.println("6: Remove Expired Items");
				System.out.println("7: Print Expiry");
				System.out.println("8: Change Today's Date");
				System.out.println("9: To Exit");

				choice = input.nextInt();

				switch (choice) {

				case 1:
					inventory.addItem(input);
					break;

				case 2:
					inventory.toString();
					break;

				case 3:
					inventory.updateQuantity(input, true);
					break;

				case 4:
					inventory.updateQuantity(input, false);
					break;

				case 5:
					inventory.outputData(input);
					break;
				case 6:
					inventory.removeExpiredItems(date);
					break;
				case 7:
					inventory.printExpirySummary();
					break;
				case 8:
					System.out.println("Please enter today's date (yyyy-mm-dd)");
					String datee = input.next();
					date = LocalDate.parse(datee);
					break;
				case 9:
					System.out.println("Exiting..");
					break;
				default:
					System.out.println("Invalid Entry");
					break;

				}

			} while (choice != 9);

		} catch (InputMismatchException e) {
			System.out.println("Invalid Entry1");
			input.next();
		} catch (DateTimeParseException e) {
			System.out.println("Enter a valid date");
		}

	}

}
