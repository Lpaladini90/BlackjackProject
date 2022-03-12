package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Dealer;

public class BlackjackApp{
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

	BlackjackApp bj = new BlackjackApp();
	
	
		bj.start();
	
	} 
	
	
	private void start() {
		Dealer dealer = new Dealer();
		
		dealer.deal(sc);
		
	}
	
	
	
	
}
