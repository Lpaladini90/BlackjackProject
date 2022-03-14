package com.skilldistillery.cards.blackjack;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackHandNoBetting extends Hand {
	Scanner sc = new Scanner(System.in);

	public BlackjackHandNoBetting() {

		super();
	}

	@Override
	public void addCard(Card card) {
		cards.add(card);
	}

	@Override
	public int getHandValue(List<Card> playerHand) {
		int handValue = 0;
		for (Card cards : playerHand) {
			int cardValue = cards.getValue();
			handValue = handValue + cardValue;
		}

		return handValue;

	}

	private boolean isBust(List<Card> hand) {

		if (getHandValue(hand) > 21) {

			return true;

		}
		return false;
	}

	private boolean isBlackjack(List<Card> hand) {
		if (getHandValue(hand) == 21) {

			return true;
		}
		return false; 

	}

	public void playerTurn(List<Card> playerHand, Deck deck) {

		if (isBlackjack(playerHand)) {
			System.out.println("\nBLACKJACK!!");
			System.out.println("Winner Winner Chicken Dinner!");
			
		
		}

		if (getHandValue(playerHand) < 21) {
			System.out.println("\nYour hand value: " + getHandValue(playerHand));

			boolean hitAgain = true;
			while (hitAgain) {
				System.out.println("\n-------------------------");
				System.out.println("-What is your move?     -");
				System.out.println("-                       -"); 
				System.out.println("-     1. HIT            -");
				System.out.println("-          or           -");
				System.out.println("-       2. STAY         -");
				System.out.println("-                       -");
				System.out.println("-------------------------");

				int userInput = sc.nextInt();

				switch (userInput) {

				// if player says hits
				case 1:
					playerHand.add(deck.dealCard());

					System.out.println("\nCards in deck remaining: " + deck.checkDeckSize());

					System.out.println("You've been delt a " + playerHand.get(playerHand.size() - 1));

					System.out.println("\nYour new hand value is: " + getHandValue(playerHand));

					if (getHandValue(playerHand) == 21) {
						System.out.println("\nNice!");
						hitAgain = false;
					}

					else if (isBust(playerHand)) {
						System.out.println("\nBUST! Too many cards!");
						System.out.println("Dealer Wins. womp womp waaaaaaa... LOSER");
						hitAgain = false;
						continue;
					}

					break;

				case 2:
					System.out.println("\nYou stay.");
					hitAgain = false;
					break;

				default:
					System.out.println("Invalid input. Hit or stay only.");
					break;
				}
			}
		}
		
	}

	public void dealersTurn(List<Card> dealerHand, Deck deck, List<Card> playerHand) {

		boolean dealerHit = true;
		while (dealerHit) {
			if (isBust(playerHand)) {
				
				dealerHit = false;
				return;
				
			} 
			
			
			System.out.println(getHandValue(dealerHand));
			
			 if (isBlackjack(dealerHand) && isBlackjack(playerHand)) {
				System.out.println("\n PUSH ");
				dealerHit = false;
			}

			else if (isBlackjack(playerHand) && (!isBlackjack(dealerHand))) {
				System.out.println("\nPlayer Blackjack!");
				dealerHit = false;
			}
			else if (isBlackjack(dealerHand) && (!isBlackjack(playerHand))) {
				System.out.println("\nDealer Blackjack!");
				dealerHit = false;
			}

			else if ((getHandValue(dealerHand) >= 17) && (getHandValue(dealerHand) <= 21)) {
				System.out.println("\nDealer stays");
				dealerHit = false;
			}

			else if (getHandValue(dealerHand) <= 16) {
				System.out.println("\nDealer takes a card");
				dealerHand.add(deck.dealCard());
				System.out.println("\nDealer has been delt a " + dealerHand.get(dealerHand.size() - 1));
				System.out.println("\nDealers hand value is: " + getHandValue(dealerHand));
				System.out.println("\nCards in deck remaining: " + deck.checkDeckSize());
				dealerHit = true;
			}

			else if (getHandValue(dealerHand) == 21) {
				System.out.println("\nOuch! Dealer wins!");
				
				dealerHit = false;
			}

			else if (isBust(dealerHand) ) {
				System.out.println("\nDealer busts!");
				dealerHit = false;
			}
		}
	}



	public void determineWinner(List<Card> dealerHand, List<Card> playerHand) {

		 if ( (getHandValue(dealerHand) >= 17) && (getHandValue(dealerHand) > getHandValue(playerHand)) && (getHandValue(dealerHand) <= 21)) {
			System.out.println("\nDealer wins");
		}
		 else if( (getHandValue(dealerHand) >= 17) && (getHandValue(dealerHand) <=21) && (getHandValue(dealerHand) == getHandValue(playerHand))){
			 System.out.println("\nPush");
		 }
		 //if dealer hand is greater than players AND less than 21
//		else if ((getHandValue(dealerHand) > getHandValue(playerHand)) && (getHandValue(dealerHand) < 21)) {
//			System.out.println("Dealer wins");
//
//		}
		 // if the dealers hand is greater or equal to than 17 AND less than 21 AND less
		// than players- dealer losses
		else if ((getHandValue(dealerHand) >= 17) && (getHandValue(dealerHand) < 21) && (getHandValue(dealerHand) < getHandValue(playerHand)) && getHandValue(playerHand) < 21) {
			System.out.println("\nYou win!");

		} else if ((getHandValue(dealerHand) < getHandValue(playerHand)) && (getHandValue(playerHand) <= 21)) {
			System.out.println("\nYou win!");
			

		}
	
	}
}
	//fix bug for when deck runs out of cards
	
	
	
