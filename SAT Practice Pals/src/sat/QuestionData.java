package sat;

import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
		questionContext = new ArrayList<String>();
		questionWording = new ArrayList<String>();
		answers = new ArrayList<String[]>();
		correctAns = new ArrayList<Integer>();
		solCorrect = new ArrayList<String>();
		solWrong = new ArrayList<String>();
		
		if(difficulty == 1)
			questionParse = new BufferedReader(new FileReader("C:\\Users\\Sandra\\eclipse-workspace\\SAT Practice Pals\\Easy Questions.txt")); //replace with file location
		if(difficulty == 2)
			questionParse = new BufferedReader(new FileReader("C:\\Users\\Sandra\\eclipse-workspace\\SAT Practice Pals\\Medium Questions.txt")); //replace with file location
		if(difficulty == 3)
			questionParse = new BufferedReader(new FileReader("C:\\Users\\Sandra\\eclipse-workspace\\SAT Practice Pals\\Hard Questions.txt")); //replace with file location
		
		String line=null;
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
			if(line!=null) {
				//System.out.print(line);
				correctAns.add(Integer.parseInt(line));
			}
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
		return solWrong.get(num);
	}	
}