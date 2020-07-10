package sat;

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