package com.skilldistillery.cards.common;

public enum Suit {
	
	HEARTS("\u2665"), SPADES("\u2660"),CLUBS("\u2663"), DIAMONDS("\u2666");
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
