package _06_How_Many_Are_Smaller_Than_Me;

import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

    /*
     * Given an AVLTree filled with the random numbers from 1 to 20, and a
     * single number within the AVL Tree, figure out how many numbers in the
     * AVLTree are bigger than the provided number and return the result.
     * 
     * You may want to create a helper method to search through the AVLTree and
     * count iteratively or recursively.
     */

    public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {
    	System.out.println(search(avlTree.getRoot(), me));
    	
    	System.out.println(me);
    	
        return search(avlTree.getRoot(), me);

    }
    
    public int search(AVLNode<Integer> node, int me) {
    	int num = 0;
    	
    	if (node == null) {
    		return 0;
    	}
    	
    	if (node.getValue() < me) {
    		num++;
    	}
    	
    	if (node.getLeft() != null) {
    		num += search(node.getLeft(), me);
    	}
    	
    	if (node.getRight() != null) {
    		num += search(node.getRight(), me);
    	}
    	
    	return num;
    }
    
}
