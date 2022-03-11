package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> cards;
	
	//map of decks
	// Map<Card,Integer> decks = new Has

	public List<Card> createDecks() {
		
		//create a list for 6 decks, like at a casino
		//List<Card> multipleDecks = new ArrayList<>(6);
		
		//for (Card deck : multipleDecks) {
		
			List<Card> deck = new ArrayList<>(52);
			
		
		
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));

				// two ways to create a card and add it to the deck
//				Card card = new Card(rank, suit);
//				deck.add(card);
			}

		}
		return deck;
 
		}

	

	public Deck() {
		cards = createDecks();
		

	}

	public int checkDeckSize() {
		int amountOfCardsLeft = cards.size();
		return amountOfCardsLeft;
		
		}

	public Card dealCard() {
		return cards.remove(0);
	}
	
	
	public void shuffle() {
		Collections.shuffle(cards);
	}

}




//POSSIBLE ADD MORE DECKS EACH DECK HAS 52 CARDS

//
//
//public class Deck {
//	List<List<Card>> cards;
//
//	// map of decks
//	// Map<Card,Integer> decks = new Has
//
//	public List<List<Card>> createDecks() {
//
////		 create a list for 6 decks, like at a casino
//		
//			
//		
//		List<Card> multipledecks = new ArrayList<>(6);
//
//		List<List<Card>> deck = new ArrayList<List<Card>>(52);
//
//		for (Suit suit : Suit.values()) {
//			for (Rank rank : Rank.values()) {
//				deck.add(new Card(rank, suit));
//
////				 two ways to create a card and add it to the deck
////				Card card = new Card(rank, suit);
////				deck.add(card);
//			}
//
//		}
//	
//		return deck;
//
//	}
//
//	public Deck() {
//		cards = createDecks();
//
//	}
//
//	public int checkDeckSize() {
//		int amountOfCardsLeft = cards.size();
//		return amountOfCardsLeft;
//
//	}
//
//	public Card dealCard() {
//		return (Card) cards.remove(0);
//	}
//
//	public void shuffle() {
//		Collections.shuffle(cards);
//	}
//





