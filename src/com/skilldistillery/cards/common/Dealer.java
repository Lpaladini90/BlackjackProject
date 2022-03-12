package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealer extends Hand {

	// create a method for the dealer to deal cards

	public void deal(Scanner sc) {
		// create a new dealer
		Dealer dealer = new Dealer();

		// create a new deck for the dealer
		Deck deck = new Deck();
		// before dealing, the dealer needs to shuffle the deck.
		System.out.println("Welcome player");
		boolean nextHand = true;
		while(true) {
		deck.shuffle();

		// how many players are there, including dealer


		// int numberOfPlayers = 2;

		// if (numberOfPlayers == 2) {

		List<Card> dealerHand = new ArrayList<>();

		System.out.println("\nCards in deck remaining: " + deck.checkDeckSize());
		System.out.println("\nDealer deals to dealer 2 cards.");
		System.out.println("-------------------------");
		int currentDHV = 0;
		for (int i = 0; i < 2; i++) {
			Card card = deck.dealCard();
			currentDHV += card.getValue();
			dealerHand.add(card);

		}

		displayDealerCards(dealerHand, currentDHV);
		// create a players hand to store cards
		List<Card> playerHand = new ArrayList<>();

		// check size of deck first
		System.out.println("\n\n\n\n\nCards in deck remaining: " + deck.checkDeckSize());
		System.out.println("\nDealer deals to player 2 cards.");
		System.out.println("-------------------------");
		int currentPHV = 0;
		// loop through 2- starting amount of cards dealt to player
		for (int i = 0; i < 2; i++) {
			// assign a new card a card dealt from the deck
			Card card = deck.dealCard();
			// add that card to the players hand
			playerHand.add(card);
			// formula for displaying the value of the card
			currentPHV += card.getValue();
		}
		// displays the players and, card number and suit and also the total value of
		// current hand
		displayPlayerCards(playerHand, currentPHV);

		// 1. if players hand is 21 produce blackjack method
		if (currentPHV == 21) {

			blackjackWinner();

		}


		// players hand
		else if (currentPHV < 21) {

			boolean again = true;
			while (again) {
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
					// Assign current player hand value to
					int previousPHV = currentPHV;
					System.out.println("\nCards in deck remaining: " + deck.checkDeckSize());

					for (int i = 0; i < 1; i++) {
						Card card = deck.dealCard();
						// current value now equals old value plus new card
						currentPHV = previousPHV + card.getValue();
						playerHand.add(card);
						System.out.println("You've been delt a " + card);
					}
					System.out.println(" Your new hand value is: " + currentPHV);

					if (currentPHV == 21) {
						System.out.println("Nice!");
						again = false;
					}

					else if (currentPHV > 21) {
						bust();
						again = false;
					}

					break;

				case 2:
					System.out.println("Players stays.");
					again = false;
					break;

				default:
					System.out.println("Invalid input. Hit or stay.");
					break;

				}
			}
		}


		// DEALERS TURN:
		// if the dealer has 21 AND the player does not
		boolean dealerHit = true;
		while (dealerHit) {
			if(currentPHV > 21) {
				displayDealerCards(dealerHand, currentDHV);
				dealerWin();
				dealerHit = false;
			}
			
			else if ((currentDHV == 21) && (currentPHV != 21)) {

				displayDealerCards(dealerHand, currentDHV);
				dealerBlackjackWinner();
				dealerHit = false;
			}

			else if (currentDHV <= 16) {
				int previousDHV = currentDHV;
				System.out.println("\nCards in deck remaining: " + deck.checkDeckSize());
				displayDealerCards(dealerHand, currentDHV);

				for (int i = 0; i < 1; i++) {
					Card card = deck.dealCard();
					// current value now equals old value plus new card
					currentDHV = previousDHV + card.getValue();
					dealerHand.add(card);
					System.out.println("Dealer recieved a " + card);
				}
				System.out.println("Dealers has: " + currentDHV);

				if((currentDHV >=17) && (currentDHV <21)){
					System.out.println("Dealer stays");
					dealerHit= false;
				}
				
				else if (currentDHV == 21) {
					System.out.println("Ouch!");
					dealerHit = false;
				}

				else if (currentDHV > 21) {
					dealerBust();
					dealerHit = false;
				}
			}
		}

		// OPTIONS BEFORE DEALER CAN HIT- AUTO STAY
		// if dealer AND player hand values match. push no win
		if (currentDHV == currentPHV) {
			push();
		}
		// if dealers hand is great than or equal to 17, AND its greater than players
		// hand && less than 21
		else if ((currentDHV >= 17) && (currentDHV > currentPHV) && (currentDHV < 21)) {
			dealerWin();
		}

		// if dealer hand is greater than players AND less than 21
//		else if ((currentDHV > currentPHV) && (currentDHV < 21)) {
//			dealerWin();
//
//		} // if the dealers hand is greater or equal to than 17 AND less than 21 AND less
			// than players- dealer losses
		else if ((currentDHV >= 17) && (currentDHV < 21) && (currentDHV < currentPHV)) {
			dealerLoss();

		} else if ((currentDHV < currentPHV) && ( currentPHV <=21))  {
			playerWin();
			
		}

		System.out.println("Deal another hand?");
		String anotherHand = sc.nextLine();
		sc.next();
		
		if(anotherHand.equalsIgnoreCase("Yes")) {
			nextHand= true;
			
		} 
		else if (anotherHand.equalsIgnoreCase("No")) {
			nextHand = false;
		}
		
	}
		
	}

	private void playerWin() {
		System.out.println("Dealer loses! You win!");
	}

	private void dealerBust() {
		System.out.println("Dealer Busts! You win!");
	}


	private void dealerLoss() {
		System.out.println("\nDealer looses, Player Wins!");
	}

	private void dealerWin() {
		System.out.println("\nDealer Wins!");
	}

	private void push() {
		System.out.println("\nPush!");
	}

	// once player is finished hitting/staying move to dealer actions
	// create a loop for dealer
	// dealer displays both cards in hand, total value is displayed
	//
	//
	//
	//
	//
	//

	// push actions
	// if players hand matches dealers hand at end of turn, push. No one wins- tie

	// winning action
	// if dealer busts- player wins
	// if player busts- dealer wins
	//
	//

	// losing action
	//
	//
	//
	//
	//
	//
	//

	private void displayPlayerCards(List<Card> playerHand, int currentPHV) {
		System.out.println("\nYour cards are: " + playerHand);
		System.out.println("\nHand Value: " + currentPHV);
		System.out.println("-------------------------");

	}

	private void displayDealerCards(List<Card> dealerHand, int currentDHV) {
		System.out.println("\nDealers  cards are: " + dealerHand);
		System.out.println("\nHand Value: " + currentDHV);
		System.out.println("-------------------------");

	}

	private void dealerBlackjackWinner() {
		System.out.println("\nDEALER BLACKJACK!!");
		System.out.println("Winner Winner Chicken Dinner, but not for you!");
	}

	private void blackjackWinner() {
		System.out.println("\nBLACKJACK!!");
		System.out.println("Winner Winner Chicken Dinner!");
	}

	private void bust() {
		System.out.println("\nBUST! Too many cards!");
		System.out.println("Dealer Wins. womp womp waaaaaaa... LOSER");
	}
	

}
