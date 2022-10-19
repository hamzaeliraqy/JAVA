import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

/**
 * This class contains function to operate the inventory of FoodItem
 * 
 * @author Hamza Eliraqy
 */
public class Inventory {

	ArrayList<FoodItem> inventory = new ArrayList<FoodItem>();

	int j;
	ArrayList<String> itemType = new ArrayList<String>();
	ArrayList<LocalDate> exp = new ArrayList<LocalDate>();
	Scanner input = new Scanner(System.in).useDelimiter(System.lineSeparator());
	ArrayList<Integer> qty = new ArrayList<Integer>();
	ArrayList<Integer> item = new ArrayList<Integer>();
	LinkedList<LocalDate> expiries = new LinkedList<>();

	public Inventory() {

	}

	/*
	 * Print the inventory contents and uses numItems as a loop control
	 */
	public String toString() {

		try {

			FoodItem f;
			System.out.println("Inventory: ");
			for (int i = 0; i < inventory.size(); i++) {

				for (int j = inventory.size() - 1; j > i; j--) {

					if (inventory.get(i).itemCode > inventory.get(j).itemCode) {

						f = inventory.get(i);
						inventory.set(i, inventory.get(j));
						inventory.set(j, f);

					}
				}

			}
			for (int i = 0; i < inventory.size(); i++) {

				System.out.println(inventory.get(i).toString());
			}

		} catch (NullPointerException e) {
			System.out.println("Print error");
		}

		return "";
	}

	/*
	 * find the index for the required itemCode
	 */
	public int alreadyExists(FoodItem item) {
		try {
			for (int i = 0; i < inventory.size(); i++) {

				if (inventory.get(i).isEqual(item)) {

					return i;

				}
			}
		} catch (NullPointerException e) {
			System.out.println("Inventory error");
		}

		return -1;
	}

	/*
	 * Called in main method to add Items
	 */
	public boolean addItem(Scanner scanner) {

		try {

			System.out.println("Do you wish to add a fruit(f), vegetable(v) or a preserve(p) ?");
			String c = input.next();

			FoodItem foodItem = null;

			if (c.contains("f")) {
				foodItem = new Fruit();
				LocalDate date;
				if (foodItem.addItem(scanner) == true) {

					itemType.add(c);
					inventory.add(foodItem);
					System.out.println("Enter the expiry date of the item (yyyy-mm-dd or none): ");
					String datee = scanner.next();
					if (datee.equals("none")) {
						date = LocalDate.MAX;
						expiries.add(date);
					} else {
						date = LocalDate.parse(datee);
						expiries.add(date);
					}

				}

			}

			if (c.contains("v")) {
				foodItem = new Vegetable();
				LocalDate date;
				if (foodItem.addItem(scanner) == true) {

					itemType.add(c);
					inventory.add(foodItem);
					System.out.println("Enter the expiry date of the item (yyyy-mm-dd or none): ");
					String datee = scanner.next();
					if (datee.equals("none")) {
						date = LocalDate.MAX;
						expiries.add(date);
					} else {
						date = LocalDate.parse(datee);
						expiries.add(date);
					}
				}
			}

			if (c.contains("p")) {
				LocalDate date;
				foodItem = new Perserve();
				if (foodItem.addItem(scanner) == true) {

					itemType.add(c);
					inventory.add(foodItem);
					System.out.println("Enter the expiry date of the item (yyyy-mm-dd or none): ");
					String datee = scanner.next();
					if (datee.equals("none")) {
						date = LocalDate.MAX;
						expiries.add(date);
					} else {
						date = LocalDate.parse(datee);
						expiries.add(date);
					}
				}

			}

		} catch (NullPointerException e) {
			System.out.println("Array error");
		} catch (InputMismatchException b) {
			System.out.println("Invalid Entry");
			input.next();
		} catch (DateTimeParseException e) {
			System.out.println("Enter a valid date format");
		}

		return true;
	}

	/*
	 * Verify that the itemCode exists and take in the new quantity after user input
	 * and the expiry of that quantity
	 * 
	 * @param true for buy, false for sell
	 */
	public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
		FoodItem fi = new FoodItem();
		int qt = 0;
		int index = 0;
		LocalDate date;
		int i = 0;

