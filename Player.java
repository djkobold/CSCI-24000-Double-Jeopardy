//Daniel Kobold
//Player.java

public class Player 
{
	//integer for the player's score
	int score = 0;
	
	//String scoreS = "";
	
	//String for the player/team's name
	String name = "";
	
	//Player constructor (sets score to 0 and name to a blank String)
	public Player()
	{
		score = 0;
		name = "";
	}
	
	//Overloaded Player constructor with parameters for integer score and String name
	public Player(int sc, String na)
	{
		score = sc;
		name = na;
	}
	
	//incScore (increment score) method
	public void incScore(int add)
	{
		score += add;
	}
	
	//getScore method returns integer score
	public int getScore()
	{
		return score;
	}
	
	//getScoreS method originally returned the String representation of the player's score
	/*public String getScoreS()
	{
		scoreS += score;
		return scoreS;
	}*/
	
	//setName method sets the name to the String parameter given
	public void setName(String nam)
	{
		name = nam;
	}
	
	//getName method returns name String
	public String getName()
	{
		return name;
	}
}
