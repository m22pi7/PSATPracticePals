import java.util.*;

public class ScoreEstimation 
{
	public static int analyze(double[] ar, int mode)
	{
		double score=0;
		if(mode==1)
		{
			
			double easycorrect = 5*ar[0];
			double medcorrect = 3*ar[1];
			double hardcorrect = 2*ar[2];
			score = 380-40*(5-easycorrect)-30*(3-medcorrect)-20*(2-hardcorrect);
			
			if(score<=100)
			{
				score=100;
			}
		}
		else if(mode ==2)
		{
			double medcorrect = 6*ar[1];
			double hardcorrect = 4*ar[2];
			score = 380-30*(6-medcorrect)-20*(4-hardcorrect);
		}
		else
		{
			double hardcorrect = 10*ar[2];
			score = 380-20*(10-hardcorrect);
		}
		return (int) score;
	}

}
