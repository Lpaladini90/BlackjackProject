package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealing {
	
	Scanner sc = new Scanner(System.in); 
	
	
	public static void main(String[] args) {
	Dealing deal = new Dealing();
	
	
		deal.run();
	
	
	}
	
	
	
	private void run() {
		Deck deck = new Deck();
		//new deck must shuffle
		deck.shuffle();
		
//		System.out.println("Place bet");
//		
//		System.out.println("------------------------------");
//		System.out.println("------- Betting   Menu -------");
//		System.out.println("------------------------------");
//		System.out.println("-1. Bet the minimum           -");
//		System.out.println("-2. Stay                     -");
//		System.out.println("- ");
//		System.out.println("------------------------------");
		
		
		
		
			System.out.println("How many cards do you want?");
			
			try {
				int howManyCards = sc.nextInt();
					if(howManyCards > deck.checkDeckSize()) {
						System.out.println("Not enough cards left");
					}
					List<Card> hand = new ArrayList<>(howManyCards);
				
				//create an int var for how many cards are in the hand
				int totalAmountOfCards = 0;
				for (int i = 0; i < howManyCards; i++) { 
					Card card = deck.dealCard();
					
					//this will display how many cards are in the hand
					totalAmountOfCards = totalAmountOfCards + card.getValue();
					hand.add(card);
					
				}
					
				printDisplayCards(hand,totalAmountOfCards);
				
				
				//how does a card get from the deck into a hand
				//hand.add(deck.dealCard());
				
//				System.out.println("What would you like to do?");
//				
//				
//				
//				System.out.println("------------------------------");
//				System.out.println("------- BlackJack Menu -------");
//				System.out.println("------------------------------");
//				System.out.println("-1. Hit Me!                  -");
//				System.out.println("-2. Stay                     -");
//				System.out.println("- ");
//				System.out.println("------------------------------");
				
		
		} catch (Exception e) {
			System.out.println("Error: card value must be number of 1-52");
		}
		
		
	}



	private void printDisplayCards(List<Card> hand, int totalAmountOfCards) {
		for (Card card : hand) {
			System.out.println(card);
		}
		System.out.println("Value of cards in hand " + totalAmountOfCards);
	}
	
	
	
} 
