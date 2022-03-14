package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class Betting {
	public Betting() {

	}

	public int placeBet( Scanner sc) {
		int betAmount = 0;
		boolean betting = true;
		while (betting) {

			System.out.println("Enter bet amount");
			betAmount = sc.nextInt();

			if (betAmount >= 500) {
				System.out.println();
				betting = false;
				return betAmount;

			} else if (betAmount < 500) {
				System.out.println("\nMin is $500, try again");
				betting = true;
				break;
			}

		}
		return betAmount;
	}

	public int winnerBlackjackBet(int bankRoll, int totalBetInHand) {

		int totalHandWinnings = ((int) (totalBetInHand * 1.5));
		System.out.println("\nWinnings: " + totalHandWinnings);
		bankRoll = totalBetInHand + totalHandWinnings;
		return bankRoll;

	}

//	public int loseBet(int totalBetInHand) { 
//		
//		totalBetInHand = 0;
//		return totalBetInHand;
//	}

	public int pushBet(int bankRoll, int totalBetInHand) {
		System.out.println("\nYour bet is returned.");
		bankRoll += totalBetInHand;
		return bankRoll; 
	}

	public int winsBet(int bankRoll, int totalBetInHand) {
		int totalHandWinnings = (totalBetInHand*2);
		System.out.println("\nWinnings: " + totalHandWinnings);
		System.out.println(bankRoll);
		bankRoll += totalHandWinnings;
		return bankRoll;
		
	}

	

	
	
	
	
}
