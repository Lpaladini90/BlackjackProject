package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class Betting {
	public Betting() {

	}

	public int placeBet(int bankRoll, Scanner sc) {
		int betAmount = 0;
		boolean betting = true;
		while (betting) {

			System.out.println("\n\t\t\tEnter bet amount");
			betAmount = sc.nextInt();
			if(betAmount > bankRoll) {
				System.out.println("\n\tYou don't have enough for this bet, try again.");
				betting= true;
				
			}
			else if (betAmount >= 1000) {
				System.out.println();
				betting = false;
				return betAmount;

			} else if (betAmount < 1000) {
				System.out.println("\n\t\t\tMin is $1000, try again");
				betting = true;
				break;
			} 

		}
		return betAmount;
	}

	public int winnerBlackjackBet(int bankRoll, int totalBetInHand) {
		
		
		int totalHandWinnings = ((int) (totalBetInHand * 1.5));
		bankRoll = totalBetInHand + totalHandWinnings;
		return bankRoll;

	}

	public int doubleBet(int totalBetInHand) { 
		
		totalBetInHand*=2;
		return totalBetInHand;
	}

	public int pushBet(int bankRoll, int totalBetInHand) {
		bankRoll += totalBetInHand;
		return bankRoll; 
	}

	public int winsBet(int bankRoll, int totalBetInHand) {
		int totalHandWinnings = (totalBetInHand*2);
		bankRoll += totalHandWinnings;
		return bankRoll;
		
	}

	

	
	
	
	
}
