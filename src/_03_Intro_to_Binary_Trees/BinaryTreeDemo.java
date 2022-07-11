package _03_Intro_to_Binary_Trees;

public class BinaryTreeDemo {

    /*
     * A Binary Tree is a data structure that makes use of nodes and references
     * like a LinkedList, but instead of the nodes pointing to a previous node
     * or next node in an unorderd list they each points to two child nodes that
     * are below them in the hierarchy.
     * 
     * Some important properties of BinaryTree are:
     * 
     * -The left node is always a smaller value than its parent and the right
     * node is always a larger value. This is a property you have seen in some
     * form already via Binary Search.
     * 
     * -Empty nodes are null references.
     * 
     * -The parent node at the very top of the tree is called the root.
     * 
     * 1. Read through the BinaryTree and Node classes.
     * 
     * 2. Create a BinaryTree of any type you like.
     * 
     * 3. Try using some BinaryTree methods to insert, search for, delete and
     * print elements.
     * 
     * 4. Save the root into a Node Object and use references to traverse
     * through the BinaryTree and perform an operation on every element(You may
     * choose to do this recursively or iteratively). Then print it out to see
     * if it worked.
     * 
     */

	
    public static void main(String[] args) {
    	BinaryTreeDemo demo = new BinaryTreeDemo();
    	
    	BinaryTree<Integer> tree = new BinaryTree<Integer>();
    	tree.insert(500);
    	tree.insert(200);
    	tree.insert(4000);
    	tree.insert(5);
    	tree.insert(501);
    	tree.insert(40);
    	tree.insert(1);
    	tree.insert(300);
    	tree.insert(4001);
    	tree.insert(499);
    	tree.insert(201);
    	tree.printVertical();
    	
    	tree.search(40);
    	
    	tree.search(1);
    	
    	Node<Integer> node = tree.getRoot();
    	System.out.println(node.getValue());
    	
    	demo.action(node);
    	System.out.println(node.getValue());
    }

    public void action(Node<Integer> node) {
    	if (node.getLeft() != null) {
    		action(node.getLeft());
    	}
    	
    	if (node.getRight() != null) {
    		action(node.getRight());
    	}
    	
    	node.setValue(node.getValue()*10);
    }
}
