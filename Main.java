package psat;
import java.util.*;
import psat.QuestionInfo;
import psat.ScoreEstimation;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		String player1Name;
		String player2Name;
		String difficulty;
		double[] player1 = new double[3];
		double[] player2 = new double[3];
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the SAT Writing Competition!");
		System.out.println("Player 1, please state your name: ");
		player1Name=scan.next();
		System.out.println("Player 2, please state your name: ");
		player2Name=scan.next();
		System.out.println("What difficulty level do you wish your game to be?");
		System.out.println("Easy, Medium, or Hard?");
		difficulty=scan.next();
		difficulty=difficulty.toLowerCase();
		System.out.println("Here are the rules: ");
		System.out.println("1. There are 10 questions per round, with each question being worth 1 point");
		System.out.println("2. Both players answer the question, but only the first answer will be checked, so the faster player will get the points");
		System.out.println("3. Both players must answer the question before moving on");
		System.out.println("4. If the first player gets it wrong, then the second player's answer will be considered");
		System.out.println("5. "+player1Name+"\'s answer choices are: 1, 2, 3, and 4");
		System.out.println("6. "+player2Name+"\'s answer choices are 5, 6, 7, and 8");
		System.out.println("7. Explanations for each question will be given after all questions are answered");
		System.out.println("8. Scores will be given after questions 5 and 10");
		System.out.println("9. Questions begin after the asterisk");
		//currentQuestion=caller.getQuestion(1, 1);
		//checkAnswer(player1Score, player2Score, scan, currentQuestion);
		//System.out.println(currentQuestion.getContext());
		switch(difficulty) {
			case "easy" :
				match(5, 3, 2, player1Name, player2Name);
				break;
			case "medium":
				match(0, 6, 4, player1Name, player2Name);
				break;
			case "hard":
				match(0, 0, 10, player1Name, player2Name);
				break;
			default:
				System.out.println("So you chose easy mode then.");
				match(5, 3, 2, player1Name, player2Name);
				break;			
		}	
	}
	
	public static void match(int easyNum, int medNum, int hardNum, String name1, String name2) throws IOException {
		int scenario;
		int round=1;
		int player1Score=0;
		int player2Score=0;
		QuestionInfo caller = new QuestionInfo();
		Question currentQuestion;
		for(int i =0; i<easyNum; i++) {
			currentQuestion = caller.getQuestion(generateNum(13),1);
			scenario=checkAnswer(currentQuestion, round);
			if(scenario==1) {
				player1Score++;
			} else if (scenario==2) {
				player2Score++;
			}
			halftimeCheck(name1, name2, player1Score, player2Score, round);
			round++;
		}
		for(int i =0; i<medNum; i++) {
			currentQuestion = caller.getQuestion(generateNum(11),2);
			scenario=checkAnswer(currentQuestion, round);
			if(scenario==1) {
				player1Score++;
			} else if (scenario==2) {
				player2Score++;
			}
			halftimeCheck(name1, name2, player1Score, player2Score, round);
			round++;
		}
		for(int i =0; i<hardNum; i++) {
			currentQuestion = caller.getQuestion(generateNum(11),3);
			scenario=checkAnswer(currentQuestion, round);
			if(scenario==1) {
				player1Score++;
			} else if (scenario==2) {
				player2Score++;
			}
			halftimeCheck(name1, name2, player1Score, player2Score, round);
			round++;
		}
		System.out.println(name1+" scored "+player1Score+" points");
		System.out.println(name2+" scored "+player2Score+" points");
		if(player1Score>player2Score) {
			System.out.println(name1+" won!");
		} else if(player2Score>player1Score) {
			System.out.println(name2+" won!");
		}else {
			System.out.println(name1+" and "+name2+" tied!");
		}
	}
	
	public static int checkAnswer(Question q, int r) {
		Scanner c = new Scanner(System.in);
		int answer;
		int trueAnswer=q.getAnswer();
		int scene=0;
		questionBackground(q, r);
		//System.out.println(q.getAnswer());
		answer=c.nextInt();
		if((answer/10)==trueAnswer) {
			scene=1;
		} else if (((answer-40)/10)==trueAnswer) {
			scene=2;
		} else {
			if((answer%10)==trueAnswer) {
				scene=1;
			} else if (((answer%10)-4)==trueAnswer) {
				scene=2;
			}
		}
		return scene;
	}
	
	public static int generateNum(int limit) {
		return (int)(Math.random()*limit);
	}
	
	public static void questionBackground(Question q, int r) {
		System.out.println("Question "+r);
		System.out.println("Here is the passage: ");
		System.out.println(q.getContext());
		if(q.getWording().equals("X")) {
			System.out.println("What option best replaces the section after the asterisk?");
		} else {
			System.out.println(q.getWording());
		}
		System.out.println("1(5). " + q.getAnswers()[0]);
		System.out.println("2(6). " + q.getAnswers()[1]);
		System.out.println("3(7). " + q.getAnswers()[2]);
		System.out.println("4(8). " + q.getAnswers()[3]);
	}
	
	public static void halftimeCheck(String name1, String name2, int score1, int score2, int roundNum) {
		if(roundNum==5) {
			System.out.println("Halfway through the match the scores are: ");
			System.out.println(name1+" : "+score1+" points");
			System.out.println(name2+" : "+score2+" points");
		}
	}
	
	
	
	
}
