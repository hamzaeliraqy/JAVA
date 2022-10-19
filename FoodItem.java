import java.util.Scanner;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * This class contains the variables to add items and to compare, update and
 * print Student Name: Hamza El iraqy Student Number: 40976448 Course: CST8130 -
 * Data Structures : CET-CS-Level 3
 * 
 * @author Hamza Eliraqy
 */
public class FoodItem {

	protected int itemCode;
	protected String itemName;
	protected float itemPrice;
	protected int itemQuantityInStock;
	protected float itemCost;
	protected String orchardName;
	protected int jarSize;
	protected String farmName;
	protected LocalDate date;

	public FoodItem() {

	}

	/*
	 * Print the variables
	 */
	public String toString() {

		return "itemCode: " + itemCode + " " + itemName + " itemCost: $" + itemCost + " itemPrice: $" + itemPrice
				+ " itemQuantity: " + itemQuantityInStock;
	}

	/*
	 * Takes in param amount and compares it to itemQuantityInStock and adds to it
	 */
	public boolean updateItem(int amount) {

		if (amount < 0) {
			if (amount <= itemQuantityInStock) {

				itemQuantityInStock += amount;
				if (itemQuantityInStock < 0) {
					itemQuantityInStock = 1;
					return false;
				} else {
					return true;
				}

			}
		} else {

			itemQuantityInStock += amount;
			if (itemQuantityInStock < 0) {
				itemQuantityInStock = 1;
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	/*
	 * Template for the extending classes
	 */
	public boolean addItem(Scanner scanner) {

		try {

		} catch (NullPointerException e) {
			System.out.println("Array Error");
		} catch (InputMismatchException b) {
			System.out.println("Invalid Entry");
		}

		return true;

	}

	/*
	 * Takes in itemCode, used in Inventory
	 */
	public boolean inputCode(Scanner scanner) {

		try {

			System.out.println("Enter item code: ");
			this.itemCode = scanner.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("Invalid Entry");
			scanner.next();
		}

		return true;
	}

	/*
	 * Compares the used inputed itemCode with the itemCode in Inventory
	 */
	public boolean isEqual(FoodItem item) {

		if (item.itemCode == this.itemCode) {
			return true;
		}

		return false;
	}

}
