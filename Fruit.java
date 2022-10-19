import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * This class contains the variables to add items and it extends FoodItem
 * Student Name: Hamza El iraqy Student Number: 40976448 Course: CST8130 - Data
 * Structures : CET-CS-Level 3
 * 
 * @author Hamza Eliraqy
 */
public class Fruit extends FoodItem {

	public Fruit() {

	}

	public String toString() {

		return super.toString() + " Orchard Name: " + orchardName;
	}

	/*
	 * Takes input from scanner and added to FoodItem variables
	 */
	public boolean addItem(Scanner scanner) {
		try {
			System.out.println("Enter the code for the item: ");
			if (scanner.hasNextInt()) {
				this.itemCode = scanner.nextInt();
			} else {
				scanner.next();
				System.out.println("Invalid Code");
				System.out.println("Enter the code for the item: ");
				this.itemCode = scanner.nextInt();
			}
			System.out.println("Enter the name for the item: ");
			this.itemName = scanner.next();

			System.out.println("Enter the cost of the item: ");
			this.itemCost = scanner.nextFloat();
			if (itemCost < 0) {

				System.out.println("Invalid Cost");
				System.out.println("Enter the cost of the item: ");
				this.itemCost = scanner.nextFloat();
			}

			System.out.println("Enter the sales price of the item: ");
			this.itemPrice = scanner.nextFloat();
			if (itemPrice < 0) {

				System.out.println("Invalid Price");
				System.out.println("Enter the price of the item: ");
				this.itemPrice = scanner.nextFloat();
			}

			System.out.println("Enter the Orchard Name: ");
			orchardName = scanner.next();

			System.out.println("Enter the quantity for the item: ");
			this.itemQuantityInStock = scanner.nextInt();

			if (itemQuantityInStock < 0) {

				System.out.println("Invalid Quantity");
				System.out.println("Enter the quantity for the item: ");
				this.itemQuantityInStock = scanner.nextInt();
			}

		} catch (InputMismatchException e) {
			System.out.println("Invalid Entry");
			scanner.next();
			return false;
		}
		return true;

	}

}
