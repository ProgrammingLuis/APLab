public class Card {

	// instance variables
	
	private String rank;
	private String suit;
	private int pointValue;
	
	
	// constructors
	
	public Card() {
		
		this.rank = null;
		this.suit = null;
		this.pointValue = -1;
		
	}
	public Card(String rank, String suit, int pointValue) {
		
		this.rank = rank;
		this.suit = suit;
		this.pointValue = pointValue;
		
	}
	
	// methods
	
	/**
	 * @return rank of card
	 */
	
	public String getRank() {
		
		return rank;
		
	}
	
	/**
	 * @return suit of card
	 */
	
	public String getSuit() {
		
		return suit;
		
	}
	
	/**
	 * @return pointValue of card
	 */
	
	public int getPointValue() {
		
		return pointValue;
		
	}
	
	/**
	 * @param x is to set rank
	 */
	
	public void setRank(String x) {
		
		this.rank = x;
		
	}
	
	/**
	 * @param x is to set Suit
	 */
	
	public void setSuit(String x) {
		
		this.suit = x;
		
	}
	
	/**
	 * @param x is to set pointValue
	 */
	
	public void setPointValue(int x) {
		
		this.pointValue = x;
		
	}
	
	/**
	 * @return card in a nice string form
	 */
	
	public String toString() {
		
		return rank + suit /*+ " (pointvalue = " + pointValue + ")"*/;
		
	}
	
	/**
	 * 
	 * @param card to test equality between cards
	 * @return true or false depending on the equality condition.
	 */
	
	public boolean isEqual(Card card) {
		
	
			if( this.toString().equals(card.toString()) ) {
			
			return true;
			
		}
		
		return false;
		
	}
	
}
