package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public abstract class Hand {
	Deck deck = new Deck();
	
	// an object that contains cards from deck

	List<Card> cards = new ArrayList<>(52);

	// ability to create a new hand.
	public Hand() {

	}

	// ability to add a card to the hand. SUB CLASS WILL IMPLEMENT THIS
	public void addCard( Card card) {
		cards.add(card);
	}


	// ability to count the value of cards in the hand. SUB CLASS WILL IMPLEMENT
	// THIS
	

	// this will clear the hand. SUB CLASS WILL IMPLEMENT THIS
	public void clear() {
		System.out.println("Table hand has been cleared.");
	}


	
	public abstract int getHandValue(List<Card> playerHand);
		 
}
