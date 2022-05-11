package _01_Spies_On_A_Train;

import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    		Node<TrainCar> node = train.getHead();
    		for (int i = 0; i < train.size(); i++) {
    			System.out.println(node.getValue().questionPassenger());
    			node = node.getNext();
    		}
    		
    		for (int i = 0; i < clues.length; i++) {
    			System.out.println(clues[i]);
    		}
    		
    		node = train.getHead();
    		for (int i = 0; i < clues.length; i++) {
    			for (int j = 0; j < train.size(); j++) {
    				String[] answer = node.getValue().questionPassenger().split(" ");
    				String name = answer[13];
    				System.out.println(name);
    				String answerClue = "";
    				for (int k = answer.length-clues[i].length()-1; k < clues[i].length(); k++) {
    					answerClue = answerClue + answer[i].split(" ")[k];
    				}
    				System.out.println(answerClue);
    				System.out.println("test");
    				
    				node = node.getNext();
    			}
    			node = train.getHead();
    		}
    	
        return "";

    }

}
