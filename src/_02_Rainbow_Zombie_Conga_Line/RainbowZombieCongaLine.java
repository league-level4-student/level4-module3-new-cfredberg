package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;

    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	Node<Zombie> node = new Node<Zombie>(dancer);
    	congaLine.setHead(node);
    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	Node<Zombie> node = new Node<Zombie>(dancer);
    	congaLine.setTail(node);
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	Node<Zombie> newPos = new Node<Zombie>(dancer);
    	Node<Zombie> current = congaLine.getHead();
    	for (int i = 0; i < congaLine.size(); i++) {
    		if (i == position) {
    			newPos.setNext(current);
    			newPos.setPrev(current.getPrev());
    			current.getPrev().setNext(newPos);
    			current.setPrev(newPos);
    		}
    		current = current.getNext();
    	}
    }

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	ZombieHatColor removeHat = dancer.getZombieHatColor();
    	Node<Zombie> current = congaLine.getHead();
    	for (int i = 0; i < congaLine.size(); i++) {
    		if (current.getValue().getZombieHatColor() == removeHat) {
    			current.getPrev().setNext(current.getNext());
    			current.getNext().setPrev(current.getPrev());
    		}
    		current = current.getNext();
    	}
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {
    	boolean isRemoved = false;
    	Node<Zombie> current = congaLine.getHead();
    	for (int i = 0; i < congaLine.size(); i++) {
    		if (current.getValue().getZombieHatColor() == dancer.getZombieHatColor() && isRemoved == false) {
    			current.getPrev().setNext(current.getNext());
    			current.getNext().setPrev(current.getPrev());
    			isRemoved = true;
    		}
    		current = current.getNext();
    	}
    	
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	Zombie zom1 = new Zombie(dancer.getZombieHatColor());
    	Zombie zom2 = new Zombie(dancer.getZombieHatColor());
    	Node<Zombie> dancerN = new Node<Zombie>(dancer);
    	Node<Zombie> zom1N = new Node<Zombie>(zom1);
    	Node<Zombie> zom2N = new Node<Zombie>(zom2);
    	Node<Zombie> current = congaLine.getHead();
    	int lineSize = congaLine.size();
    	for (int i = 0; i < lineSize; i++) {
    		if (lineSize/2 == i) {
    			dancerN.setNext(current.getNext());
    			dancerN.setPrev(current);
    			current.getNext().setPrev(dancerN);
    			current.setNext(dancerN);
    			current = current.getNext();
    		}
    		
    		if (i == lineSize-1) {
    			current.setNext(zom2N);
    			zom2N.setPrev(current);
    		}
    		current = current.getNext();
    	}
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {
    	Node<Zombie> zom = new Node<Zombie>(dancer);
    	Node<Zombie> current = congaLine.getHead();
    	
//-----------------------------------Start-Here-Next-Class--------------------------------------------------------------
    	
    	for (ZombieHatColor color : ZombieHatColor.values()) {
    		
    	}
    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
