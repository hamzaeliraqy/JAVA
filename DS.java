import java.util.ArrayList;
import java.util.Scanner;
/**
 * Main Method Add String using hash method and finds the String
 
 * @author Hamza Eliraqy
 */
public class Lab8 {
	static Scanner input = new Scanner(System.in);
	static ArrayList<String> dataItems = new ArrayList<String>();
	static String[] dataItem = new String[100];
	/*
	 * Menu Displayed to user until inputed 3
	 */
	public static void main(String[] args) {
		int choice;
		do {
		choice = 0;
		System.out.println("1- Add a String");
		System.out.println("2- Seach for a String");
		System.out.println("3- Exit");
		choice = input.nextInt();
		switch(choice){
			case 1:
				System.out.println("Enter a String: ");
				String word = input.next();
				addString(word);   			//Calls addString method with user input
				break;
			case 2:
				System.out.println("Enter the String to find");
				String find = input.next();
				findString(find);			//Calls findString method with user input
				break;
			case 3:
				System.out.println("Exiting..");
				break;
			default:
				System.out.println("Invalid Entry");
		}
		}while(choice != 3);

	}
	/*
	 * Get hashCode of String and first number and second number
	 * output used as index in ArrayList
	 * @param String used inside method
	 */
	public static void addString(String word) {
			if(word != null) {
				
				int hashindex = word.hashCode();
				int firstDigit = Integer.parseInt(Integer.toString(hashindex).substring(0, 1));
				int secondDigit = Integer.parseInt(Integer.toString(hashindex).substring(1, 2));
				int index = (firstDigit + secondDigit) % 100;
				dataItem[index] = word;
			
			}
	}
	/*
	 * Loops through ArrayList to find String match
	 * @param String used inside method
	 */
	public static void findString(String find) {
			if(find != null) {
				boolean found = false;
				for(int i = 0; i < dataItem.length; i++) {
					if(find.equals(dataItem[i])) {
						System.out.println("String found at index " + i);
						found = true;
					}
					
				}
				if(found == false) {
					System.out.println("String not found");
				}
			}
	}

}
