package psat;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		int player1Score=0;
		int player2Score=0;
		String player1Name;
		String player2Name;
		String difficulty;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the SAT Writing Competition!");
		System.out.println("Player 1, please state your name: ");
		player1Name=scan.next();
		System.out.println("Player 2, please state your name: ");
		player2Name=scan.next();
		System.out.println("What difficulty level do you wish your game to be?");
		System.out.println("Easy, Medium, or Hard?");
		difficulty=scan.next();
		difficulty.toLowerCase();
		System.out.println("Here are the rules: ");
		System.out.println("1. There are 10 questions per round, with each question being worth 1 point");
		System.out.println("2. Both players answer the question, but only the first answer will be checked, so the faster player will get the points");
		System.out.println("3. If the first player gets it wrong, then the second player's answer will be considered");
		System.out.println("4. "+player1Name+"\'s answer choices are: A, B, C, and D");
		System.out.println("5. "+player2Name+"\'s answer choices are 1, 2, 3, and 4");
		System.out.println("6. Explanations for each question will be given after all questions are answered");
		System.out.println("7. Scores will be given after questions 5 and 10");
		switch(difficulty) {
		case "easy" :
			
		}
		
		
		
	}
	public static void checkAnswer(int a, int b, Scanner c) {
		
	}
	
	
}
