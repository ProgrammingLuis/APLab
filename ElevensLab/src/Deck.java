import java.util.*;
import java.util.Random;


public class Deck {

	// instance variables
	
	String[] ranksArray = {};
	String[] suitsArray = {};
	int[] valueArray = {};
	
	int size;
	
	Random rand = new Random();
	ArrayList<Card> myDeck = new ArrayList<Card>();

	// constructors
	
	public Deck() {
		
	}
	
	
	public Deck(String[] ranksArray, String[] suitsArray, int[] valueArray) {
		
		this.ranksArray = ranksArray;
		this.suitsArray = suitsArray;
		this.valueArray = valueArray;
		
		Card cards;
		
		for(int s = 0; s < suitsArray.length; s++) {
			
			for(int rv = 0; rv < ranksArray.length; rv++) {
				
				 cards = new Card(ranksArray[rv], suitsArray[s], valueArray[rv]);
				 
				 myDeck.add(cards);
				 
			}
			
		}
		
		
		
		size = myDeck.size();
		shuffle();
		
	}
	
	// methods
	
	public boolean isEmpty() {
		
		if(size==0) return true;
			
		return false;
		
	};
	
	public int size() {
		
		return size;
		
	}
	
	public Card deal() {
		
		if(size==0) return null;
		
		return myDeck.get(--size);
		
	}
	
	public ArrayList<Card> shuffle(){
		
		ArrayList<Card> storage = new ArrayList<Card>();
		
		int removedIndex = size;
		
		while(storage.size() < size) {
			
			int random = rand.nextInt(removedIndex--);
			
			storage.add(myDeck.get(random));
			
			myDeck.remove(random);

			
		}
		
		myDeck = storage;
		
		return myDeck;
		
	}
	
}
