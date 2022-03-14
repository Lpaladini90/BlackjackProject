package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Deck;

public class Dealer {
	
	
	
	
	public void deckPrep(Deck deck) {
		deck.shuffle();
		

	}
	
	public void dealerWins() {
		
		System.out.println("\nDealer Wins, You lose!");
	}
	
	public void dealerBlackjack() {
		System.out.println("\nDealer gets Blackjack! ");
		System.out.println("Womp Womp Waaaaaaaa. Loser.");
	}

	public void dealerBust() {
		System.out.println("\nDealer busts you win!");
	}
	
}
