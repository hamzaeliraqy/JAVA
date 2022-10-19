/**
 * Represents the Binary Tree data structure
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 *
 */
public class BinaryTree {

	/**
	 * Reference to the root Node of the tree
	 */
	BinaryTreeNode root = null;
	int j;
	int a;
	int size;
	BinaryTreeNode bTreeNode = new BinaryTreeNode();
	/**
	 * Insert the data into the tree
	 * @param newData New int to store in the tree
	 */
	public void insertInTree (int newData) {
		if (root == null) 
			root = new BinaryTreeNode(newData);
		else 
			root.insert(newData);
	}

	/**
	 * Method to display the contents of the tree
	 */
	public void displayInOrder () {
		displayInOrder (root);
		System.out.println("\n");
	}
	
	/**
	 * Traverse the tree using InOrder traversal and display the content to the console
	 * @param subRoot The node to start with
	 */
	private void displayInOrder (BinaryTreeNode subRoot){
		if (subRoot == null)   
			return;
		displayInOrder (subRoot.getLeft());
		System.out.print(" " + subRoot.getData() + " ");
		displayInOrder (subRoot.getRight());
	}
	
	public int treeHeight (BinaryTreeNode newRoot){
		
		if(newRoot == null) {
			return 0;
		}
		a = treeHeight(newRoot.getLeft());
		j = treeHeight(newRoot.getRight());
		
		
		if(j >= a) {
			size = 1 + j;
		}
		if(a >= j) {
			size = 1 + a;
		}
		
		return size;
		
	}
	
	public void displayHeight() {
		System.out.println("Tree Height is : " + (treeHeight(root) + 1));
	}

	
}
