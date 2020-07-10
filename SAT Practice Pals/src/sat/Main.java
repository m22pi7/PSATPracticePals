package sat;

import java.util.*;
import sat.QuestionInfo;
import sat.ScoreEstimation;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//player names
		String player1Name;
		String player2Name;
		//difficulty that players selected
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
		difficulty=difficulty.toLowerCase();
		System.out.println("Here are the rules: ");
		System.out.println("1. There are 10 questions per round, with each question being worth 1 point");
		System.out.println("2. Both players answer the question, but only the first answer will be checked, so the faster player will get the points");
		System.out.println("3. Both players must answer the question before moving on");
		System.out.println("4. If the first player gets it wrong, then the second player's answer will be considered");
		System.out.println("5. "+player1Name+"\'s answer choices are: 1, 2, 3, and 4");
		System.out.println("6. "+player2Name+"\'s answer choices are 5, 6, 7, and 8");
		System.out.println("7. Make sure that there are no spaces between "+player1Name+"'s answer and "+player2Name+"'s answer");
		System.out.println("8. Also make sure to answer every question, as even though you may not get points, it will still affect your estimated SAT Writing score");
		System.out.println("9. Explanations for each question will be given after all questions are answered");
		System.out.println("10. Scores will be given after questions 5 and 10");
		System.out.println("11. Questions begin after the asterisk");
		
		//Note: chooses difficulty level of game
		switch(difficulty) {
			case "easy" :
				match(5, 3, 2, player1Name, player2Name, 1);
				break;
			case "medium":
				match(0, 6, 4, player1Name, player2Name, 2);
				break;
			case "hard":
				match(0, 0, 10, player1Name, player2Name, 3);
				break;
			default:
				System.out.println("So you chose easy mode then.");
				match(5, 3, 2, player1Name, player2Name, 1);
				break;			
		}	
	}
	
	//Note: asks the questions, and changes the types of questions based on the difficulty level
	public static void match(int easyNum, int medNum, int hardNum, String name1, String name2, int level) throws IOException {
		//points and questions answered correctly depend on scenario
		int scenario;
		//question number
		int round=1;
		//player scores
		int player1Score=0;
		int player2Score=0;
		//arrays with player averages: first is easy average, second is medium average, third is hard average
		double[] player1questions = new double[3];
		double[] player2questions = new double[3];
		//calls question
		QuestionInfo caller = new QuestionInfo();
		//question being asked
		Question currentQuestion;
		//use to calculate estimated scores
		ScoreEstimation scorer = new ScoreEstimation();
		//Note: where the easy questions are asked
		for(int i =0; i<easyNum; i++) {
			currentQuestion = caller.getQuestion(generateNum(13),1);
			scenario=checkAnswer(currentQuestion, round);
			if(scenario==1) {
				player1Score++;
				player1questions[0]++;
			} else if (scenario==2) {
				player2Score++;
				player2questions[0]++;
			} else if (scenario==3) {
				player1Score++;
				player1questions[0]++;
				player2questions[0]++;
			} else if (scenario==4) {
				player2Score++;
				player1questions[0]++;
				player2questions[0]++;
			}
			halftimeCheck(name1, name2, player1Score, player2Score, round);
			round++;
		}
		//Note: medium questions are asked
		for(int i =0; i<medNum; i++) {
			currentQuestion = caller.getQuestion(generateNum(11),2);
			scenario=checkAnswer(currentQuestion, round);
			if(scenario==1) {
				player1Score++;
				player1questions[1]++;
			} else if (scenario==2) {
				player2Score++;
				player2questions[1]++;
			} else if (scenario==3) {
				player1Score++;
				player1questions[1]++;
				player2questions[1]++;
			} else if (scenario==4) {
				player2Score++;
				player1questions[1]++;
				player2questions[1]++;
			}
			halftimeCheck(name1, name2, player1Score, player2Score, round);
			round++;
		}
		//Note: hard questions are asked
		for(int i =0; i<hardNum; i++) {
			currentQuestion = caller.getQuestion(generateNum(11),3);
			scenario=checkAnswer(currentQuestion, round);
			if(scenario==1) {
				player1Score++;
				player1questions[2]++;
			} else if (scenario==2) {
				player2Score++;
				player2questions[2]++;
			} else if (scenario==3) {
				player1Score++;
				player1questions[2]++;
				player2questions[2]++;
			} else if (scenario==4) {
				player2Score++;
				player1questions[2]++;
				player2questions[2]++;
			}
			halftimeCheck(name1, name2, player1Score, player2Score, round);
			round++;
		}
		//Note: announces winner, and prints estimated scores
		System.out.println(name1+" scored "+player1Score+" points");
		System.out.println(name2+" scored "+player2Score+" points");
		if(player1Score>player2Score) {
			System.out.println(name1+" won!");
		} else if(player2Score>player1Score) {
			System.out.println(name2+" won!");
		}else {
			System.out.println(name1+" and "+name2+" tied!");
		}
		player1questions[0]/=(double)easyNum;
		player2questions[0]/=(double)easyNum;
		player1questions[1]/=(double)medNum;
		player2questions[1]/=(double)medNum;
		player1questions[2]/=(double)hardNum;
		player2questions[2]/=(double)hardNum;
		System.out.println("We estimate "+name1+" would have scored about a "+scorer.analyze(player1questions, level)+" on the writing section of the SAT");
		System.out.println("We estimate "+name2+" would have scored about a "+scorer.analyze(player2questions, level)+" on the writing section of the SAT");
		
	}
	
	//Note: prints question, receives answers, and sees who gets points, and who got the question right
	public static int checkAnswer(Question q, int r) {
		Scanner c = new Scanner(System.in);
		//answer that players give
		int answer;
		//actual answer
		int trueAnswer=q.getAnswer();
		//scenario, but different name to make less confusing
		int scene=0;
		questionBackground(q, r);
		answer=c.nextInt();
		System.out.println(q.getCorrect());
		System.out.println(q.getWrong());
		if((answer/10)==trueAnswer) {
			if (((answer-40)/10)==trueAnswer) {
				scene=3;
			} else {
				scene=1;
			}
		} else if (((answer-40)/10)==trueAnswer) {
			if((answer/10)==trueAnswer) {
				scene=4;
			}else {
				scene=2;
			}
		} else {
			if((answer%10)==trueAnswer) {
				scene=1;
			} else if (((answer%10)-4)==trueAnswer) {
				scene=2;
			}
		}
		return scene;
	}
	
	//Note: generates which question will be chosen
	public static int generateNum(int limit) {
		return (int)(Math.random()*limit);
	}
	
	//Note: prints out context of question, the question itself, and all answer choices
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
	
	//Note: checks to see if the match is halfway done to announce scores
	public static void halftimeCheck(String name1, String name2, int score1, int score2, int roundNum) {
		if(roundNum==5) {
			System.out.println("Halfway through the match the scores are: ");
			System.out.println(name1+" : "+score1+" points");
			System.out.println(name2+" : "+score2+" points");
		}
	}
	
}
