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
	
	public String getRank() {
		
		return rank;
		
	}
	
	public String getSuit() {
		
		return suit;
		
	}
	
	public int getPointValue() {
		
		return pointValue;
		
	}
	
	public void setRank(String x) {
		
		this.rank = x;
		
	}
	
	public void setSuit(String x) {
		
		this.suit = x;
		
	}
	
	public void setPointValue(int x) {
		
		this.pointValue = x;
		
	}
	
	public String toString() {
		
		return rank + suit /*+ " (pointvalue = " + pointValue + ")"*/;
		
	}
	
	public boolean isEqual(Card card) {
		
	
			if( this.toString().equals(card.toString()) ) {
			
			return true;
			
		}
		
		return false;
		
	}
	
}
