package com.skilldistillery.cards.blackjack;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackHandWBetting extends Hand {
	Scanner sc = new Scanner(System.in);
	Betting bet = new Betting();
	Dealer dealer = new Dealer();

	public BlackjackHandWBetting() {

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

		boolean hitAgain = true;
		if (isBlackjack(playerHand)) {
			System.out.println("\nBLACKJACK!!");

			hitAgain = false;
		}
		while (hitAgain) {

			if (getHandValue(playerHand) < 21) {
				System.out.println("\nYour hand value: " + getHandValue(playerHand));

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
						// System.out.println("Dealer Wins. womp womp waaaaaaa... LOSER");
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

		// dealer is going to hit. however before it checks if it should hit, first it
		// needs to check if the player busts
		// if player busts than dealer wins and does not need to show cards.
		boolean dealerHit = true;
		// DONE
		if (isBust(playerHand)) {
			// dealer wins
			dealerHit = false;

		}

		System.out.println(getHandValue(dealerHand));
		// DONE
		if (isBlackjack(dealerHand)) {
			dealerHit = false;
		}
//
		else if (isBlackjack(playerHand) && (!isBlackjack(dealerHand))) {
			//player has blackjack
			
			dealerHit = false;
		}
//		else if (isBlackjack(dealerHand) && (!isBlackjack(playerHand))) {
//			System.out.println("\nDealer Blackjack!");
//			dealerHit = false;
//		}
//
//		else if ((getHandValue(dealerHand) >= 17) && (getHandValue(dealerHand) <= 21)) {
//			System.out.println("\nDealer stays");
//			dealerHit = false;
//		}

		while (dealerHit) {

			if (getHandValue(dealerHand) <= 16) {
				System.out.println("\nDealer takes a card");
				dealerHand.add(deck.dealCard());
				System.out.println("\nDealer has been delt a " + dealerHand.get(dealerHand.size() - 1));
				System.out.println("\nDealers hand value is: " + getHandValue(dealerHand));
				System.out.println("\nCards in deck remaining: " + deck.checkDeckSize());
				
			}

			else if (getHandValue(dealerHand) == 21) {

				dealerHit = false;
			}

			else if (isBust(dealerHand)) {
				dealerHit = false;
			}
			if (getHandValue(dealerHand) >= 17 && getHandValue(dealerHand) < 21) {
				dealerHit = false;
			}
			
		}
	}

	public int determineWinner(List<Card> dealerHand, List<Card> playerHand, int bankRoll, int totalBetInHand) {

		// DONE
		// player bust, dealer wins, player loses bet.
		if (isBust(playerHand)) {
			// display dealer wins
			dealer.dealerWins();
			// player looses bet
//			bet.loseBet(totalBetInHand);
			// no money added to bankroll
			return bankRoll;
		}

		// DONE
		else if (((isBlackjack(dealerHand)) && (isBlackjack(playerHand)))) {
			push();
			return bet.pushBet(bankRoll, totalBetInHand);
			
		}

		else if (((isBlackjack(playerHand)) && (!isBlackjack(dealerHand)))) {
			playerBlackjack();
			return bet.winnerBlackjackBet(bankRoll, totalBetInHand);
			

		}

		else if (((isBlackjack(dealerHand)) && (!isBlackjack(playerHand)))) {
			dealer.dealerBlackjack();
			return bankRoll;
		}
		
		
		 
		

		// if the dealers hand is greater than or equal to 17 AND less than
		// 21 AND greater than the players hand- dealer wins- bets lost
		else if (((getHandValue(dealerHand) >= 17) && (getHandValue(dealerHand) <= 21))
				&& ((getHandValue(dealerHand)) > (getHandValue(playerHand)))) {
			dealer.dealerWins();
			return bankRoll;

		} 

		// if dealers hand and players hand match and both are within 17 and 21- push
		else if (((getHandValue(dealerHand) >= 17) && (getHandValue(dealerHand) <= 21))
				&& ((getHandValue(playerHand)>=17) && (getHandValue(playerHand) <=21)) && (getHandValue(dealerHand) == getHandValue(playerHand))) {
			push();
				return bet.pushBet(bankRoll, totalBetInHand);
			
		}

		else if ((getHandValue(dealerHand) >= 17 && getHandValue(dealerHand) <= 21)
				&& (getHandValue(dealerHand) < getHandValue(playerHand)) && (getHandValue(playerHand)>=17 && getHandValue(playerHand) <= 21)) {
			playerWins();
			 int winningBankRoll = bet.winsBet(bankRoll, totalBetInHand); 
			 System.out.println("Winning bank" + winningBankRoll);
			 return winningBankRoll;
			
		} 

		else  if(isBust(dealerHand)) {
				
			dealer.dealerBust();
			int winningBankRoll= bet.winsBet(bankRoll, totalBetInHand);
			System.out.println("Winning bank" + winningBankRoll);
			 return winningBankRoll;
			}
		return bankRoll;
			
			

		}
	
		// if dealer hand is greater than players AND less than 21
//		else if ((getHandValue(dealerHand) > getHandValue(playerHand)) && (getHandValue(dealerHand) < 21)) {
//			System.out.println("Dealer wins");
//
//		}
		// if the dealers hand is greater or equal to than 17 AND less than 21 AND less
		// than players- dealer losses

//
//		 else if ((getHandValue(dealerHand) < getHandValue(playerHand)) && (getHandValue(playerHand) <= 21)) {
//
//		r
	

	private void playerWins() {
		System.out.println("You win!");

	}

	public void push() {
		System.out.println("Push!");
	}
	// fix bug for when deck runs out of cards

	public void playerBlackjack() {
		System.out.println("Winner Winner Chicken Dinner!");
	}

}
