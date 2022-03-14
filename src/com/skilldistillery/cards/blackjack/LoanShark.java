package com.skilldistillery.cards.blackjack;

import java.util.Objects;
import java.util.Scanner;

public class LoanShark {

	private String firstName = "Fat";
	private String lastName = "Tony";

	public LoanShark() {

	}

	public int getFatTonyLoan(int bankRoll, Scanner sc) {
		System.out.println("\n\t Yoooooo  I'm Fat Tonyyy, I heard ya need some money yah?");
		System.out.println("\t\t\tWell yes or no....");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
			System.out.println("\t   Well don't just stand there... how much do you need?!");
			bankRoll = sc.nextInt();
			
			System.out.println("Hmmm that's more than I expected, you better be good for it, or I WILL FIND YOU!");
			System.out.println("\n\t\t\t   Still want the loan?");
			System.out.println("\t\t\tWell yes or no....");
			answer = sc.next();
			
			if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
				System.out.println("\n\tAlright. Heres $" + bankRoll + "... I'll be keeping an eye on you.");
				System.out.println("\n\tIf you lose this and run, I'll break your legs.");
				System.out.println("\tIf you don't pay me back. I'll break your legs.");
				System.out.println("\tIf you think you can skip town, I'll break your legs.");
				System.out.println("\tNow get out of my sight.");
				System.out.println("-----------------------------------------------------------------------------");
				
				
			}else if(answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
				System.out.println("Then get out of here!!! SCRAM!!");
				
			}
			
		} else if(answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
			System.out.println("Then get out of here!!! SCRAM!!");
		}
			
		
		
		return bankRoll;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "LoanShark [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanShark other = (LoanShark) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}

}