		boolean output = fi.inputCode(input);
		alreadyExists(fi);
		index = alreadyExists(fi);

		if (index == -1) {
			System.out.println("Not Found!");
			return false;
		}
		try {
			if (output == true) {
				System.out.println("Enter a quantity: ");
				qt = input.nextInt();

				while (qt < 0) {
					System.out.println("Enter a positive quantity: ");
					qt = input.nextInt();
				}

			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid Entry");
			input.next();
		}
		if (buyOrSell == true) {
			try {
				System.out.println("Enter the expiry date of the item (yyyy-mm-dd or none): ");
				String datee = scanner.next();
				date = LocalDate.parse(datee);
				exp.add(date);
				i = fi.itemCode;
				item.add(i);
				qty.add(qt);

				inventory.get(index).updateItem(qt);

				System.out.println("Done!");
			} catch (DateTimeParseException e) {
				System.out.println("Enter a valid date format");
			}

		}

		if (buyOrSell == false) {
			inventory.get(index).updateItem(-qt);
			if (inventory.get(index).updateItem(-qt) == true) {
				System.out.println("Done!");
			} else {
				System.out.println("Error.. Could not sell");
			}

		}

		return true;
	}

	/*
	 * Save content of inventory to a file
	 */
	public void saveToFile(Scanner input) {
		try {
			System.out.println("Enter file name");
			String fileName = input.next(); // the destination file name
			int a = 0;
			String b = "";
			int c = 0;
			float d = 0;
			float e = 0;
			String f = "";
			String g = "l";
			int h = 0;
			String l = "l";
			FileWriter setV = new FileWriter(fileName + ".txt");

			// gets every element in inventory by index
			for (int i = 0; i < inventory.size(); i++) {

				a = inventory.get(i).itemCode;
				b = inventory.get(i).itemName;
				c = inventory.get(i).itemQuantityInStock;
				d = inventory.get(i).itemCost;
				e = inventory.get(i).itemPrice;
				f = itemType.get(i).toString();

				setV.write("\n");
				setV.write("\n" + f);
				setV.write("\n" + a);
				setV.write("\n" + b);
				setV.write("\n" + c);
				setV.write("\n" + d);
				setV.write("\n" + e);

				if (f.equals("v")) {
					g = inventory.get(i).farmName;
					setV.write("\n" + g);
				}
				if (f.equals("f")) {
					g = inventory.get(i).orchardName;
					setV.write("\n" + g);
				}
				if (f.equals("p")) {
					h = inventory.get(i).jarSize;
					setV.write("\n" + h);
				}
			}

			setV.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");

		} catch (IOException b) {
			System.out.println("Error");
		}

	}

