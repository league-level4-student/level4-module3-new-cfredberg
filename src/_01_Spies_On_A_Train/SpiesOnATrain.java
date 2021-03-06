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
    		HashMap<String, Integer> pairs = new HashMap<String, Integer>();
    		for (int i = 0; i < train.size(); i++) {
    			System.out.println(node.getValue().questionPassenger());
    			node = node.getNext();
    		}
    		
    		for (int i = 0; i < clues.length; i++) {
    			System.out.println(clues[i]);
    		}
    		System.out.println();
    		node = train.getHead();
    		for (int i = 0; i < clues.length; i++) {
    			for (int j = 0; j < train.size(); j++) {
    				String[] answer = node.getValue().questionPassenger().split(" ");
    				String name = answer[13];
    				System.out.println(name);
    				String answerClue = "";
    				for (int k = answer.length-clues[i].split(" ").length; k < answer.length; k++) {
    					answerClue = answerClue + answer[k] + " ";
    				}
    				answerClue = answerClue.trim();
    				answerClue = answerClue.replaceAll("[.]", "");
    				System.out.println(answerClue);
    				
    				boolean inSet = false;
    				for (int k = 0; k < clues.length; k++) {
    					if (answerClue.equals(clues[k])) {
    						inSet = true;
    					}
    				}
    				
    				if (inSet == true) {
    					if (pairs.containsKey(name)) {
    						pairs.put(name, pairs.get(name)+1);
    					}else {
    						pairs.put(name, 1);
    					}
    				}
    				
    				node = node.getNext();
    			}
    			node = train.getHead();
    		}
    		
    	String name = "";
    	int value = 0;
    	
    	for (String key : pairs.keySet()) {
    		if (pairs.get(key) > value) {
    			name = key;
    			value = pairs.get(key);
    		}
    	}
    	
        return name;

    }

}
