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
	
		
		
		
		
		System.out.println(" /$$$$$$$ /$$       /$$$$$$   /$$$$$$ /$$   /$$    /$$$$$  /$$$$$$   /$$$$$$ /$$   /$$ ");
		System.out.println("| $$__  $| $$      /$$__  $$ /$$__  $| $$  /$$/   |__  $$ /$$__  $$ /$$__  $| $$  /$$/ ");
		System.out.println("| $$  | $| $$     | $$  | $$| $$  |__| $$ /$$/       | $$| $$  | $$| $$  |__| $$ /$$/  ");
		System.out.println("| $$$$$$$| $$     | $$$$$$$$| $$     | $$$$$/        | $$| $$$$$$$$| $$     | $$$$$/   ");
		System.out.println("| $$__  $| $$     | $$__  $$| $$     | $$  $$   /$$  | $$| $$__  $$| $$     | $$  $$   ");
		System.out.println("| $$    $| $$     | $$  | $$| $$    $| $$ | $$ | $$  | $$| $$  | $$| $$    $| $$ | $$  ");
		System.out.println("| $$$$$$$| $$$$$$$| $$  | $$|  $$$$$$| $$  | $$|  $$$$$$/| $$  | $$|  $$$$$$| $$  | $$ ");
		System.out.println("|_______/|________|__/  |__/  ______/|__/  |__/ |______/ |__/  |__/ ______/ |__/  |__/ ");
		
		
		
		
		
		
		
		
		System.out.println("\n\t------------------------------------------------");
		System.out.println("\t-             Welcome to the Blackjack         -");
		System.out.println("\t------------------------------------------------");

		System.out.println("\n\t\t   What would you like to do?");
		System.out.println("\n\n\t\t   ---------------------------");
		System.out.println("\t\t   -1. Practice table        -");
		System.out.println("\t\t   -2. Play with bank roll   -");
		System.out.println("\t\t   -3. View a shuffled deck  -");
		System.out.println("\t\t   ---------------------------");

		int userInput = sc.nextInt();
		switch (userInput) {

		case 1:
			System.out.println("\n\n\n\t ------------------------------------------------");
			System.out.println("\t -        Welcome to the practice table!        -");
			System.out.println("\t -                                              -");
			System.out.println("\t -            Lets deal some cards!             -");
			System.out.println("\t ------------------------------------------------");
			Deck deck = new Deck();
			dealer.deckPrep(deck);

			boolean playAgain = true;
			while (playAgain) {
//
//				if(deck.checkDeckSize() <= 21) {
//					deck = new Deck();
//					dealer.deckPrep(deck);
//				}
				
				List<Card> playerHand = new ArrayList<>();
				playerHand.add(deck.dealCard());
				// System.out.println("Player was delt 1 card");

				List<Card> dealerHand = new ArrayList<>();
				dealerHand.add(deck.dealCard());
				playerHand.add(deck.dealCard());
				dealerHand.add(deck.dealCard());

				System.out.println("\n\n\t\t    You are delt: " + playerHand.get(0));
				
				System.out.println("\n\t\t    Dealer is delt a card, face down");
				
				System.out.println("\n\t\t    You are delt: " + playerHand.get(1));
				
				System.out.println("\n\t\t    Dealer is delt: " + dealerHand.get(1));

				bjWithNoMoney.playerTurn(playerHand, deck);

				System.out.println("\n\t\tDealer shows both cards: " + dealerHand);
				bjWithNoMoney.dealersTurn(dealerHand, deck, playerHand);
 
				bjWithNoMoney.determineWinner(dealerHand, playerHand);
				bjWithNoMoney.clear();
				System.out.println("\n\t\t    Do you want to play again?");
				String userAnswer = sc.next();

				if (userAnswer.equalsIgnoreCase("yes") || (userAnswer.equalsIgnoreCase("y"))) {
					playAgain = true;
					
				}else	{ 
						System.out.println("\n\t\t    Thanks for playing,Good-Bye!");
						return;
				

				}

			}

			break;

		case 2:
			System.out.println("\n\n\n\t -------------------------------------------------");
			System.out.println("\t -                                               -");
			System.out.println("\t -       Welcome to the HighStakes table!        -");
			System.out.println("\t -                                               -");
			System.out.println("\t -------------------------------------------------");
			
			System.out.println("\n\tYou're playing the big dogs, table minimum is $1000,");
			int bankRoll = 0;
			if (bankRoll == 0) {
				System.out.println("\n   You're too broke to play, go see Fat Tony if you need to borrow money.");

				bankRoll = ls.getFatTonyLoan(bankRoll, sc);
				
				System.out.println("\n\t\t\tBankRoll is: $" + bankRoll);
			}

			if (bankRoll >= 500) {
				System.out.println("\n\t\tTake a seat and lets play");
				System.out.println("\t -------------------------------------------------");

				deck = new Deck();
				dealer.deckPrep(deck);

				System.out.println("\n\t\tPlace at least the minimum bet: $1000");
				boolean playAgain2 = true;
				
				while (playAgain2) {

					List<Card> playerHand = new ArrayList<>();
					int betAmount = bet.placeBet(bankRoll,sc);
					int totalBetInHand = betAmount;
					bankRoll -= betAmount;
					
					System.out.println("\n\t\t\tBankRoll is: $" + bankRoll);
					System.out.println("\t -------------------------------------------------");

					playerHand.add(deck.dealCard());
					// System.out.println("Player was delt 1 card");

					List<Card> dealerHand = new ArrayList<>();
					dealerHand.add(deck.dealCard());
					// System.out.println("\nDealer was delt 1 card, face down");
					dealerHand.add(deck.dealCard());

					playerHand.add(deck.dealCard());
					System.out.println("\n\n\t\t    You are delt: " + playerHand.get(0));
					
					System.out.println("\n\t\t    Dealer is delt a card, face down");
					
					System.out.println("\n\t\t    You are delt: " + playerHand.get(1));
					
					System.out.println("\n\t\t    Dealer is delt: " + dealerHand.get(1));


					bjWithMoney.playerTurn(playerHand, deck, totalBetInHand);

					System.out.println("\n\t\tDealer shows both cards: " + dealerHand);
					
					bjWithMoney.dealersTurn(dealerHand, deck, playerHand);

					int newBankRoll=bjWithMoney.determineWinner(dealerHand, playerHand,bankRoll, totalBetInHand);
					bankRoll=newBankRoll; 
					
					System.out.println("\n\t\t\tBankroll is: " + bankRoll);
					
					if(bankRoll <1000) {
						System.out.println("\n\tYou no longer have enough for the min bet.");
						playAgain2= false;
					} else if(bankRoll == 0) {
						
						System.err.println("\n\tYou lost everything! Expected a visit from Fat Tony...");
						playAgain2=false;
					}
					else if (bankRoll > 1000) {
					
					System.out.println("\n\t\t\tDo you want to another hand?");
					String userAnswer = sc.next();

					if (userAnswer.equalsIgnoreCase("yes")) {
						playAgain2 = true;
						
					}else	{ 
							System.out.println("\n\t\t    Thanks for playing,Good-Bye!");
							return;
					

					}
					}
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
