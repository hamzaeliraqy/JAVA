// Made by Hamza El iraqy
// Section 320
// Professor Jason Mombourquette

import java.util.Scanner;

public class StudentTest {

public static Scanner input;

	public static void main(String[] args) {
		 
	    int numS;
		Student Student = new Student();
		Student.displayTitle();
		input = new Scanner(System.in);
		System.out.println("Enter the number of students: ");
	    numS = input.nextInt();
		if (numS <= 0) {
			System.out.println("Please re-enter a correct number of students: ");
			numS = input.nextInt();
		}
	    
		for (int i = 0; i ==0; i++) {
			
			System.out.println("Enter details of student " + (i+1));
			Student.readStudentDetails();
			Student.calculateGpa();
			Student.findGradeLetter();
			numS--;
			i++;
			Student.displayHeader();
			  Student.displayStudentDetails();
			  if (numS == 0) {
				  Student.displayHeader();
				  Student.displayStudentDetails();
				  break;
			  }
			  
				
			
			
		}
		
	}
}
		
		
		
		
		
		 
		
		
		 
		
		 

		 
		 
		 
		     
			
		
 			
 		


