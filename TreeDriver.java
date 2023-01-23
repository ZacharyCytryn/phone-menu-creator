/**
 * Zachary Cytryn
 * ID: 114283379
 * Email: zachary.cytryn@stonybrook.edu
 * Homework #4
 * CSE 214 Recitation 30
 */

package decisionMakerSystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class contains the main method for creation and use of the tree
 * 
 * EXTRA CREDIT: A potential use for this program is a memory game that can assess someone's memory and compare it
 * to averages of people their age, etc. This would work by treating each node like a door. The user is given a 
 * specific pattern of doors to get to the exit, and is placed at the root node and has to choose the doors in
 * the correct order so they could reach the exit. The amount of doors can be adjusted in order to make the game
 * harder or easier.
 * 
 * @author zacharycytryn
 */
public class TreeDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner reader;
		String ans = "";
		File treeFile;
		Tree tree = new Tree("error", "error");
		String rootPrompt = "";
		String lineTester = "";
		String rootMessage = "";
		int numChildren = 0;
		String label = "";
		String prompt = "";
		String message = "";
		String parentLabel = "";
		
		while(!ans.toUpperCase().equals("Q")) {
			System.out.println("\nL - Load a Tree."
					+ "\nH - Begin a Help Session."
					+ "\nT - Traverse the Tree in preorder."
					+ "\nQ - Quit"
					+ "\nChoice> ");
			ans = sc.nextLine();
			
			switch (ans.toUpperCase()) {
			case "L":
				//File name must be the entire path of file
				System.out.println("\nEnter the file name> ");
				treeFile = new File(sc.nextLine());
				try {
					reader = new Scanner(treeFile);
					
					//Skip through "root"
					reader.nextLine();
					//Properly initialize tree (set root correctly)
					while(rootPrompt.equals("")) {
						lineTester = reader.nextLine().trim();
						if (lineTester.length() != 0) {
							rootPrompt = lineTester;
						}
					}
					lineTester = "";
					while(rootMessage.equals("")) {
						lineTester = reader.nextLine().trim();
						if(lineTester.length() != 0) {
							rootMessage = lineTester;
						}
					}
					lineTester = "";
					tree.getRoot().setPrompt(rootPrompt);
					tree.getRoot().setMessage(rootMessage);
					
					while (reader.hasNextLine()) {
						lineTester = reader.nextLine().trim();
						if (lineTester.length() != 0) {
							parentLabel = lineTester.substring(0, lineTester.length() - 2);
							numChildren = Integer.parseInt(lineTester.substring(lineTester.length() - 1));
						}
						for (int i = 0; i < numChildren; i++) {
							lineTester = reader.nextLine().trim();
							if (lineTester.length() != 0) {
								label = lineTester;
							}
							lineTester = reader.nextLine().trim();
							if (lineTester.length() != 0) {
								prompt = lineTester;
							}
							lineTester = reader.nextLine().trim();
							if (lineTester.length() != 0) {
								message = lineTester;
							}
							tree.addNode(label, prompt, message, parentLabel);
						}
					}
					reader.close();
					
					System.out.println("\nTree created succesfully!");
					
				} catch (FileNotFoundException e) {
					System.out.println("File not found.");
				}
				break;
				
			case "H":
				if (tree.getRoot().getPrompt().equals("error") && tree.getRoot().getMessage().equals("error")) {
					System.out.println("Please load in a tree.");
				}
				else {
					String choice = "";
					System.out.println("\nHelp Session Starting...");
					tree.setCursor(tree.getRoot());
					while(!TreeNode.isLeaf(tree.getCursor())) {
						tree.beginSession();
						System.out.println("Choice> ");
						choice = sc.nextLine();
						int nodeSel = Integer.parseInt(choice);
						if (nodeSel == 1) {
							if (tree.getCursor().getLeft() == null) {
								System.out.println("Please enter a valid choice.\n");
							}
							else {
								tree.setCursor(tree.getCursor().getLeft());
							}
						}
						else if (nodeSel == 2) {
							if (tree.getCursor().getMiddle() == null) {
								System.out.println("Please enter a valid choice.\n");
							}
							else {
								tree.setCursor(tree.getCursor().getMiddle());
							}
						}
						else if (nodeSel == 3) {
							if (tree.getCursor().getRight() == null) {
								System.out.println("Please enter a valid choice.\n");
							}
							else {
								tree.setCursor(tree.getCursor().getRight());
							}
						}
						else {
							System.out.println("Please enter a valid choice.\n");
						}
					}
					tree.beginSession();
				}
				
				break;
				
			case "T":
				if (tree.getRoot().getPrompt().equals("error") && tree.getRoot().getMessage().equals("error")) {
					System.out.println("Please load in a tree.");
				}
				else {
					tree.getRoot().preOrder();
				}
				break;
				
			case "Q":
				System.out.println("\nThank you for using our automated help services!");
				break;
				
			default:
				System.out.println("\nPlease enter a valid choice.");
				break;
			}
		}
		sc.close();
	}
}