package com.skilldistillery.cards.common;

public enum Suit {
	
	HEARTS("Hearts"), SPADES("Spades"),CLUBS("Clubs"), DIAMONDS("Diamonds");
	// use unicode to input the picture of the cards next to the 
	private final String name;

	Suit(String suitName){
		this.name=suitName;
	}

	@Override
	public String toString() {
		return name;
	}

	
	
}
