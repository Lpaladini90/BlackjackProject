package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Narrarator {
	
	Scanner sc = new Scanner(System.in);
	
	public void startGame() {
		
		BlackjackHandWBetting bjWithMoney = new BlackjackHandWBetting();
		BlackjackHandNoBetting bjWithNoMoney = new BlackjackHandNoBetting();
		LoanShark ls = new LoanShark();
		Dealer dealer = new Dealer();
		Betting bet = new Betting();
		
		System.out.println("        Welcome to the Blackjack Table!");
		System.out.println("------------------------------------------------");

		System.out.println("Would you like to practice or play with money?");
		System.out.println("---------------------------");
		System.out.println("-1. Practice table        -");
		System.out.println("-2. Play with bank roll   -");
		System.out.println("-3. View a shuffled deck  -");
		System.out.println("---------------------------");

		int userInput = sc.nextInt();
		switch (userInput) {

		case 1:
			System.out.println("Welcome to the practice table!");

			Deck deck = new Deck();
			dealer.deckPrep(deck);

			boolean playAgain = true;
			while (playAgain) {

				List<Card> playerHand = new ArrayList<>();
				playerHand.add(deck.dealCard());
				// System.out.println("Player was delt 1 card");

				List<Card> dealerHand = new ArrayList<>();
				dealerHand.add(deck.dealCard());
				// System.out.println("\nDealer was delt 1 card, face down");
				playerHand.add(deck.dealCard());
				dealerHand.add(deck.dealCard());

				System.out.println("\nYou were delt: " + playerHand);
				System.out.println("\nDealer is delt: " + dealerHand.get(1));

				bjWithNoMoney.playerTurn(playerHand, deck);

				System.out.println("\nDealer shows: " + dealerHand);
				bjWithNoMoney.dealersTurn(dealerHand, deck, playerHand);
 
				bjWithNoMoney.determineWinner(dealerHand, playerHand);

				System.out.println("\nDo you want to play again?");
				String userAnswer = sc.next();

				if (!userAnswer.equalsIgnoreCase("yes")) {
					playAgain = false;
					System.out.println("Thanks for playing,Good-Bye!");
					return;

				}

			}

			break;

		case 2:
			System.out.println("Welcome to the High Stakes table!");

			System.out.println("You're playing the big dogs, table minimum is $500,");
			int bankRoll = 0;
			if (bankRoll == 0) {
				System.out.println("\nYou're to broke to play, go see Fat Tony if you need to borrow money.");

				bankRoll = ls.getFatTonyLoan(bankRoll);
				System.out.println("You borrowed money from Fat Tony. Make sure you pay him back or else");
				System.out.println("\nBankRoll is: $" + bankRoll);
			}

			if (bankRoll >= 500) {
				System.out.println("Take a seat and lets play");

				deck = new Deck();
				dealer.deckPrep(deck);

				System.out.println("\nPlace at least the minimum bet: $500");
				boolean playAgain2 = true;
				while (playAgain2) {

					List<Card> playerHand = new ArrayList<>();
					int betAmount = bet.placeBet(sc );
					int totalBetInHand = betAmount;
					bankRoll -= betAmount;
					
					System.out.println("\nBankRoll is #1: $" + bankRoll);

					playerHand.add(deck.dealCard());
					// System.out.println("Player was delt 1 card");

					List<Card> dealerHand = new ArrayList<>();
					dealerHand.add(deck.dealCard());
					// System.out.println("\nDealer was delt 1 card, face down");
					dealerHand.add(deck.dealCard());

					playerHand.add(deck.dealCard());
					System.out.println("\nYou were delt: " + playerHand);
					System.out.println("\nDealers first card is face down, 2nd card delt: " + dealerHand.get(1));

					bjWithMoney.playerTurn(playerHand, deck);

					System.out.println("\nDealer shows: " + dealerHand);
					
					bjWithMoney.dealersTurn(dealerHand, deck, playerHand);

					int newBankRoll=bjWithMoney.determineWinner(dealerHand, playerHand,bankRoll, totalBetInHand);
					bankRoll=newBankRoll; 
					System.out.println("Bankroll is #2: " + bankRoll);
					
					if(bankRoll <500) {
						System.out.println("You no longer have enough for the min bet.");
						playAgain2= false;
					} else if(bankRoll == 0) {
						
						System.err.println("You lost everything! Expected a visit from Fat Tony...");
						playAgain2=false;
					}
					else if (bankRoll > 500) {
					
					System.out.println("\nDo you want to play again?");
					String userAnswer = sc.next();

					if (!userAnswer.equalsIgnoreCase("yes")) {
						playAgain2 = false;
						System.out.println("Thanks for playing,Good-Bye!");
						return;

					}
					}//if card deck is low create a new deck and start over
				} 
			}
			break;

			
		case 3:
			Deck decks = new Deck();
			System.out.println(decks);
			decks.shuffle();
			System.out.println(decks);
		
			
			
			
			break;
			
			
			
			
		default:
			System.out.println("Choose a valid response or leave my table!");
			break;

			
		}
		
		
	}

	
}