	/*
	 * Read items for a file and adds them to inventory
	 */
	public void readToFile(Scanner input) {

		try {

			FoodItem w = new FoodItem();

			System.out.println("Enter file name");
			String fileName = input.next(); // source file name
			Scanner scanner = new Scanner(new File(fileName + ".txt"));

			// Reads every line in file and add every element to its specific variable

			while (scanner.hasNextLine()) {
				boolean exists = false;
				int a = 0;
				String b = "";
				int c = 0;
				float d = 0;
				float e = 0;
				String f = "";

				if (scanner.hasNext()) {
					b = scanner.next();
					itemType.add(b);
					if (b.equals("f")) {
						w = new Fruit();
						if (scanner.hasNextInt()) {
							a = scanner.nextInt();
							w.itemCode = a;
							for (int i = 0; i < inventory.size(); i++) {
								if (a == inventory.get(i).itemCode) {
									exists = true;
								}
							}
							scanner.nextLine();
						}
						if (scanner.hasNext()) {
							f = scanner.next();
							w.itemName = f;
							scanner.nextLine();
						}
						if (scanner.hasNextInt()) {
							c = scanner.nextInt();
							w.itemQuantityInStock = c;
							scanner.nextLine();
						}
						if (scanner.hasNextFloat()) {
							d = scanner.nextFloat();
							w.itemCost = d;
							scanner.nextLine();
						}
						if (scanner.hasNextFloat()) {
							e = scanner.nextFloat();
							w.itemPrice = e;
							scanner.nextLine();
						}
						if (exists == false) {
							inventory.add(w);
						}
						if (exists == true) {
							System.out.println("Duplicate Item, Aborting..");
							break;
						}

					}
					if (b.equals("p")) {
						w = new Perserve();
						if (scanner.hasNextInt()) {
							a = scanner.nextInt();
							w.itemCode = a;
							for (int i = 0; i < inventory.size(); i++) {
								if (a == inventory.get(i).itemCode) {
									exists = true;
								}
							}
							scanner.nextLine();
						}
						if (scanner.hasNext()) {
							f = scanner.next();
							w.itemName = f;
							scanner.nextLine();
						}
						if (scanner.hasNextInt()) {
							c = scanner.nextInt();
							w.itemQuantityInStock = c;
							scanner.nextLine();
						}
						if (scanner.hasNextFloat()) {
							d = scanner.nextFloat();
							w.itemCost = d;
							scanner.nextLine();
						}
						if (scanner.hasNextFloat()) {
							e = scanner.nextFloat();
							w.itemPrice = e;
							scanner.nextLine();
						}
						if (exists == false) {
							inventory.add(w);
						}
						if (exists == true) {
							System.out.println("Duplicate Item, Aborting..");
							break;
						}

					}
					if (b.equals("v")) {
						w = new Vegetable();
						if (scanner.hasNextInt()) {
							a = scanner.nextInt();
							w.itemCode = a;
							for (int i = 0; i < inventory.size(); i++) {
								if (a == inventory.get(i).itemCode) {
									exists = true;
								}
							}
							scanner.nextLine();
						}
						if (scanner.hasNext()) {
							f = scanner.next();
							w.itemName = f;
							scanner.nextLine();
						}
						if (scanner.hasNextInt()) {
							c = scanner.nextInt();
							w.itemQuantityInStock = c;
							scanner.nextLine();
						}
						if (scanner.hasNextFloat()) {
							d = scanner.nextFloat();
							w.itemCost = d;
							scanner.nextLine();
						}
						if (scanner.hasNextFloat()) {
							e = scanner.nextFloat();
							w.itemPrice = e;
							scanner.nextLine();
						}
						if (exists == false) {
							inventory.add(w);
						}
						if (exists == true) {
							System.out.println("Duplicate Item, Aborting..");
							break;
						}

					}

				}

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (NoSuchElementException f) {

		}
	}

	/*
	 * Find inventory element by itemCode
	 */
	public void outputData(Scanner input) {
		FoodItem fi = new FoodItem();

		fi.inputCode(input);
		int index = 0;
		alreadyExists(fi);
		index = alreadyExists(fi);
		if (index != -1) {
			System.out.println(inventory.get(index).toString());
			System.out.println(expiries.get(index).toString());
		}

	}

	/*
	 * checks if itemCode exists and print summary on quantity and it's expiration
	 * date
	 */
	public void printExpirySummary() {
		FoodItem fi = new FoodItem();
		boolean exists = false;
		fi.inputCode(input);
		int itemCode = fi.itemCode;
		int index = 0;
		int i = 0;
		alreadyExists(fi);
		index = alreadyExists(fi);
		if (index != -1) {
			System.out.println(inventory.get(index).toString());
			for (i = 0; i < item.size(); i++) {
				if (item.get(i).equals(itemCode)) {
					exists = true;
					break;
				}
			}
			if (exists == true) {
				System.out.println(expiries.get(index).toString() + " : "
						+ (inventory.get(index).itemQuantityInStock - qty.get(i)));
				System.out.println(exp.get(i).toString() + " : " + qty.get(i));
			}
			if (exists == false) {
				System.out.println(expiries.get(index).toString() + " : " + inventory.get(index).itemQuantityInStock);
			}
		}

	}

	/*
	 * Compare today's date entered in main with the expiries of items in inventory
	 * if they're older they get removed from inventory
	 */
	public void removeExpiredItems(LocalDate today) {
		try {
			boolean change = false;

			for (int i = 0; i < expiries.size(); i++) {
				if (expiries.get(i).isBefore(today) == true) {

					inventory.remove(i);
					change = true;

				} else {
					break;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("System Error");
		}

	}

}
