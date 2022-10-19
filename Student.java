
// Made by Hamza El iraqy
// Section 320
// Professor Jason Mombourquette

import java.lang.Double;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Student {

	long studNumber;
	String firstName, lastName, letGrade;
	double totalMarks, totalBonus, gpa, percMarks, numS;
	final int NUMBER_MARKS = 3;
	Double[] Marks = new Double[NUMBER_MARKS];
	public Scanner input;

	Student() {

		input = new Scanner(System.in);
	}

	// get student details
	public void readStudentDetails() {

		System.out.println("-------------------------------------");
		System.out.println("Enter student number: ");
		studNumber = input.nextLong();
		System.out.println("Enter student first name: ");
		firstName = input.next();
		System.out.println("Enter student last name: ");
		lastName = input.next();

		readMarks();

	}

	// gets student marks and check if they're within the limit
	private void readMarks() {

		System.out.println("Enter student marks");
		System.out.println("-------------------------------------");
		System.out.println("Enter the first mark: ");
		Marks[0] = input.nextDouble();
		if (Marks[0] < 0 || Marks[0] > 100) {
			System.out.println("Error you entered an invalid mark!");
			System.out.println("Enter the first mark: ");
			Marks[0] = input.nextDouble();
		}
		System.out.println("Enter the second mark: ");
		Marks[1] = input.nextDouble();
		if (Marks[1] < 0 || Marks[1] > 100) {
			System.out.println("Error you entered an invalid mark!");
			System.out.println("Enter the second mark: ");
			Marks[1] = input.nextDouble();
		}
		System.out.println("Enter the third mark: ");
		Marks[2] = input.nextDouble();
		if (Marks[2] < 0 || Marks[2] > 100) {
			System.out.println("Error you entered an invalid mark!");
			System.out.println("Enter the third mark: ");
			Marks[2] = input.nextDouble();
		} else {
			readBonuses();
		}

	}

	// asks how many bonuses and limit the bonuses to 75 which is 15*5
	private void readBonuses() {

		double a = 0, b1 = 0, b2 = 0, b3 = 0, b4 = 0, b5 = 0;
		System.out.println("Enter the number of bonuses: ");
		System.out.println("-------------------------------------");
		a = input.nextDouble();

		if (a == 0) {

		} else if (a == 1) {
			System.out.println("Enter bonus: ");
			b1 = input.nextDouble();
		} else if (a == 2) {
			System.out.println("Enter bonus1: ");
			b1 = input.nextDouble();
			System.out.println("Enter bonus2: ");
			b2 = input.nextDouble();
		} else if (a == 3) {
			System.out.println("Enter bonus1: ");
			b1 = input.nextDouble();
			System.out.println("Enter bonus2: ");
			b2 = input.nextDouble();
			System.out.println("Enter bonus3: ");
			b3 = input.nextDouble();

		} else if (a == 4) {
			System.out.println("Enter bonus1: ");
			b1 = input.nextDouble();
			System.out.println("Enter bonus2: ");
			b2 = input.nextDouble();
			System.out.println("Enter bonus3: ");
			b3 = input.nextDouble();
			System.out.println("Enter bonus4: ");
			b4 = input.nextDouble();
		} else if (a == 5) {
			System.out.println("Enter bonus1: ");
			b1 = input.nextDouble();
			System.out.println("Enter bonus2: ");
			b2 = input.nextDouble();
			System.out.println("Enter bonus3: ");
			b3 = input.nextDouble();
			System.out.println("Enter bonus4: ");
			b4 = input.nextDouble();
			System.out.println("Enter bonus5: ");
			b5 = input.nextDouble();
		} else if (a > 6) {
			System.out.println("Can't have more than five bonuses!");
			System.out.println("Enter bonus1: ");
			b1 = input.nextDouble();
			System.out.println("Enter bonus2: ");
			b2 = input.nextDouble();
			System.out.println("Enter bonus3: ");
			b3 = input.nextDouble();
			System.out.println("Enter bonus4: ");
			b4 = input.nextDouble();
			System.out.println("Enter bonus5: ");
			b5 = input.nextDouble();
		}

		totalBonus = b1 + b2 + b3 + b4 + b5;
		if (totalBonus > 75) {
			totalBonus = 75;
		}

	}

	// gets all the marks and calculate gpa if gpa is above 4 it will output as 4
	// and if any mark is 0 the gpa will be 0
	public void calculateGpa() {
		convertBonus();
		totalMarks = Marks[0] + Marks[1] + Marks[2] + totalBonus;

		gpa = (totalMarks / (NUMBER_MARKS * 100)) * 4;

		if (gpa >= 4) {
			gpa = 4;
		} else if (Marks[0] == 0) {
			gpa = 0;
		} else if (Marks[1] == 0) {
			gpa = 0;
		} else if (Marks[2] == 0) {
			gpa = 0;
		}
	}

	private void convertBonus() {

		if (totalBonus >= 15) {
			totalBonus = 15;
		}

		totalBonus = (totalBonus / 15) * 2;
	}

	private void calculatePercentage() {

		percMarks = (totalMarks / (NUMBER_MARKS * 100)) * 100;

	}

	public String findGradeLetter() {
		convertBonus();
		calculatePercentage();

		if (percMarks >= 90 && percMarks <= 100) {
			letGrade = "A+";

		} else if (percMarks >= 85 && percMarks <= 89) {
			letGrade = "A";
		} else if (percMarks >= 80 && percMarks <= 84) {
			letGrade = "A-";
		} else if (percMarks >= 77 && percMarks <= 79) {
			letGrade = "B+";
		} else if (percMarks >= 73 && percMarks <= 76) {
			letGrade = "B";
		} else if (percMarks >= 70 && percMarks <= 72) {
			letGrade = "B-";
		} else if (percMarks >= 67 && percMarks <= 69) {
			letGrade = "C+";
		} else if (percMarks >= 63 && percMarks <= 66) {
			letGrade = "C";
		} else if (percMarks >= 60 && percMarks <= 62) {
			letGrade = "C-";
		} else if (percMarks >= 57 && percMarks <= 59) {
			letGrade = "D+";
		} else if (percMarks >= 53 && percMarks <= 56) {
			letGrade = "D";
		} else if (percMarks >= 50 && percMarks <= 52) {
			letGrade = "D-";
		} else if (percMarks < 50)
			letGrade = "F";
		checkEligibility();
		return letGrade;

	}

	// if any marks are below 50 it prints out failed in one or more courses
	private boolean checkEligibility() {
		if (Marks[0] < 50) {
			System.out.println("NOTE: Failed in one or more courses");
			return false;
		} else if (Marks[1] < 50) {
			System.out.println("NOTE: Failed in one or more courses");
			return false;
		} else if (Marks[2] < 50) {
			System.out.println("NOTE: Failed in one or more courses");
			return false;
		} else {
			return true;
		}

	}

	// outputs all the students details
	public void displayStudentDetails() {
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(studNumber + "                  " + firstName + " " + lastName + "            "
				+ df.format(totalMarks) + "      " + df.format(gpa) + "          " + letGrade);
	}

	public static void displayTitle() {
		System.out.println("              GPA CALCULATOR           ");
		System.out.println("=======================================");

	}

	public static void displayHeader() {
		System.out.println("*********************************************************************************");
		System.out.println("                                  MARK LIST                                      ");
		System.out.println("*********************************************************************************");
		System.out.println("Student Number   |  Name    |    Total Marks   |    GPA    |    Grade Letter   | ");
		System.out.println("---------------------------------------------------------------------------------");
	}

}
