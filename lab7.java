import java.util.Scanner;

public class lab7 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int choice;
		BinaryTreeNode bTreeNode = new BinaryTreeNode();
		
		BinaryTree bTree = new BinaryTree();
		do {
		choice = 0;
		BinaryTreeExample.displayMenu();
		choice = input.nextInt();
		
		switch(choice) {
		
		case 1:
			System.out.println("Enter an Integer to add to the Tree: ");
			int number = input.nextInt();
			bTree.insertInTree(number);
			break;
		case 2:
			bTree.displayInOrder();
			break;
		case 3:
			bTree.displayHeight();
			
			break;
		case 4:
			System.out.println("Exiting..");
			break;
		default:
			System.out.println("Invalid Entry");
			break;
		}
		
		}while(choice != 4);
		
	}

}
