import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ElevensBoard {

	/**
	 *  Score
	 */
	
	int score = 0;
	
	/**
	 * SelectedCards
	 */
	
	List<Integer> selectedCards = new ArrayList<Integer>();
	
	/**
	 *  Cards on the board.
	 */
	
	List<Integer> cIndexes;
	
	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"\u2660", "\u2665", "\u2666", "\u2663"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};


	/**
	 * The cards on this board.
	 */
	private Card[] cards;

	/**
	 * The deck of cards being used to play the current game.
	 */
	private Deck deck;
	
	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard() {
		cards = new Card[BOARD_SIZE];
		deck = new Deck(RANKS, SUITS, POINT_VALUES);
		if (I_AM_DEBUGGING) {
			System.out.println(deck.myDeck);
			System.out.println("----------");
		}
		dealMyCards();
		cIndexes = cardIndexes();
		
	}

	/**
	 * Start a new game by shuffling the deck and
	 * dealing some cards to this board.
	 */
	public void newGame() {
		
		deck = new Deck(RANKS, SUITS, POINT_VALUES);
		deck.shuffle();
		dealMyCards();

	}

	/**
	 * Accesses the size of the board.
	 * Note that this is not the number of cards it contains,
	 * which will be smaller near the end of a winning game.
	 * @return the size of the board
	 */
	public int size() {
		return cards.length;
	}

	/**
	 * Determines if the board is empty (has no cards).
	 * @return true if this board is empty; false otherwise.
	 */
	public boolean isEmpty() {
		for (int k = 0; k < cards.length; k++) {
			if (cards[k] != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Deal a card to the kth position in this board.
	 * If the deck is empty, the kth card is set to null.
	 * @param k the index of the card to be dealt.
	 */
	public void deal(int k) {
		cards[k] = deck.deal();
	}

	/**
	 * Accesses the deck's size.
	 * @return the number of undealt cards left in the deck.
	 */
	public int deckSize() {
		return deck.size();
	}

	/**
	 * Accesses a card on the board.
	 * @return the card at position k on the board.
	 * @param k is the board position of the card to return.
	 */
	public Card cardAt(int k) {
		return cards[k];
	}

	/**
	 * Replaces selected cards on the board by dealing new cards.
	 * @param selectedCards is a list of the indices of the
	 *        cards to be replaced.
	 */
	public void replaceSelectedCards(List<Integer> selectedCards) {
		for (Integer k : selectedCards) {
			deal(k.intValue());
		}
	}

	/**
	 * Gets the indexes of the actual (non-null) cards on the board.
	 *
	 * @return a List that contains the locations (indexes)
	 *         of the non-null entries on the board.
	 */
	public List<Integer> cardIndexes() {
		List<Integer> selected = new ArrayList<Integer>();
		for (int k = 0; k < cards.length; k++) {
			if (cards[k] != null) {
				selected.add(new Integer(k));
			}
		}
		return selected;
	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public boolean isLegal(List<Integer> selectedCards) {
		
		if(selectedCards.size() > 2 && !containsJQK(selectedCards)) return false;
		
		if(selectedCards.size() == 2) {
			
			if(containsPairSum11(selectedCards)) return true;
			
		}
		
		if(selectedCards.size() == 3) {
			
			if(containsJQK(selectedCards)) return true;
			
		}
		
		return true;
		
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public boolean anotherPlayIsPossible() {
		
		for(int x = 0; x < cards.length; x++) {
			
			for(int y = 0; y < cards.length; y++) {
				
				if(cards[x].getPointValue() + cards[y].getPointValue() == 11) {
					
					return true;
				}
					
					for(int z = 0; z < cards.length; z++) {
						
						
						if(x < cards.length-2) {
							
							  if((cards[x].getPointValue() == 0 && cards[y].getPointValue() == 0 && cards[z].getPointValue() == 0) && 
									  !(cards[x].getRank() == cards[y].getRank()) &&
										!(cards[y].getRank() == cards[z].getRank()) &&
										!(cards[z].getRank() == cards[(x)].getRank())){
									
								  return true;
								  
							  			}
								
									}
						
					}
					
				}
				
					}
			
				
		
		return false;
	}


	/**
	 * Deal cards to this board to start the game.
	 */
	private void dealMyCards() {
		for (int k = 0; k < cards.length; k++) {
			cards[k] = deck.deal();
		}
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	protected boolean containsPairSum11(List<Integer> selectedCards) {
		
		if(cards[selectedCards.get(0)].getPointValue() + cards[selectedCards.get(1)].getPointValue() == 11) {
			
			return true;
			
		}
		
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	protected boolean containsJQK(List<Integer> selectedCards) {
		
		if(selectedCards.size() < 3) return false;
		
		if((cards[selectedCards.get(0)].getPointValue() + cards[selectedCards.get(1)].getPointValue() + cards[selectedCards.get(2)].getPointValue() == 0)
				&& !(cards[selectedCards.get(0)].getRank() == cards[selectedCards.get(1)].getRank()) &&
				!(cards[selectedCards.get(1)].getRank() == cards[selectedCards.get(2)].getRank()) &&
				!(cards[selectedCards.get(2)].getRank() == cards[selectedCards.get(0)].getRank()) ) {
			
			return true;
			
		}
		
		return false;
	}
	
	/**
	 * This allows you to display the selected cards on the JFrame
	 * @return the selected cards .toString() for the JFrame
	 */
	
	public ArrayList<Card> displaySelectedCards() {
		
		ArrayList<Card> selected = new ArrayList<Card>();
		
		for(int x = 0; x < selectedCards.size(); x++) {
			
			selected.add(cardAt(selectedCards.get(x)));
			
		}
		
		return selected;
		
	}
	
}