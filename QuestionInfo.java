import java.util.*;
import java.io.*;

public class QuestionInfo
{
	private QuestionData dataEasy;
	private QuestionData dataMedium;
	private QuestionData dataHard;
	
	public QuestionInfo()
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
		else if(difficulty == 3)
		{
			return new Question(dataHard.getContext(num), dataHard.getWording(num), dataHard.getAnswers(num), dataHard.getAns(num), dataHard.getCorrect(num), dataHard.getWrong(num));
		}
	}
}

public class QuestionData
{
	private ArrayList<String> questionContext;
	private ArrayList<String> questionWording;
	private ArrayList<String[]> answers;
	private ArrayList<Integer> correctAns;
	private ArrayList<String> solCorrect;
	private ArrayList<String> solWrong;
	private BufferedReader questionParse;
	
	public QuestionData(int difficulty) throws IOException
	{
		if(difficulty == 1)
			questionParse = new BufferedReader(new FileReader("")); //easy text file name
		if(difficulty == 2)
			questionParse = new BufferedReader(new FileReader("")); //medium text file name
		if(difficulty == 3)
			questionParse = new BufferedReader(new FileReader("")); //hard text file name
		
		String line = null;
		while((line = questionParse.readLine()) != null)
		{
			questionContext.add(line);
			line = questionParse.readLine();
			questionWording.add(line);
			String[] ans = new String[4];
			for(int i = 0; i < 4; i++)
			{
				line = questionParse.readLine();
				ans[i] = line;
			}
			answers.add(ans);
			line = questionParse.readLine();
			correctAns.add(Integer.parseInt(line));
			line = questionParse.readLine();
			solCorrect.add(line);
			line = questionParse.readLine();
			solWrong.add(line);
		}
	}
	
	public String getContext(int num)
	{
		return questionContext.get(num);
	}
	
	public String getWording(int num)
	{
		return questionWording.get(num);
	}
	
	public String[] getAnswers(int num)
	{
		return answers.get(num);
	}
	
	public int getAns(int num)
	{
		return correctAns.get(num);
	}
	
	public String getCorrect(int num)
	{
		return solCorrect.get(num);
	}
	
	public String getWrong(int num)
	{
		return getWrong.get(num);
	}	
}

public class Question
{
	private String context;
	private String wording;
	private String[] answers;
	private int answer;
	private String correct;
	private String wrong;
	
	public Question(String qcontext, String qwording, String[] qanswers, int qanswer, String qcorrect, String qwrong)
	{
		context = qcontext;
		wording = qwording;
		answers = qanswers;
		answer = qanswer;
		correct = qcorrect;
		wrong = qwrong;
	}
	
	public String getContext()
	{
		return context;
	}
	
	public String getWording()
	{
		return wording;
	}
	
	public String[] getAnswers()
	{
		return answers;
	}
	
	public int getAnswer()
	{
		return answer;
	}
	
	public String getCorrect()
	{
		return correct;
	}
	
	public String getWrong()
	{
		return wrong;
	}
	
}

