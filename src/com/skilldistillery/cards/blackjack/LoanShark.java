package com.skilldistillery.cards.blackjack;

import java.util.Objects;

public class LoanShark {
	
	private String firstName = "Fat";
	private String lastName = "Tony";
	
	
	
	public LoanShark() {
		
		
	}
	
	
	public int getFatTonyLoan(int fatTonyLoan) {
		
		fatTonyLoan = 25000;
		
		
		return fatTonyLoan;
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
