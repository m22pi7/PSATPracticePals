package sat;
import java.util.*;
import java.io.*;
import sat.QuestionData;

public class QuestionInfo
{
	private QuestionData dataEasy;
	private QuestionData dataMedium;
	private QuestionData dataHard;
	
	public QuestionInfo() throws IOException
	{
		dataEasy = new QuestionData(1);
		dataMedium = new QuestionData(2);
		dataHard = new QuestionData(3);
	}
	
	public Question getQuestion(int num, int difficulty)
	{
		if(difficulty == 1)
		{
			return new Question(dataEasy.getContext(num), dataEasy.getWording(num), dataEasy.getAnswers(num), dataEasy.getAns(num), dataEasy.getCorrect(num), dataEasy.getWrong(num));
		}
		else if(difficulty == 2)
		{
			return new Question(dataMedium.getContext(num), dataMedium.getWording(num), dataMedium.getAnswers(num), dataMedium.getAns(num), dataMedium.getCorrect(num), dataMedium.getWrong(num));
		}
		else 
		{
			return new Question(dataHard.getContext(num), dataHard.getWording(num), dataHard.getAnswers(num), dataHard.getAns(num), dataHard.getCorrect(num), dataHard.getWrong(num));
		}
	}
}


