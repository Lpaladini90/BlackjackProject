package com.skilldistillery.cards.common;

import java.util.Objects;

public class Card {

	private Rank rank;
	
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getValue() {
		return rank.getValue();
				
	}
	
	
	
	
	@Override
	public String toString() {
		String output = rank + " of " + suit;
		return output;
	}
	
	// Here is another way to do a toString
//	public String toString() {
//	    StringBuilder builder = new StringBuilder();
//	    builder.append(rank);
//	    builder.append(" of ");
//	    builder.append(suit);
//	    return builder.toString();
//	  }
	
	
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}
	
	
	
	
	
	 
	
}
