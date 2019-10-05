//Daniel Kobold
//Board.java

//Import statements
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Board extends JFrame implements ActionListener{

	//Data array holds scores for each of the 5 questions of each of the 6 categories
	String[][] data = new String[6][5];
	
	//Question array holds questions for each of the 5 questions of each of the 6 categories
	String[][] quest = new String[6][5];
	
	//Answer array holds the 4 answer choices for each of the 5 questions of each of the 6 categories
	String[][][] ans = new String[6][5][4];
	
	//Category array holds the 6 categories
	String[] category = new String[6];
	
	//scoreChange array of integers stores the integer representation of changes to the six players' scores
	int[] scoreChange = new int[6];
	Question q = new Question();
	
	//Integer that stores the number of points a question is worth
	int pnts = 0;
	
	//"Indexing variables" with m representing the category number
	//and n representing the question number in a given category
	int m = 0;
	int n = 0;
	
	//next holds the integer representation of which player is going next
	int next = 0;
	
	//players array holds six Player objects
	Player[] players = new Player[6];
	
	//boolean sixPlayers = false;
	
	//JLabels for the categories
	JLabel catA = new JLabel();
	JLabel catB = new JLabel();
	JLabel catC = new JLabel();
	JLabel catD = new JLabel();
	JLabel catE = new JLabel();
	JLabel catF = new JLabel();
	
	//JButtons for each of the questions
	JButton btnA1 = new JButton();
	JButton btnA2 = new JButton();
	JButton btnA3 = new JButton();
	JButton btnA4 = new JButton();
	JButton btnA5 = new JButton();
	JButton btnB1 = new JButton();
	JButton btnB2 = new JButton();
	JButton btnB3 = new JButton();
	JButton btnB4 = new JButton();
	JButton btnB5 = new JButton();
	JButton btnC1 = new JButton();
	JButton btnC2 = new JButton();
	JButton btnC3 = new JButton();
	JButton btnC4 = new JButton();
	JButton btnC5 = new JButton();
	JButton btnD1 = new JButton();
	JButton btnD2 = new JButton();
	JButton btnD3 = new JButton();
	JButton btnD4 = new JButton();
	JButton btnD5 = new JButton();
	JButton btnE1 = new JButton();
	JButton btnE2 = new JButton();
	JButton btnE3 = new JButton();
	JButton btnE4 = new JButton();
	JButton btnE5 = new JButton();
	JButton btnF1 = new JButton();
	JButton btnF2 = new JButton();
	JButton btnF3 = new JButton();
	JButton btnF4 = new JButton();
	JButton btnF5 = new JButton();
	JPanel pnlBoard = new JPanel();
	
	//The current JButton
	JButton current;
	
	//Blank JLabels for use if there are not six players
	JLabel b0 = new JLabel("");
	JLabel b1 = new JLabel("");
	JLabel b2 = new JLabel("");
	JLabel b3 = new JLabel("");
	JLabel b4 = new JLabel("");
	JLabel b5 = new JLabel("");
	
	//Refresh/reload button for scores
	JButton reload = new JButton("Refresh Scores");
	
	//JLabels for the player/team names
	JLabel p1 = new JLabel();
	JLabel p2 = new JLabel();
	JLabel p3 = new JLabel();
	JLabel p4 = new JLabel();
	JLabel p5 = new JLabel();
	JLabel p6 = new JLabel();
	
	//JLabels for the player/team scores
	JLabel p1s = new JLabel();
	JLabel p2s = new JLabel();
	JLabel p3s = new JLabel();
	JLabel p4s = new JLabel();
	JLabel p5s = new JLabel();
	JLabel p6s = new JLabel();
	
	/*
	int sc1;
	int sc2;
	int sc3;
	int sc4;
	int sc5;
	int sc6;
	
	String s1;
	String s2;
	String s3;
	String s4;
	String s5;
	String s6;
	*/
	
	//Sub-panels for displaying the player/team name and score in one section of the JPanel
	//that is set up in a GridLayout
	JPanel sub1 = new JPanel();
	JPanel sub2 = new JPanel();
	JPanel sub3 = new JPanel();
	JPanel sub4 = new JPanel();
	JPanel sub5 = new JPanel();
	JPanel sub6 = new JPanel();
	
	//receivePlayer method receives an array of players
	public void receivePlayers(Player[] recPlayr)
	{
		//Sets the parameter array of players to the player array in this class
		players = recPlayr;
	}
	
	//Board constructor (doesn't do anything)
	public Board()
	{
		//loadBoard();
		//setUpGUI();
	}
	
	/*public void sixPlayerCheck()
	{
		if(players[0]!=null && players[1]!=null && players[2]!=null)
		{
			if(players[3]!=null && players[4]!=null && players[5]!=null)
			{
				sixPlayers = true;
			}
			else
				sixPlayers = false;
		}
		else
			sixPlayers = false;
					
	}*/
	
	//Gets the next player from the instance of the question class, based on
	//whichever player gets the answer right
	public void nextPlayer()
	{
		next = q.getNext();
	}
	
	//Returns the z^th category
	public String getCat(int z)
	{
		return category[z];
	}
	
	//Sets category z to the String set
	public void setCat(int z, String set)
	{
		category[z] = set;
	}
	
	//getData method returns the String of the point value of the x^th category, y^th question
	public String getData(int x, int y)
	{
		return data[x][y];
	}
	
	//setData method sets the point value of the x^th category, y^th question to the String set
	public void setData(int x, int y, String set)
	{
		data[x][y] = set;
	}
	
	//setQuest (set question) method sets the x^th category, y^th question to String que
	public void setQuest(int x, int y, String que)
	{
		quest[x][y] = que;
	}
	
	//setAns (set answer) method sets the c^th answer choice of the a^th category, b^th question
	//to the string anw
	public void setAns(int a, int b, int c, String anw)
	{
		ans[a][b][c] = anw;
	}
	
	/*
	public void displayBoard()
	{
		
	}
	*/
	
	/*public void addPlayer(String name, Color color)
	{
		JLabel player = new JLabel(name);
		player.setForeground(Color.ORANGE);
		player.setBackground(color);
		player.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
		pnlBoard.add(player);
	}*/
	
	//scoreChange method gets the score change array and applies the changes
	//to the players' scores
	public void scoreChange()
	{
		//Assigns the q's scoreChange array to the array of the same name in this class
		scoreChange = q.getScoreChange();
		
		/*if(scoreChange[0]>0)
			next = 0;
		else if(scoreChange[1]>0)
			next = 1;
		else if(scoreChange[2]>0)
			next = 2;
		else if(scoreChange[3]>0)
			next = 3;
		else if(scoreChange[4]>0)
			next = 4;
		else if(scoreChange[5]>0)
			next = 5;
		else
			next = 6;*/
		
		//If the player exists...
		if(players[0] != null)
		{
			//...call increment score method and change by the corresponding scoreChange integer
			players[0].incScore(scoreChange[0]);
			
			//Change that scoreChange integer to 0 so the change is not applied multiple times
			scoreChange[0] = 0;
		}
		//See above comments
		if(players[1] != null)
		{
			players[1].incScore(scoreChange[1]);
			scoreChange[1] = 0;
		}
		//See above comments
		if(players[2] != null)
		{
			players[2].incScore(scoreChange[2]);
			scoreChange[2] = 0;
		}
		//See above comments
		if(players[3] != null)
		{
			players[3].incScore(scoreChange[3]);
			scoreChange[3] = 0;
		}
		//See above comments
		if(players[4] != null)
		{
			players[4].incScore(scoreChange[4]);
			scoreChange[4] = 0;
		}
		//See above comments
		if(players[5] != null)
		{
			players[5].incScore(scoreChange[5]);
			scoreChange[5] = 0;
		}
		//Calls reloadBoard method to reload the JPanel
		reloadBoard();
		
		/*for(int a = 0; a < 6; a++)
		{
			System.out.println("P Score Change:");
			System.out.println(scoreChange[a]);
			System.out.println("New score:");
			if(players[a] != null)
				System.out.println(players[a].getScore());
		}*/
	}
	
	//Note about the reloadBoard method: I could not get this method to behave how
	//I wanted it to, the readyCheck was meant to only allow reloadBoard to be executed
	//when the question was "ready", meaning the close button had already been pressed
	//Instead, I decided to make a separate button on the board itself so the user
	//could manually choose to reload the board
	public void reloadBoard()
	{	
		//Calls the nextPlayer method to determine the next player based on whichever
		//player/team got the previous question right
		nextPlayer();
		
		//See above note regarding readyCheck
		if(q.readyCheck() == 1)
		{	
			//Sets the pnlBoard Container to this content pane
			Container pnlBoard = this.getContentPane();
			
			//Sets layout to a grid layout
			pnlBoard.setLayout(new GridLayout(8,6));
			
			//Adds all of the categories to the board
		    pnlBoard.add(catA);
		    pnlBoard.add(catB);
		    pnlBoard.add(catC);
		    pnlBoard.add(catD);
		    pnlBoard.add(catE);
		    pnlBoard.add(catF);
		    //pnlBoard.add(b0);
		    
		    //Adds the first row of buttons to the board
		    pnlBoard.add(btnA1);
		    pnlBoard.add(btnB1);
		    pnlBoard.add(btnC1);
		    pnlBoard.add(btnD1);
		    pnlBoard.add(btnE1);
		    pnlBoard.add(btnF1);
		    //pnlBoard.add(b1);
		    
		    //Adds the second row of buttons to the board
		    pnlBoard.add(btnA2);
		    pnlBoard.add(btnB2);
		    pnlBoard.add(btnC2);
		    pnlBoard.add(btnD2);
		    pnlBoard.add(btnE2);
		    pnlBoard.add(btnF2);
		    //pnlBoard.add(b2);
		    
		    //Adds the third row of buttons to the board
		    pnlBoard.add(btnA3);
		    pnlBoard.add(btnB3);
		    pnlBoard.add(btnC3);
		    pnlBoard.add(btnD3);
		    pnlBoard.add(btnE3);
		    pnlBoard.add(btnF3);
		    //pnlBoard.add(b3);
		    
		    //Adds the fourth row of buttons to the board
		    pnlBoard.add(btnA4);
		    pnlBoard.add(btnB4);
		    pnlBoard.add(btnC4);
		    pnlBoard.add(btnD4);
		    pnlBoard.add(btnE4);
		    pnlBoard.add(btnF4);
		    //pnlBoard.add(b4);
		    
		    //Adds the fifth row of buttons to the board
		    pnlBoard.add(btnA5);
		    pnlBoard.add(btnB5);
		    pnlBoard.add(btnC5);
		    pnlBoard.add(btnD5);
		    pnlBoard.add(btnE5);
		    pnlBoard.add(btnF5);
		    //pnlBoard.add(b5);
		    
		    /*pnlBoard.add(p1);
		    pnlBoard.add(p2);
		    pnlBoard.add(p3);
		    pnlBoard.add(p4);
		    pnlBoard.add(p5);
		    pnlBoard.add(p6);*/
		    //pnlBoard.add(reload);
			
		    //The following lines of code are very similar for each player.
		    //To avoid redundancy, only the first player will be completely commented
		    //and the others will just refer to the first player's comments
		    
		    //If the player exists
			if(players[0] != null)
			{
				//pnlBoard.remove(sub1);
				
				//Set the sub-panel layout to a grid layout
				sub1.setLayout(new GridLayout(2,1));
				
				//Set the player name JLabel to the player's name
				p1.setText(players[0].getName());
				
				//Set the player's name JLabel background to black
				p1.setBackground(Color.BLACK);
				
				//If this is the next player (n==player's number in player array)
				if(next==0)
					//Set the sub-panel background to white
					sub1.setBackground(Color.WHITE);
				else
					//Otherwise, set the sub-panel background to black
					sub1.setBackground(Color.BLACK);
				
				//Set the foreground (text) color to orange for the player's name JLabel
				p1.setForeground(Color.ORANGE);
				
				//Sets the font of the player's name JLabel
				p1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				
				//Adds the player's name JLabel to the sub-panel
				sub1.add(p1);
				
				//players[0].incScore(0);
				//s1 = Integer.toString(players[0].getScore());
				
				//Sets the text in the player's score JLabel to the updated score from the
				//instance of the question class (this allows the most updated score to be displayed)
				p1s.setText(q.getScore(0));
				
				//p1s.setText(Integer.toString(players[0].getScore()));
				
				//Sets the font of the player's score JLabel
				p1s.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				
				//Sets the foreground (text) color to orange for the player's score JLabel
				p1s.setForeground(Color.ORANGE);
				
				//p1s.setBackground(Color.BLACK);
				
				//Adds the player's score JLabel to the sub-panel
				sub1.add(p1s);
				//sub1.setBackground(Color.BLACK);
				
				//Addds the sub-panel to the JPanel pnlBoard
				pnlBoard.add(sub1);
			}
			//Otherwise, adds a blank JLabel instead of the sub-panel
			else
				pnlBoard.add(p1);
			
			//See above comments
			if(players[1] != null)
			{
				//pnlBoard.remove(sub2);
				sub2.setLayout(new GridLayout(2,1));
				p2.setText(players[1].getName());
				p2.setBackground(Color.BLACK);
				if(next==1)
					sub2.setBackground(Color.WHITE);
				else
					sub2.setBackground(Color.BLACK);
				p2.setForeground(Color.ORANGE);
				p2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				sub2.add(p2);
				//players[0].incScore(0);
				//s1 = Integer.toString(players[0].getScore());
				p2s.setText(q.getScore(1));
				//p2s.setText(Integer.toString(players[1].getScore()));
				p2s.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				p2s.setForeground(Color.ORANGE);
				//p2s.setBackground(Color.BLACK);
				sub2.add(p2s);
				//sub2.setBackground(Color.BLACK);
				pnlBoard.add(sub2);
			}
			else
				pnlBoard.add(p2);
			
			//See above comments
			if(players[2] != null)
			{
				//pnlBoard.remove(sub3);
				sub3.setLayout(new GridLayout(2,1));
				p3.setText(players[2].getName());
				p3.setBackground(Color.BLACK);
				if(next==2)
					sub3.setBackground(Color.WHITE);
				else
					sub3.setBackground(Color.BLACK);
				p3.setForeground(Color.ORANGE);
				p3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				sub3.add(p3);
				//players[0].incScore(0);
				//s1 = Integer.toString(players[0].getScore());
				p3s.setText(q.getScore(2));
				//p3s.setText(Integer.toString(players[2].getScore()));
				p3s.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				p3s.setForeground(Color.ORANGE);
				//p3s.setBackground(Color.BLACK);
				sub3.add(p3s);
				//sub3.setBackground(Color.BLACK);
				pnlBoard.add(sub3);
			}
			else
				pnlBoard.add(p3);
			
			//See above comments
			if(players[3] != null)
			{
				//pnlBoard.remove(sub4);
				sub4.setLayout(new GridLayout(2,1));
				p4.setText(players[3].getName());
				p4.setBackground(Color.BLACK);
				if(next==3)
					sub4.setBackground(Color.WHITE);
				else
					sub4.setBackground(Color.BLACK);
				p4.setForeground(Color.ORANGE);
				p4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				sub4.add(p4);
				//players[0].incScore(0);
				//s1 = Integer.toString(players[0].getScore());
				p4s.setText(q.getScore(3));
				//p4s.setText(Integer.toString(players[3].getScore()));
				p4s.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				p4s.setForeground(Color.ORANGE);
				//p4s.setBackground(Color.BLACK);
				sub4.add(p4s);
				//sub4.setBackground(Color.BLACK);
				pnlBoard.add(sub4);
			}
			else
				pnlBoard.add(p4);
			
			//See above comments
			if(players[4] != null)
			{
				//pnlBoard.remove(sub5);
				sub5.setLayout(new GridLayout(2,1));
				p5.setText(players[4].getName());
				p5.setBackground(Color.BLACK);
				if(next==4)
					sub5.setBackground(Color.WHITE);
				else
					sub5.setBackground(Color.BLACK);
				p5.setForeground(Color.ORANGE);
				p5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				sub5.add(p5);
				//players[0].incScore(0);
				//s1 = Integer.toString(players[0].getScore());
				p5s.setText(q.getScore(4));
				//p5s.setText(Integer.toString(players[4].getScore()));
				p5s.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				p5s.setForeground(Color.ORANGE);
				//p5s.setBackground(Color.BLACK);
				sub5.add(p5s);
				//sub5.setBackground(Color.BLACK);
				pnlBoard.add(sub5);
			}
			else
				pnlBoard.add(p5);
			
			//See above comments
			if(players[5] != null)
			{
				//pnlBoard.remove(sub6);
				sub6.setLayout(new GridLayout(2,1));
				p6.setText(players[5].getName());
				p6.setBackground(Color.BLACK);
				if(next==5)
					sub6.setBackground(Color.WHITE);
				else
					sub6.setBackground(Color.BLACK);
				p6.setForeground(Color.ORANGE);
				p6.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				sub6.add(p6);
				//players[0].incScore(0);
				//s1 = Integer.toString(players[0].getScore());
				p6s.setText(q.getScore(5));
				//p6s.setText(Integer.toString(players[5].getScore()));
				p6s.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				p6s.setForeground(Color.ORANGE);
				//p6s.setBackground(Color.BLACK);
				sub6.add(p6s);
				//sub6.setBackground(Color.BLACK);
				pnlBoard.add(sub6);
			}
			else
				pnlBoard.add(p6);
			
			//Adds the reload button to pnlBoard
			pnlBoard.add(reload);
		}
	}
	
	//loadBoard method gets all of the information that was assigned to the String arrays
	//when the game's .txt file was read in another class, and then calls setUpGUI method
	public void loadBoard()
	{
		//Gets each category and assigns the corresponding JLabel text to that category name
		catA.setText(getCat(0));
		catB.setText(getCat(1));
		catC.setText(getCat(2));
		catD.setText(getCat(3));
		catE.setText(getCat(4));
		catF.setText(getCat(5));
		
		//Sets the button texts to the point value for each question
		btnA1.setText(getData(0,0));
		btnA2.setText(getData(0,1));
		btnA3.setText(getData(0,2));
		btnA4.setText(getData(0,3));
		btnA5.setText(getData(0,4));
		btnB1.setText(getData(1,0));
		btnB2.setText(getData(1,1));
		btnB3.setText(getData(1,2));
		btnB4.setText(getData(1,3));
		btnB5.setText(getData(1,4));
		btnC1.setText(getData(2,0));
		btnC2.setText(getData(2,1));
		btnC3.setText(getData(2,2));
		btnC4.setText(getData(2,3));
		btnC5.setText(getData(2,4));
		btnD1.setText(getData(3,0));
		btnD2.setText(getData(3,1));
		btnD3.setText(getData(3,2));
		btnD4.setText(getData(3,3));
		btnD5.setText(getData(3,4));
		btnE1.setText(getData(4,0));
		btnE2.setText(getData(4,1));
		btnE3.setText(getData(4,2));
		btnE4.setText(getData(4,3));
		btnE5.setText(getData(4,4));
		btnF1.setText(getData(5,0));
		btnF2.setText(getData(5,1));
		btnF3.setText(getData(5,2));
		btnF4.setText(getData(5,3));
		btnF5.setText(getData(5,4));
		
		/*p1.setText(super.getPlayerName(0));
		p2.setText(super.getPlayerName(1));
		p3.setText(super.getPlayerName(2));
		p4.setText(super.getPlayerName(3));
		p5.setText(super.getPlayerName(4));
		p6.setText(super.getPlayerName(5));*/
		
		//Calls setUpGUI
		setUpGUI();
	}
	
	//setUpGUI method sets up the GUI component for this class
	public void setUpGUI()
	{
		//Sets pnlBoard container to this content pane
	    Container pnlBoard = this.getContentPane();
	    
	    //Sets pnlBoard layout to a new GridLayout
	    pnlBoard.setLayout(new GridLayout(8,6));
	    
	    //Adds the category JLabels to pnlBoard
	    pnlBoard.add(catA);
	    pnlBoard.add(catB);
	    pnlBoard.add(catC);
	    pnlBoard.add(catD);
	    pnlBoard.add(catE);
	    pnlBoard.add(catF);
	    //pnlBoard.add(b0);
	    
	    //Adds the first row of question buttons to pnlBoard
	    pnlBoard.add(btnA1);
	    pnlBoard.add(btnB1);
	    pnlBoard.add(btnC1);
	    pnlBoard.add(btnD1);
	    pnlBoard.add(btnE1);
	    pnlBoard.add(btnF1);
	    //pnlBoard.add(b1);
	    
	    //Adds the second row of question buttons to pnlBoard
	    pnlBoard.add(btnA2);
	    pnlBoard.add(btnB2);
	    pnlBoard.add(btnC2);
	    pnlBoard.add(btnD2);
	    pnlBoard.add(btnE2);
	    pnlBoard.add(btnF2);
	    //pnlBoard.add(b2);
	    
	    //Adds the third row of question buttons to pnlBoard
	    pnlBoard.add(btnA3);
	    pnlBoard.add(btnB3);
	    pnlBoard.add(btnC3);
	    pnlBoard.add(btnD3);
	    pnlBoard.add(btnE3);
	    pnlBoard.add(btnF3);
	    //pnlBoard.add(b3);
	    
	    //Adds the fourth row of question buttons to pnlBoard
	    pnlBoard.add(btnA4);
	    pnlBoard.add(btnB4);
	    pnlBoard.add(btnC4);
	    pnlBoard.add(btnD4);
	    pnlBoard.add(btnE4);
	    pnlBoard.add(btnF4);
	    //pnlBoard.add(b4);
	    
	    //Adds the fifth row of question buttons to pnlBoard
	    pnlBoard.add(btnA5);
	    pnlBoard.add(btnB5);
	    pnlBoard.add(btnC5);
	    pnlBoard.add(btnD5);
	    pnlBoard.add(btnE5);
	    pnlBoard.add(btnF5);
	    //pnlBoard.add(b5);
	    
	   /* pnlBoard.add(p1);
	    pnlBoard.add(p2);
	    pnlBoard.add(p3);
	    pnlBoard.add(p4);
	    pnlBoard.add(p5);
	    pnlBoard.add(p6);*/
	    //pnlBoard.add(reload);
	    
	    //The following lines of code are very similar for each player.
	    //To avoid redundancy, only the first player will be completely commented
	    //and the others will just refer to the first player's comments
	    
	    //If the player exists
		if(players[0] != null)
		{
			//Sets layout of the sub-panel to a new GridLayout
			sub1.setLayout(new GridLayout(2,1));
			
			//Sets text of player name JLabel to the corresponding player name
			p1.setText(players[0].getName());
			
			//Sets the background of player name JLabel to black
			p1.setBackground(Color.BLACK);
			
			//Sets foreground (text) color of player name JLabel to orange
			p1.setForeground(Color.ORANGE);
			
			//Sets font of player name JLabel
			p1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			
			//Adds player name JLabel to sub-panel
			sub1.add(p1);
			
			//players[0].incScore(0);
			//s1 = Integer.toString(players[0].getScore());
			
			//Sets player score JLabel to the parsed integer score from the corresponding player
			p1s.setText(Integer.toString(players[0].getScore()));
			
			//Sets the font of player score JLabel
			p1s.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			
			//Sets the foreground (text) color of player score JLabel to orange
			p1s.setForeground(Color.ORANGE);
			
			//Sets the background of player score JLabel to black
			p1s.setBackground(Color.BLACK);
			
			//Adds player score JLabel to sub-panel
			sub1.add(p1s);
			
			//Sets the background of the sub-panel to white (Since this player goes first)
			sub1.setBackground(Color.WHITE);
			
			//Adds the sub-panel to the pnlBoard
			pnlBoard.add(sub1);
		}
		//Otherwise, adds a blank JLabel to the pnlBoard
		else
			pnlBoard.add(p1);
		
		//See above comments
		if(players[1] != null)
		{
			sub2.setLayout(new GridLayout(2,1));
			p2.setText(players[1].getName());
			p2.setBackground(Color.BLACK);
			p2.setForeground(Color.ORANGE);
			p2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			sub2.add(p2);
			//players[0].incScore(0);
			//s1 = Integer.toString(players[0].getScore());
			p2s.setText(Integer.toString(players[1].getScore()));
			p2s.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			p2s.setForeground(Color.ORANGE);
			p2s.setBackground(Color.BLACK);
			sub2.add(p2s);
			sub2.setBackground(Color.BLACK);
			pnlBoard.add(sub2);
		}
		else
			pnlBoard.add(p2);
		
		//See above comments
		if(players[2] != null)
		{
			sub3.setLayout(new GridLayout(2,1));
			p3.setText(players[2].getName());
			p3.setBackground(Color.BLACK);
			p3.setForeground(Color.ORANGE);
			p3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			sub3.add(p3);
			//players[0].incScore(0);
			//s1 = Integer.toString(players[0].getScore());
			p3s.setText(Integer.toString(players[2].getScore()));
			p3s.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			p3s.setForeground(Color.ORANGE);
			p3s.setBackground(Color.BLACK);
			sub3.add(p3s);
			sub3.setBackground(Color.BLACK);
			pnlBoard.add(sub3);
		}
		else
			pnlBoard.add(p3);
		
		//See above comments
		if(players[3] != null)
		{
			sub4.setLayout(new GridLayout(2,1));
			p4.setText(players[3].getName());
			p4.setBackground(Color.BLACK);
			p4.setForeground(Color.ORANGE);
			p4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			sub4.add(p4);
			//players[0].incScore(0);
			//s1 = Integer.toString(players[0].getScore());
			p4s.setText(Integer.toString(players[3].getScore()));
			p4s.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			p4s.setForeground(Color.ORANGE);
			p4s.setBackground(Color.BLACK);
			sub4.add(p4s);
			sub4.setBackground(Color.BLACK);
			pnlBoard.add(sub4);
		}
		else
			pnlBoard.add(p4);
		
		//See above comments
		if(players[4] != null)
		{
			sub5.setLayout(new GridLayout(2,1));
			p5.setText(players[4].getName());
			p5.setBackground(Color.BLACK);
			p5.setForeground(Color.ORANGE);
			p5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			sub5.add(p5);
			//players[0].incScore(0);
			//s1 = Integer.toString(players[0].getScore());
			p5s.setText(Integer.toString(players[4].getScore()));
			p5s.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			p5s.setForeground(Color.ORANGE);
			p5s.setBackground(Color.BLACK);
			sub5.add(p5s);
			sub5.setBackground(Color.BLACK);
			pnlBoard.add(sub5);
		}
		else
			pnlBoard.add(p5);
		
		//See above comments
		if(players[5] != null)
		{
			sub6.setLayout(new GridLayout(2,1));
			p6.setText(players[5].getName());
			p6.setBackground(Color.BLACK);
			p6.setForeground(Color.ORANGE);
			p6.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			sub6.add(p6);
			//players[0].incScore(0);
			//s1 = Integer.toString(players[0].getScore());
			p6s.setText(Integer.toString(players[5].getScore()));
			p6s.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			p6s.setForeground(Color.ORANGE);
			p6s.setBackground(Color.BLACK);
			sub6.add(p6s);
			sub6.setBackground(Color.BLACK);
			pnlBoard.add(sub6);
		}
		else
			pnlBoard.add(p6);
		
		//Sets the font of the reload button
		reload.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		
		//Adds the reload button to pnlBoard
		pnlBoard.add(reload);
		
		//Adds an action listener to the reload button
		reload.addActionListener(this);

		//Sets the background of pnlBoard to blue
	    pnlBoard.setBackground(Color.BLUE);
	    
	    //Sets category JLabel foreground (text) color to orange
	    catA.setForeground(Color.ORANGE);
	    
	    //Sets category JLabel font
	    catA.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    
	    //Sets category JLabel foreground (text) color to orange
	    catB.setForeground(Color.ORANGE);
	    
	    //Sets category JLabel font
	    catB.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    
	    //Sets category JLabel foreground (text) color to orange
	    catC.setForeground(Color.ORANGE);
	    
	    //Sets category JLabel font
	    catC.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    
	    //Sets category JLabel foreground (text) color to orange
	    catD.setForeground(Color.ORANGE);
	    
	    //Sets category JLabel font
	    catD.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    
	    //Sets category JLabel foreground (text) color to orange
	    catE.setForeground(Color.ORANGE);
	    
	    //Sets category JLabel font
	    catE.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    
	    //Sets category JLabel foreground (text) color to orange
	    catF.setForeground(Color.ORANGE);
	    
	    //Sets category JLabel font
	    catF.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    
	    //The following lines of code are very similar for each button.
	    //To avoid redundancy, only the first button will be completely commented
	    //and the others will just refer to the first button's comments
	    
	    //If the button's background is not already gray...
    	if(btnA1.getBackground() != Color.GRAY)
    		//...set the button's background to blue
    		//If it is gray, the question has already been answered
    		btnA1.setBackground(Color.BLUE);
    	//Sets the foreground (text) color of the button to orange
	    btnA1.setForeground(Color.ORANGE);
	    //Sets the font of the JButton
	    btnA1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnA2.getBackground() != Color.GRAY)
	    	btnA2.setBackground(Color.BLUE);
	    btnA2.setForeground(Color.ORANGE);
	    btnA2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnA3.getBackground() != Color.GRAY)
	    	btnA3.setBackground(Color.BLUE);
	    btnA3.setForeground(Color.ORANGE);
	    btnA3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnA4.getBackground() != Color.GRAY)
	    	btnA4.setBackground(Color.BLUE);
	    btnA4.setForeground(Color.ORANGE);
	    btnA4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnA5.getBackground() != Color.GRAY)
	    	btnA5.setBackground(Color.BLUE);
	    btnA5.setForeground(Color.ORANGE);
	    btnA5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnB1.getBackground() != Color.GRAY)
	    	btnB1.setBackground(Color.BLUE);
	    btnB1.setForeground(Color.ORANGE);
	    btnB1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnB2.getBackground() != Color.GRAY)
	    	btnB2.setBackground(Color.BLUE);
	    btnB2.setForeground(Color.ORANGE);
	    btnB2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnB3.getBackground() != Color.GRAY)
	    	btnB3.setBackground(Color.BLUE);
	    btnB3.setForeground(Color.ORANGE);
	    btnB3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnB4.getBackground() != Color.GRAY)
	    	btnB4.setBackground(Color.BLUE);
	    btnB4.setForeground(Color.ORANGE);
	    btnB4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnB5.getBackground() != Color.GRAY)
	    	btnB5.setBackground(Color.BLUE);
	    btnB5.setForeground(Color.ORANGE);
	    btnB5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnC1.getBackground() != Color.GRAY)
	    	btnC1.setBackground(Color.BLUE);
	    btnC1.setForeground(Color.ORANGE);
	    btnC1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnC2.getBackground() != Color.GRAY)
	    	btnC2.setBackground(Color.BLUE);
	    btnC2.setForeground(Color.ORANGE);
	    btnC2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnC3.getBackground() != Color.GRAY)
	    	btnC3.setBackground(Color.BLUE);
	    btnC3.setForeground(Color.ORANGE);
	    btnC3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnC4.getBackground() != Color.GRAY)
	    	btnC4.setBackground(Color.BLUE);
	    btnC4.setForeground(Color.ORANGE);
	    btnC4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnC5.getBackground() != Color.GRAY)
	    	btnC5.setBackground(Color.BLUE);
	    btnC5.setForeground(Color.ORANGE);
	    btnC5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnD1.getBackground() != Color.GRAY)
	    	btnD1.setBackground(Color.BLUE);
	    btnD1.setForeground(Color.ORANGE);
	    btnD1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnD2.getBackground() != Color.GRAY)
	    	btnD2.setBackground(Color.BLUE);
	    btnD2.setForeground(Color.ORANGE);
	    btnD2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnD3.getBackground() != Color.GRAY)
	    	btnD3.setBackground(Color.BLUE);
	    btnD3.setForeground(Color.ORANGE);
	    btnD3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnD4.getBackground() != Color.GRAY)
	    	btnD4.setBackground(Color.BLUE);
	    btnD4.setForeground(Color.ORANGE);
	    btnD4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnD5.getBackground() != Color.GRAY)
	    	btnD5.setBackground(Color.BLUE);
	    btnD5.setForeground(Color.ORANGE);
	    btnD5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnE1.getBackground() != Color.GRAY)
	    	btnE1.setBackground(Color.BLUE);
	    btnE1.setForeground(Color.ORANGE);
	    btnE1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnE2.getBackground() != Color.GRAY)
	    	btnE2.setBackground(Color.BLUE);
	    btnE2.setForeground(Color.ORANGE);
	    btnE2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnE3.getBackground() != Color.GRAY)
	    	btnE3.setBackground(Color.BLUE);
	    btnE3.setForeground(Color.ORANGE);
	    btnE3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnE4.getBackground() != Color.GRAY)
	    	btnE4.setBackground(Color.BLUE);
	    btnE4.setForeground(Color.ORANGE);
	    btnE4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnE5.getBackground() != Color.GRAY)
	    	btnE5.setBackground(Color.BLUE);
	    btnE5.setForeground(Color.ORANGE);
	    btnE5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnF1.getBackground() != Color.GRAY)
	    	btnF1.setBackground(Color.BLUE);
	    btnF1.setForeground(Color.ORANGE);
	    btnF1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnF2.getBackground() != Color.GRAY)
	    	btnF2.setBackground(Color.BLUE);
	    btnF2.setForeground(Color.ORANGE);
	    btnF2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnF3.getBackground() != Color.GRAY)
	    	btnF3.setBackground(Color.BLUE);
	    btnF3.setForeground(Color.ORANGE);
	    btnF3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnF4.getBackground() != Color.GRAY)
	    	btnF4.setBackground(Color.BLUE);
	    btnF4.setForeground(Color.ORANGE);
	    btnF4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //See above comments
	    if(btnF5.getBackground() != Color.GRAY)
	    	btnF5.setBackground(Color.BLUE);
	    btnF5.setForeground(Color.ORANGE);
	    btnF5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //Sets default close operation
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //Sets visibility to true
	    setVisible(true);
	    
	    //Sets size of JPanel
	    setSize(2000, 1200);


	    //Adds an action listener to each button
	    btnA1.addActionListener(this);
	    btnA2.addActionListener(this);
	    btnA3.addActionListener(this);
	    btnA4.addActionListener(this);
	    btnA5.addActionListener(this);
	    btnB1.addActionListener(this);
	    btnB2.addActionListener(this);
	    btnB3.addActionListener(this);
	    btnB4.addActionListener(this);
	    btnB5.addActionListener(this);
	    btnC1.addActionListener(this);
	    btnC2.addActionListener(this);
	    btnC3.addActionListener(this);
	    btnC4.addActionListener(this);
	    btnC5.addActionListener(this);
	    btnD1.addActionListener(this);
	    btnD2.addActionListener(this);
	    btnD3.addActionListener(this);
	    btnD4.addActionListener(this);
	    btnD5.addActionListener(this);
	    btnE1.addActionListener(this);
	    btnE2.addActionListener(this);
	    btnE3.addActionListener(this);
	    btnE4.addActionListener(this);
	    btnE5.addActionListener(this);
	    btnF1.addActionListener(this);
	    btnF2.addActionListener(this);
	    btnF3.addActionListener(this);
	    btnF4.addActionListener(this);
	    btnF5.addActionListener(this);

	}
	
	//actionPerformed method
	public void actionPerformed(ActionEvent p)
	{
		//setUpGUI();
		
		//Calls reloadBoard method
		this.reloadBoard();
		
		//Sets question integer ready to 0, meaning not ready
		//Which means the close button has not been clicked yet
		q.notReady();
		
		//Calls receivePlayers method for q, meaning this class "sends" the players
		//array to the question class
		q.receivePlayers(players);

		//The following lines of code are very similar for each button.
	    //To avoid redundancy, only the first button will be completely commented
	    //and the others will just refer to the first button's comments
		
		//If a button is clicked...
		if(p.getSource() == btnA1){
			//...set that button's background color to gray
			btnA1.setBackground(Color.GRAY);
			
			//Set the index variables to the correct category and question numbers
			//m represents category, n represents question
			m = 0;
			n = 0;
			
			//Using m and n, set the question and answer strings to the appropriate question
			//and answers using the Strings stored in the arrays of this class
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			
			//Set the pnts integer of this class to the parsed integer of the number displayed
			//on the button that was clicked
			pnts = Integer.parseInt(btnA1.getText());
			
			//Calls the receivePoints method of the Question class
			//This essentially "sends" the point value to the Question class
			q.receivePoints(pnts);
			
			//Calls the screen method of the Question class to set up the screen for the question
			q.screen();
			
			//Calls scoreChange of this class to change the score displayed on the board
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnA2){
			btnA2.setBackground(Color.GRAY);
			m = 0;
			n = 1;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnA2.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnA3){
			btnA3.setBackground(Color.GRAY);
			m = 0;
			n = 2;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnA3.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnA4){
			btnA4.setBackground(Color.GRAY);
			m = 0;
			n = 3;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnA4.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnA5){
			btnA5.setBackground(Color.GRAY);
			m = 0;
			n = 4;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnA5.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnB1){
			btnB1.setBackground(Color.GRAY);
			m = 1;
			n = 0;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnB1.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnB2){
			btnB2.setBackground(Color.GRAY);
			m = 1;
			n = 1;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnB2.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnB3){
			btnB3.setBackground(Color.GRAY);
			m = 1;
			n = 2;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnB3.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnB4){
			btnB4.setBackground(Color.GRAY);
			m = 1;
			n = 3;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnB4.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnB5){
			btnB5.setBackground(Color.GRAY);
			m = 1;
			n = 4;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnB5.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnC1){
			btnC1.setBackground(Color.GRAY);
			m = 2;
			n = 0;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnC1.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnC2){
			btnC2.setBackground(Color.GRAY);
			m = 2;
			n = 1;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnC2.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnC3){
			btnC3.setBackground(Color.GRAY);
			m = 2;
			n = 2;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnC3.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnC4){
			btnC4.setBackground(Color.GRAY);
			m = 2;
			n = 3;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnC4.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnC5){
			btnC5.setBackground(Color.GRAY);
			m = 2;
			n = 4;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnC5.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnD1){
			btnD1.setBackground(Color.GRAY);
			m = 3;
			n = 0;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnD1.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnD2){
			btnD2.setBackground(Color.GRAY);
			m = 3;
			n = 1;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnD2.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnD3){
			btnD3.setBackground(Color.GRAY);
			m = 3;
			n = 2;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnD3.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnD4){
			btnD4.setBackground(Color.GRAY);
			m = 3;
			n = 3;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnD4.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnD5){
			btnD5.setBackground(Color.GRAY);
			m = 3;
			n = 4;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnD5.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnE1){
			btnE1.setBackground(Color.GRAY);
			m = 4;
			n = 0;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnE1.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnE2){
			btnE2.setBackground(Color.GRAY);
			m = 4;
			n = 1;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnE2.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnE3){
			btnE3.setBackground(Color.GRAY);
			m = 4;
			n = 2;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnE3.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnE4){
			btnE4.setBackground(Color.GRAY);
			m = 4;
			n = 3;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnE4.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnE5){
			btnE5.setBackground(Color.GRAY);
			m = 4;
			n = 4;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnE5.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnF1){
			btnF1.setBackground(Color.GRAY);
			m = 5;
			n = 0;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnF1.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnF2){
			btnF2.setBackground(Color.GRAY);
			m = 5;
			n = 1;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnF2.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnF3){
			btnF3.setBackground(Color.GRAY);
			m = 5;
			n = 2;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnF3.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnF4){
			btnF4.setBackground(Color.GRAY);
			m = 5;
			n = 3;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnF4.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}
		
		//See above comments
		else if(p.getSource() == btnF5){
			btnF5.setBackground(Color.GRAY);
			m = 5;
			n = 4;
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			pnts = Integer.parseInt(btnF5.getText());
			q.receivePoints(pnts);
			q.screen();
			scoreChange();
		}	
		
		//If the reload button is clicked...
		if(p.getSource() == reload)
		{
			//...call the reloadBoard method of this class
			reloadBoard();
		}
	}
}
