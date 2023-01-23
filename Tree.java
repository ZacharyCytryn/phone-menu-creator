/**
 * Zachary Cytryn
 * ID: 114283379
 * Email: zachary.cytryn@stonybrook.edu
 * Homework #4
 * CSE 214 Recitation 30
 */

package decisionMakerSystem;

/**
 * This class represents a tree, containing a root with the potential for each node to have at most three children
 * 
 * @author zacharycytryn
 */
public class Tree {
	
	private TreeNode root;
	private TreeNode cursor;
	
	/**
	 * Constructor for tree
	 * 
	 * @param prompt
	 * prompt for creation of the root
	 * @param message
	 * message for creation of the root
	 */
	public Tree(String prompt, String message) {
		root = new TreeNode("root", message, prompt);
		cursor = root;
	}
	
	/**
	 * Getter method for cursor (the specific TreeNode that the cursor is on)
	 * 
	 * @return
	 * cursor
	 */
	public TreeNode getCursor() {
		return cursor;
	}
	
	/**
	 * Setter method for cursor
	 * 
	 * @param cursor
	 * Desired TreeNode to place the cursor on
	 */
	public void setCursor(TreeNode cursor) {
		this.cursor = cursor;
	}
	
	/**
	 * Getter method for root TreeNode of tree
	 * 
	 * @return
	 * root
	 */
	public TreeNode getRoot() {
		return root;
	}
	
	/**
	 * Setter method for root TreeNode of tree
	 * 
	 * @param root
	 * Desired root to replace current root
	 */
	public void setRoot(TreeNode root) {
		this.root = root;
	}

	/**
	 * Adds TreeNode to the tree in the proper order
	 * 
	 * @param label
	 * label of added TreeNode
	 * @param prompt
	 * prompt of added TreeNode
	 * @param message
	 * message of added TreeNode
	 * @param parentLabel
	 * label of parent of TreeNode being added
	 * @return
	 * true if node has been added and false otherwise
	 */
	public boolean addNode(String label, String prompt, String message, String parentLabel) {
		TreeNode parentNode = this.searchNodes(root, parentLabel);
		if (parentNode == null) {
			System.out.println("Error creating tree.");
			return false;
		}
		else {
			if (parentNode.getLeft() == null) {
				parentNode.setLeft(new TreeNode(label, message, prompt));
				return true;
			}
			else if (parentNode.getMiddle() == null) {
				parentNode.setMiddle(new TreeNode(label, message, prompt));
				return true;
			}
			else if (parentNode.getRight() == null) {
				parentNode.setRight(new TreeNode(label, message, prompt));
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	/**
	 * Finds TreeNode that matches the label parameter
	 * 
	 * @param label
	 * label of specific TreeNode
	 * @return
	 * TreeNode with the same label as the parameter
	 */
	public TreeNode getNodeReference(String label) {
		return this.searchNodes(root, label);
	}
	
	/**
	 * Begins help session and traverses through trees, giving the user choices in the tree
	 */
	public void beginSession() {
		System.out.println(cursor.getMessage());
		if (TreeNode.isLeaf(cursor)) {
			System.out.println("\nThank you for using this automated help service!");
			return;
		}
		if (cursor.getLeft() != null) {
			System.out.println(cursor.getLeft().getLabel() + " " + cursor.getLeft().getPrompt());
		}
		if (cursor.getMiddle() != null) {
			System.out.println(cursor.getMiddle().getLabel() + " " + cursor.getMiddle().getPrompt());
		}
		if (cursor.getRight() != null) {
			System.out.println(cursor.getRight().getLabel() + " " + cursor.getRight().getPrompt());
		}
	}
	
	/**
	 * Searches through tree for specific node
	 * 
	 * @param currentNode
	 * node that traversal begins from
	 * @param label
	 * label of desired TreeNode
	 * @return
	 * Specific TreeNode with the same label as the label parameter
	 */
	public TreeNode searchNodes(TreeNode currentNode, String label) {
		if (currentNode != null) {
			if (currentNode.getLabel().equals(label)) {
				return currentNode;
			}
			else {
				TreeNode tryNode = searchNodes(currentNode.getLeft(), label);
				if (tryNode == null) {
					tryNode = searchNodes(currentNode.getMiddle(), label);
					if (tryNode == null) {
						tryNode = searchNodes(currentNode.getRight(), label);
					}
				}
				return tryNode;
			}
		}
		else {
			return null;
		}
	}
}