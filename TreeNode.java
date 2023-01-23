/**
 * Zachary Cytryn
 * ID: 114283379
 * Email: zachary.cytryn@stonybrook.edu
 * Homework #4
 * CSE 214 Recitation 30
 */

package decisionMakerSystem;

/**
 * This class represents a TreeNode, containing  a label, message, prompt, and it's children
 * 
 * @author zacharycytryn
 */
public class TreeNode {

	private String label;
	private String message;
	private String prompt;
	private TreeNode left;
	private TreeNode middle;
	private TreeNode right;
	
	/**
	 * Constructor for TreeNode
	 * 
	 * @param label
	 * Label of TreeNode
	 * @param message
	 * Message of TreeNode
	 * @param prompt
	 * Prompt of TreeNode
	 */
	public TreeNode(String label, String message, String prompt) {
		this.label = label;
		this.message = message;
		this.prompt = prompt;
	}
	
	/**
	 * Getter method for label
	 * 
	 * @return
	 * label
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Getter method for message
	 * 
	 * @return
	 * message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Getter method for prompt
	 * 
	 * @return
	 * prompt
	 */
	public String getPrompt() {
		return prompt;
	}
	
	/**
	 * Getter method for left child of TreeNode
	 * 
	 * @return
	 * left
	 */
	public TreeNode getLeft() {
		return left;
	}
	
	/**
	 * Getter method for middle child of TreeNode
	 * 
	 * @return
	 * middle
	 */
	public TreeNode getMiddle() {
		return middle;
	}
	
	/**
	 * Getter method for right child of TreeNode
	 * 
	 * @return
	 * right
	 */
	public TreeNode getRight() {
		return right;
	}

	/**
	 * Setter method for label
	 * 
	 * @param label
	 * Desired label to replace current label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Setter method for message
	 * 
	 * @param message
	 * Desired message to replace current message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Setter method for prompt
	 * 
	 * @param prompt
	 * Desired prompt to replace current prompt
	 */
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	/**
	 * Setter method for left child of TreeNode
	 * 
	 * @param left
	 * Desired left child node for TreeNode
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	/**
	 * Setter method for middle child of TreeNode
	 * 
	 * @param middle
	 * Desired middle child node for TreeNode
	 */
	public void setMiddle(TreeNode middle) {
		this.middle = middle;
	}
	
	/**
	 * Setter method for right child of TreeNode
	 * 
	 * @param right
	 * Desired right child node for TreeNode
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	/**
	 * Checks to see if current node is a leaf node or not
	 * 
	 * @param node
	 * Node being checked
	 * @return
	 * true if the current node is a leaf node and false otherwise
	 */
	public static boolean isLeaf(TreeNode node) {
		if (node.getLeft() == null && node.getMiddle() == null && node.getRight() == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Prints TreeNodes of a tree in preorder
	 */
	public void preOrder() {
		System.out.println("Label: " + label);
		System.out.println("Prompt: " + prompt);
		System.out.println("Message: " + message + "\n");
		
		if (left != null) {
			left.preOrder();
		}
		if (middle != null) {
			middle.preOrder();
		}
		if (right != null) {
			right.preOrder();
		}
	}
}