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

	@Override
	public void clear() {
		System.out.println("\n\n\t    ------------------------------------------------");
		System.out.println("\t    -	      Table hands have been cleared.       -");
		System.out.println("\t    ------------------------------------------------");
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

	public void playerTurn(List<Card> playerHand, Deck deck, int totalBetInHand) {
		System.out.println("\n        -----------------------------------------------------");
		System.out.println("\n\t\t    Your hand is: " + playerHand);
		System.out.println("\t\t    Your hand value: " + getHandValue(playerHand));
		if (isBlackjack(playerHand)) {
			System.out.println("\n\t\t************************************");
			System.out.println("\t\t            BLACKJACK!!");
			System.out.println("\t\t  Winner Winner Chicken Dinner!");
			System.out.println("\t\t************************************");

		}

		if (getHandValue(playerHand) < 21) {

			boolean hitAgain = true;
			while (hitAgain) {
				System.out.println("\n\t\t     -------------------------");
				System.out.println("\t\t     -   What is your move?  -");
				System.out.println("\t\t     -                       -");
				System.out.println("\t\t     -     1. HIT            -");
				System.out.println("\t\t     -                       -");
				System.out.println("\t\t     -       2. STAY         -");
				System.out.println("\t\t     -                       -");
				System.out.println("\t\t     -  3. Double 9,10,11    -");
				System.out.println("\t\t     -                       -");
				System.out.println("\t\t     -------------------------");

				int userInput = sc.nextInt();

				switch (userInput) {

				case 1:
					playerHand.add(deck.dealCard());

					// System.out.println("\nCards in deck remaining: " + deck.checkDeckSize());

					System.out.println("\n\t\t     You've been delt a " + playerHand.get(playerHand.size() - 1));

					System.out.println("\t\t    Your new hand value is: " + getHandValue(playerHand));
					
					if (getHandValue(playerHand) == 21) {
						hitAgain = false;
					}

					if (isBust(playerHand)) {

						hitAgain = false;
						continue;
					}

					break;

				case 2:
					System.out.println("\n\t\t\t      You stay.");
					System.out.println("\n        -----------------------------------------------------");
					hitAgain = false;
					break;
					
			 		
//				case 3:
//					if(getHandValue(playerHand)== 9 || getHandValue(playerHand)== 10 || getHandValue(playerHand)== 11 ) {
//						bet.doubleBet(totalBetInHand);
//						
//					}
//					hitAgain = true;
//					break;
//					
//					

				default:
					System.out.println("\n\tInvalid input. Hit or stay only.");
					break;
				}
			}
		}

	}

	public void dealersTurn(List<Card> dealerHand, Deck deck, List<Card> playerHand) {
		boolean dealerHit = true;
		if (isBust(playerHand)) {
			dealerHit = false;

		}

		System.out.println("\n\t\t\t Dealer hand value: " + getHandValue(dealerHand));
		System.out.println("\n        -----------------------------------------------------");
		if (isBlackjack(playerHand) && (!isBlackjack(dealerHand))) {
			dealerHit = false;
		} else if (isBlackjack(dealerHand) && (!isBlackjack(playerHand))) {
			dealerHit = false;
		}

		while (dealerHit) {

			if (getHandValue(dealerHand) <= 16) {
				System.out.println("\n\t\t\tDealer takes a card");
				dealerHand.add(deck.dealCard());
				System.out.println("\n\t\t\tDealer has been delt a " + dealerHand.get(dealerHand.size() - 1));
				System.out.println("\n\t\t\tDealers hand value is: " + getHandValue(dealerHand));
				System.out.println("\n        -----------------------------------------------------");
			} else if ((getHandValue(dealerHand) >= 17) && (getHandValue(dealerHand) <= 21)) {
				System.out.println("\n\t\t\t        Dealer stays");
				System.out.println("\n        -----------------------------------------------------");
				System.out.println("\n\t\t\tCards in deck remaining: " + deck.checkDeckSize());
				dealerHit = false;
			}

			else if (isBust(dealerHand)) {
				dealerHit = false;
			}
		}
		
	}

	public int determineWinner(List<Card> dealerHand, List<Card> playerHand, int bankRoll, int totalBetInHand) {

		if (isBust(playerHand)) {
			System.out.println("\n\t\t**************************************");
			System.out.println("\t\t       BUST! Too many cards!");
			System.out.println("\t\t       womp womp waaaaaaa...");
			System.out.println("\t\t                                        ");
			System.out.println("\t\t           Dealer Wins!");
			System.out.println("\t\t   You lose: $" + totalBetInHand);
			System.out.println("\t\t****************************************");
			return bankRoll;
		}

		else if (isBust(dealerHand) && (isBlackjack(playerHand))) {
			System.out.println("\n\t\t**************************************");
			System.out.println("\t\t            Dealer busts!");
			System.out.println("\t\t      You win: $" + (totalBetInHand + (totalBetInHand*1.5)));
			System.out.println("\t\t**************************************");
			return bet.winnerBlackjackBet(bankRoll, totalBetInHand);
			
		} 
		
		else if (isBust(dealerHand)) {
			System.out.println("\n\t\t**************************************");
			System.out.println("\t\t            Dealer busts!");
			System.out.println("\t\t      You win: $" + (totalBetInHand*2));
			System.out.println("\t\t**************************************");
			return bet.winsBet(bankRoll, totalBetInHand);
			
		}

		else if (isBlackjack(playerHand) && (!isBlackjack(dealerHand))) {
			System.out.println("\n\t*******************************************************");
			System.out.println("\t     Player BlackJack! You get to keep your dinner.");
			System.out.println("\t     You win: $" + (totalBetInHand + (totalBetInHand*1.5)));
			System.out.println("\t*********************************************************");
			return bet.winnerBlackjackBet(bankRoll, totalBetInHand);
			
		}

		else if (isBlackjack(dealerHand) && (isBlackjack(playerHand))) {
			System.out.println("\n\t*******************************************************");
			System.out.println("\t    Aw so close, no more chicken dinner. Push Hand");
			System.out.println("\t    You lose: $" + totalBetInHand);
			System.out.println("\t*********************************************************");
			return bankRoll;
		}

		else if (isBlackjack(dealerHand) && (!isBlackjack(playerHand))) {
			System.out.println("\n\t\t************************************");
			System.out.println("\t\t          Dealer Blackjack!");
			System.out.println("\t\t          You lose: $" + totalBetInHand);
			System.out.println("\t\t**************************************");
			return bankRoll;
		}

		else if ((getHandValue(dealerHand) >= 17) && (getHandValue(dealerHand) <= 21)
				&& (getHandValue(dealerHand) == getHandValue(playerHand))) {
			System.out.println("\n\t\t************************************");
			System.out.println("\t\t               Push");
			System.out.println("\t\t          Your bet of: $" + totalBetInHand + " is returned");
			System.out.println("\t\t**************************************");
			return bet.pushBet(bankRoll, totalBetInHand);
			
		}

		else if ((getHandValue(dealerHand) >= 17) && (getHandValue(dealerHand) > getHandValue(playerHand))
				&& (getHandValue(dealerHand) <= 21)) {
			System.out.println("\n\t\t**************************************");
			System.out.println("\t\t             Dealer wins");
			System.out.println("\t\t           You lose: $" + totalBetInHand);
			System.out.println("\t\t**************************************");
			return bankRoll;
		}

		else if ((getHandValue(dealerHand) >= 17) && (getHandValue(dealerHand) <= 21)
				&& (getHandValue(dealerHand) < getHandValue(playerHand)) && getHandValue(playerHand) <= 21) {
			System.out.println("\n\t\t************************************");
			System.out.println("\t\t           You win: $" + (totalBetInHand*2));
			System.out.println("\t\t**************************************");
			return bet.winsBet(bankRoll, totalBetInHand);
			
		}

		else if ((getHandValue(dealerHand) < getHandValue(playerHand)) && (getHandValue(playerHand) <= 21)) {
			System.out.println("\n\t\t**************************************");
			System.out.println("\t\t          You win: $" + (totalBetInHand*2));
			System.out.println("\t\t**************************************");
			return bet.winsBet(bankRoll, totalBetInHand);
			
		}
		return bankRoll;

	}

}
