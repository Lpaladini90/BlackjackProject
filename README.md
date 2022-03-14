
###    /$$$$$$$ /$$       /$$$$$$   /$$$$$$ /$$   /$$    /$$$$$  /$$$$$$   /$$$$$$ /$$   /$$
###	  | $$__  $| $$      /$$__  $$ /$$__  $| $$  /$$/   |__  $$ /$$__  $$ /$$__  $| $$  /$$/
###		| $$  | $| $$     | $$  | $$| $$  \__| $$ /$$/       | $$| $$  | $$| $$  \__| $$ /$$/  
###		| $$$$$$$| $$     | $$$$$$$$| $$     | $$$$$/        | $$| $$$$$$$$| $$     | $$$$$/   
###		| $$__  $| $$     | $$__  $$| $$     | $$  $$   /$$  | $$| $$__  $$| $$     | $$  $$   
###		| $$    $| $$     | $$  | $$| $$    $| $$\  $$ | $$  | $$| $$  | $$| $$    $| $$\  $$  
###		| $$$$$$$| $$$$$$$| $$  | $$|  $$$$$$| $$ \  $$|  $$$$$$/| $$  | $$|  $$$$$$| $$ \  $$
###		|_______/|________|__/  |__/ \______/|__/  \__/ \______/ |__/  |__/ \_____/ |__/  \__/


#### BlackjackProject





This project applications was simple yet full of OOP and great practice with most of everything we have learned so far in the course.

The goal was to build an app that would preform and carry out blackjack game rules to try and win.

I also added a fun betting side of things to this with a loan shark to borrow money from




### Structure
I used 13 different classes to achieve everything I was looking to do.

A core set of classes was created, to be non blackjack specific but card game specific, so I could reused these later one without writing code again.
Those classes were:
Deck
Card
Hand
Suit
Rank
Dealer

With little to no tweaking I should be able to reuse these for other games.

I had other classes, that implemented the rules and logic of Blackjack, betting, an app, a narrator to explain the moves and procedures of the game, as well as a loan shark to act as a bank.



Below are the stories I followed to complete my project.


User Story #1

Create a class structure that mimics a deck of cards. Remember decks as well as hands are made up of cards. Feel free to create the structure in any way you see fit.

Your card and deck implementations should NOT be coupled to Blackjack; you should be able to reuse them to implement a poker or bridge game application.

User Story #2
Add methods and fields to your classes that mimic the functionality of shuffling and dealing a deck of cards. Remember that when a card is dealt you have to remove it from the current deck. You should be able to print out a shuffled deck to the terminal.

User Story #3
Deal two hands of cards - one to a Dealer and another to a Player. Allow the players to Hit (add cards to their hand) or Stay (not add cards to their hand) in accordance to the rules of blackjack shown in the wiki.

Do not worry about the multiple values for Ace until your basic game logic is working. Assume they are either 1 or 11 to start.

User Story #4
The Dealer's decisions are based on game logic in the program.

The Dealer must decide to Hit or Stay based on the rules of Blackjack: if the Dealer's hand total is below 17, the Dealer must Hit; if the hand total is 17 or above, the Dealer must Stay.

User Story #5
Determine the winner of each round by implementing the remaining rules of Blackjack (such as going over 21) and comparing hand values.

### What I Learned and Improved

### Learning Objectives
Below are a list of objectives that the blackjack programing reinforcing.

Getting comfortable building classes in an Object-Oriented manner.
Building classes whose fields are Objects.
Practice writing methods.
Use collection types to organize and manage data.
Use conditionals to create game logic.


### Technology I Used
Extensive amounts of OOP
debugger
while loops
for loops
foreach loops
Array Lists
Swith loops
Menu creation
Scanner
instanciating classes to call methods
calling non static methods
ASCII Art


### What Was Fun

Coming up with the logic for the blackjack hands and the betting aspect was a blast. it was fun yet challenging, and by keeping a funny spin on these it seemed to make the game go smoother for me. I had a blast using the debugger to find small issues with my code which I was able to fix promptly.


### Grading
Your program must NOT be contained in one procedural main(). You MUST design a OO class structure.

When the game begins both the player and dealer are dealt two cards.

If a player or dealer is dealt 21 the game is over. Otherwise the player can choose to hit as many times as they wish until they choose to stay.

Once the player has completed their turn the dealer will begin their turn, automatically hitting or staying according to the Blackjack rules.

The game is immediately over if either player gets above 21.

The winner is displayed.
