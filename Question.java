//Daniel Kobold
//Question.java

//Import Statements
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Question extends JFrame implements ActionListener{

	//Note regarding "Question" v.s. "question"
	//"Question" refers to the class object, and each question has one "question" String
	//and four "answer" Strings among other things
	//"question" refers to the actual String that holds the question
	
	//String that holds the question of the Question object	
	String question;
	
	//Array of String answers
	String[] answer = new String[4];
	
	//Integer array that stores changes to player scores
	int[] scoreChange = new int[6];
	
	//Current keeps track of the player that got the answer correct
	int current = 6;
	
	//Points keeps track of how many points the current Question is worth
	int points = 0;
	
	//Array of Players keeps track of player names and scores for display on each Question screen
	Player[] players = new Player[6];
	
	//This array of integers is used in randomly ordering the answer choices
	int[] rand = {0, 1, 2 ,3};
	
	//This integer is used to confirm (in the Board.java class) that the close button
	//has been clicked for the JPanel of the Question.java class
	int ready = 0;
	
	//Error JLabel (this should not appear as long as the user doesn't enter something incorrectly
	//when making the game file)
	JLabel error = new JLabel("ERROR");
	
	//Blank JTextArea
	JTextArea blank = new JTextArea();
	
	//JTextArea that holds the question
	JTextArea ques = new JTextArea();
	
	//JButton for each of the answer choices
	JButton btnA = new JButton();
	JButton btnB = new JButton();
	JButton btnC = new JButton();
	JButton btnD = new JButton();
	
	//JButtons for selecting which player is answering, or who "buzzed in"
	JButton bp1 = new JButton();
	JButton bp2 = new JButton();
	JButton bp3 = new JButton();
	JButton bp4 = new JButton();
	JButton bp5 = new JButton();
	JButton bp6 = new JButton();
	JButton c = null;
	
	//JPanel for this class
	JPanel ask = new JPanel();
	
	//next keeps track of which player will choose the next question, based on which player
	//got this Question right
	int next = 0;
	
	
	JPanel subPanel = new JPanel();
	
	JPanel subPanel2 = new JPanel();
	
	//Sub-sub-panel for each player display
	//(Each of these will show the clickable player name and their score below the button)
	JPanel subSubPanel1 = new JPanel();
	JPanel subSubPanel2 = new JPanel();
	JPanel subSubPanel3 = new JPanel();
	JPanel subSubPanel4 = new JPanel();
	JPanel subSubPanel5 = new JPanel();
	JPanel subSubPanel6 = new JPanel();
	
	//JLabel for each of the players' scores
	JLabel score1 = new JLabel();
	JLabel score2 = new JLabel();
	JLabel score3 = new JLabel();
	JLabel score4 = new JLabel();
	JLabel score5 = new JLabel();
	JLabel score6 = new JLabel();
	
	//JLabel that appears upon a correct answer being selected
	JLabel correct = new JLabel("CORRECT!");
	
	//JLabel that appears upon an incorrect answer being selected
	JLabel incorrect = new JLabel("Incorrect...");
	
	//JLabel that appears when an answer is selected without a player being selected first
	JLabel whichPlayer = new JLabel("Which Player?");
	
	//Another blank JLabel for formatting
	JLabel blnk = new JLabel("");
	
	//Close JButton
	JButton close = new JButton("Close");
	
	//Receive Points method gets the point value of this Question from the Board.java class
	public void receivePoints(int pts)
	{
		points = pts;
	}
	
	//Receive Players method receives the array of players from the Board.java class
	public void receivePlayers(Player[] play)
	{
		players = play;
	}
	
	//Question constructor (does nothing)
	public Question()
	{
		
	}
	
	//getNext method returns the value of next integer, which corresponds to the player
	//that will select the next question, which corresponds to the player that got this
	//question correct
	public int getNext()
	{
		return next;
	}
	
	//getScore method returns a string with the n^th player's score
	public String getScore(int n)
	{
		return ""+players[n].getScore();
	}
	
	//scoreChanges method is similar to scoreChange method in Board class, this one,
	//however, is able to happen once the close button has been clicked
	public void scoreChanges()
	{
		//If the player exists...
		if(players[0] != null)
		{
			//...call player method incScore, which increments their score by the
			//corresponding element in scoreChange
			//(this works because deducting points takes the form of adding a negative number)
			players[0].incScore(scoreChange[0]);
			
			//Set this scoreChange element to 0 so the change is not applied more than once
			scoreChange[0] = 0;
		}
		
		//See above code
		if(players[1] != null)
		{
			players[1].incScore(scoreChange[1]);
			scoreChange[1] = 0;
		}
		
		//See above code
		if(players[2] != null)
		{
			players[2].incScore(scoreChange[2]);
			scoreChange[2] = 0;
		}
		
		//See above code
		if(players[3] != null)
		{
			players[3].incScore(scoreChange[3]);
			scoreChange[3] = 0;
		}
		
		//See above code
		if(players[4] != null)
		{
			players[4].incScore(scoreChange[4]);
			scoreChange[4] = 0;
		}
		
		//See above code
		if(players[5] != null)
		{
			players[5].incScore(scoreChange[5]);
			scoreChange[5] = 0;
		}
		
		//Used for reference
		/*for(int a = 0; a < 6; a++)
		{
			System.out.println("P Score Change:");
			System.out.println(scoreChange[a]);
			System.out.println("New score:");
			if(players[a] != null)
				System.out.println(players[a].getScore());
		}*/
	}
	
	//Overloaded Question constructor sets question and answer strings for this Question
	public Question(String q, String a, String b, String c, String d)
	{
		//Sets the question String to the q parameter
		question = q;
		
		//Sets the elements of the answer array to a, b, c, and d parameters
		answer[0] = a;
		answer[1] = b;
		answer[2] = c;
		answer[3] = d;
		
		//Sets the text in the JTextArea ques to the question
		ques.setText(q);
		
		//Sets the text in the JButtons for answer choices to their corresponding answer choices
		btnA.setText(a);
		btnB.setText(b);
		btnC.setText(c);
		btnD.setText(d);
		
		//Sets the random array elements to {0,1,2,3}
		rand[0] = 0;
		rand[1] = 1;
		rand[2] = 2;
		rand[3] = 3;
		
		
	}
	
	//setQuest (set question) method does exactly what the overloaded constructor does
	public void setQuest(String q, String a, String b, String c, String d)
	{
		//Sets the question String to the q parameter
		question = q;
		
		//Sets the elements of the answer array to a, b, c, and d parameters
		answer[0] = a;
		answer[1] = b;
		answer[2] = c;
		answer[3] = d;
		
		//Sets the text in the JTextArea ques to the question
		ques.setText(q);
		
		//Sets the text in the JButtons for answer choices to their corresponding answer choices
		btnA.setText(a);
		btnB.setText(b);
		btnC.setText(c);
		btnD.setText(d);
		
		//Sets the random array elements to {0,1,2,3}
		rand[0] = 0;
		rand[1] = 1;
		rand[2] = 2;
		rand[3] = 3;
	}
	
	//Sets current to 6 and returns the scoreChange array
	public int[] getScoreChange()
	{
		current = 6;
		
		return scoreChange;
	}
	
	//Screen method takes care of setting up GUI
	public void screen()
	{
		//Remove everything from the sub-panel
		subPanel.removeAll();
		
		//Remove everything from ask JPanel
		ask.removeAll();
		
		//Set background of JPanel to blue
		ask.setBackground(Color.BLUE);
		
		//If player exists...
		if(players[0] != null)
		{
			//...set the player name to the corresponding player name
			bp1.setText(players[0].getName());
			
			//Set background of player name JButton to blue
			bp1.setBackground(Color.BLUE);
			
			//Set foreground (text) color to orange
			bp1.setForeground(Color.ORANGE);
			
			//Set font of player name JButton
			bp1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			
			//Add action listener to the player name JButton
			bp1.addActionListener(this);
			
			//Set the score JLabel to the corresponding player score
			score1.setText("" + players[0].getScore());
			
			//Set foreground (text) color to orange
			score1.setForeground(Color.ORANGE);
			
			//Set horizontal alignment of score to center
			score1.setHorizontalAlignment(JLabel.CENTER);
			
			//Set font of player score JLabel
			score1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			
			//Sets layout of sub-sub-panel to a new GridLayout
			subSubPanel1.setLayout(new GridLayout(2,1));
			
			//Sets background color of sub-sub-panel to black
			subSubPanel1.setBackground(Color.BLACK);
			
			//Adds player name button to sub-sub-panel
			subSubPanel1.add(bp1);
			
			//Adds player score JLabel to sub-sub-panel
			subSubPanel1.add(score1);
			
			//Adds sub-sub-panel to sub-panel
			subPanel.add(subSubPanel1);
			
			//Sets current to 0
			current = 0;
		}
		
		//See above comments
		if(players[1] != null)
		{
			bp2.setText(players[1].getName());
			bp2.setBackground(Color.BLUE);
			bp2.setForeground(Color.ORANGE);
			bp2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			bp2.addActionListener(this);
			
			score2.setText("" + players[1].getScore());
			score2.setForeground(Color.ORANGE);
			score2.setHorizontalAlignment(JLabel.CENTER);
			score2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			subSubPanel2.setLayout(new GridLayout(2,1));
			subSubPanel2.setBackground(Color.BLACK);
			subSubPanel2.add(bp2);
			subSubPanel2.add(score2);
			subPanel.add(subSubPanel2);
			
			current = 1;
		}
		
		//See above comments
		if(players[2] != null)
		{
			bp3.setText(players[2].getName());
			bp3.setBackground(Color.BLUE);
			bp3.setForeground(Color.ORANGE);
			bp3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			bp3.addActionListener(this);
			
			score3.setText("" + players[2].getScore());
			score3.setForeground(Color.ORANGE);
			score3.setHorizontalAlignment(JLabel.CENTER);
			score3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			subSubPanel3.setLayout(new GridLayout(2,1));
			subSubPanel3.setBackground(Color.BLACK);
			subSubPanel3.add(bp3);
			subSubPanel3.add(score3);
			subPanel.add(subSubPanel3);
			
			
			current = 2;
		}
		
		//See above comments
		if(players[3] != null)
		{
			bp4.setText(players[3].getName());
			bp4.setBackground(Color.BLUE);
			bp4.setForeground(Color.ORANGE);
			bp4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			bp4.addActionListener(this);
			
			score4.setText("" + players[3].getScore());
			score4.setForeground(Color.ORANGE);
			score4.setHorizontalAlignment(JLabel.CENTER);
			score4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			subSubPanel4.setLayout(new GridLayout(2,1));
			subSubPanel4.setBackground(Color.BLACK);
			subSubPanel4.add(bp4);
			subSubPanel4.add(score4);
			subPanel.add(subSubPanel4);
			
			current = 3;
		}
		
		//See above comments
		if(players[4] != null)
		{
			bp5.setText(players[4].getName());
			bp5.setBackground(Color.BLUE);
			bp5.setForeground(Color.ORANGE);
			bp5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			bp5.addActionListener(this);
			
			score5.setText("" + players[4].getScore());
			score5.setForeground(Color.ORANGE);
			score5.setHorizontalAlignment(JLabel.CENTER);
			score5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			subSubPanel5.setLayout(new GridLayout(2,1));
			subSubPanel5.setBackground(Color.BLACK);
			subSubPanel5.add(bp5);
			subSubPanel5.add(score5);
			subPanel.add(subSubPanel5);
			
			current = 4;
		}
		
		//See above comments
		if(players[5] != null)
		{
			bp6.setText(players[5].getName());
			bp6.setBackground(Color.BLUE);
			bp6.setForeground(Color.ORANGE);
			bp6.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			bp6.addActionListener(this);
			
			score6.setText("" + players[5].getScore());
			score6.setForeground(Color.ORANGE);
			score6.setHorizontalAlignment(JLabel.CENTER);
			score6.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
			subSubPanel6.setLayout(new GridLayout(2,1));
			subSubPanel6.setBackground(Color.BLACK);
			subSubPanel6.add(bp6);
			subSubPanel6.add(score6);
			subPanel.add(subSubPanel6);
			
			current = 5;
		}
		
		//Set layout of sub-panel to grid layout
		subPanel.setLayout(new GridLayout(1,6));
		
		//Sets ask Container to this content pane
		Container ask = this.getContentPane();
	    
		//Sets layout of ask JPanel to grid layout
	    ask.setLayout(new GridLayout(7,1));
	    
	    //Sets visibility to true
	    setVisible(true);
	    
	    //Sets size
	    setSize(2000, 1200);
	    
	    //Sets JPanel background to blue
	    ask.setBackground(Color.BLUE);
	    
	    //Sets background of blank JPanel to blue
	    blank.setBackground(Color.BLUE);
	    
	    //Sets background of question JTextArea to blue
	    ques.setBackground(Color.BLUE);
	    
	    //Sets foreground (text) color to orange
	    ques.setForeground(Color.ORANGE);
	    
	    //Sets font of question JTextArea
	    ques.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    
	    //Sets background and foreground (text) colors as well as font of answer
	    //choice JButtons
	    btnA.setBackground(Color.BLUE);
	    btnA.setForeground(Color.ORANGE);
	    btnA.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    btnB.setBackground(Color.BLUE);
	    btnB.setForeground(Color.ORANGE);
	    btnB.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    btnC.setBackground(Color.BLUE);
	    btnC.setForeground(Color.ORANGE);
	    btnC.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    btnD.setBackground(Color.BLUE);
	    btnD.setForeground(Color.ORANGE);
	    btnD.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    
	    //Adds action listeners to answer choice JButtons and close button
	    btnA.addActionListener(this);
	    btnB.addActionListener(this);
	    btnC.addActionListener(this);
	    btnD.addActionListener(this);
	    close.addActionListener(this);
	    
	    //Calls shuffle method to shuffle the random integer array, which is used
	    //in randomly ordering the answer choices
	    shuffle();
	    
	    //Add the sub-panel to ask JPanel
	    ask.add(subPanel);
	    
	    //Add question JTextArea to ask JPanel
	    ask.add(ques);
	    
	    //Uses the random array of integers to randomly add the answer choice JButtons
	    for(int b = 0; b<4; b++)
	    {
	    	int c = rand[b];
	    	if(c == 0)
	    		ask.add(btnA);
	    	else if(c==1)
	    		ask.add(btnB);
	    	else if(c==2)
	    		ask.add(btnC);
	    	else if(c==3)
	    		ask.add(btnD);
	    	else
	    		ask.add(error);
	    }
	    
	    //Calls screen2 method (which is really just another sub-panel at the bottom
	    //of the ask JPanel) with the blank JLabel to show a blank area and the close
	    //button at the bottom of the question screen
	    screen2(blnk);
	    
	}
	
	//screen2 method sets up the JPanel with the final sub-panel at the bottom of the
	//question screen and takes parameter of a JLabel
	public void screen2(JLabel lbl)
	{
		//Sets the background of ask JPanel to blue
		ask.setBackground(Color.BLUE);
		
		//Sets layout of sub-panel to grid layout
		subPanel.setLayout(new GridLayout(1,6));
		
		//Sets container ask to this content pane
		Container ask = this.getContentPane();
	    
		//Sets layout of ask JPanel to grid layout
	    ask.setLayout(new GridLayout(7,1));
	    
	    //Sets visibility to true
	    setVisible(true);
	    
	    //Sets size
	    setSize(2000, 1200);
	    
	    //Sets background of ask to blue
	    ask.setBackground(Color.BLUE);

	    //Adds first sub-panel to ask JPanel
	    ask.add(subPanel);
	    
	    //Adds question JTextArea to ask JPanel
	    ask.add(ques);
	    
	    //Uses the random array of integers to randomly add the answer choice JButtons
	    for(int b = 0; b<4; b++)
	    {
	    	int c = rand[b];
	    	if(c == 0)
	    		ask.add(btnA);
	    	else if(c==1)
	    		ask.add(btnB);
	    	else if(c==2)
	    		ask.add(btnC);
	    	else if(c==3)
	    		ask.add(btnD);
	    	else
	    		ask.add(error);
	    }
	    
	    //Sets layout of sub-panel 2 to grid layout
		subPanel2.setLayout(new GridLayout(1,2));
		
		//Adds action listener to close button
		close.addActionListener(this);
		
		//Sets background of close button to gray
		close.setBackground(Color.GRAY);
		
		//Sets foreground (text) color of close button to orange
		close.setForeground(Color.ORANGE);
		
		//Sets font of the close button
		close.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
				
		//Sets background of the (parameter) label
		lbl.setBackground(Color.BLUE);
		
		//Sets foreground (text) color of the (parameter) label
		lbl.setForeground(Color.ORANGE);
		
		//Sets the font of the (parameter) label
		lbl.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
		
		//Removes everything from sub-panel 2
		subPanel2.removeAll();
		
		//Adds the (parameter) label to sub-panel 2
		subPanel2.add(lbl);
		
		//Adds the close button to sub-panel 2
		subPanel2.add(close);
		
		//Adds sub-panel 2 to the ask JPanel
		ask.add(subPanel2);
		
		//Sets visibility to true
		ask.setVisible(true);
	    
	    
	}
	
	//This shuffle method uses a Fisher-Yates shuffle
	//My source for this method is www.dotnetperls.com/shuffle-java
	public void shuffle()
	{
		int n = rand.length;
		for(int a = 0; a<rand.length; a++)
		{
			int random = a + (int)(Math.random()*(n-a));
			
			int randomElement = rand[random];
			rand[random] = rand[a];
			rand[a] = randomElement;
		}
	}
	
	//actionPerformed method
	public void actionPerformed(ActionEvent h)
	{
		//If the player button is clicked...
		if(h.getSource() == bp1){
			
			//...set current to the player number
			current = 0;
			
			//Set current JButton to the JButton clicked
			c = bp1;
			
			//Set background color of this JButton to cyan...
			//...but of all the other JButtons to blue
			bp1.setBackground(Color.CYAN);
			if(bp2.getBackground() == Color.CYAN)
				bp2.setBackground(Color.BLUE);
			if(bp3.getBackground() == Color.CYAN)
				bp3.setBackground(Color.BLUE);
			if(bp4.getBackground() == Color.CYAN)
				bp4.setBackground(Color.BLUE);
			if(bp5.getBackground() == Color.CYAN)
				bp5.setBackground(Color.BLUE);
			if(bp6.getBackground() == Color.CYAN)
				bp6.setBackground(Color.BLUE);
		}
		
		//See above comments
		else if(h.getSource() == bp2){
			current = 1;
			c = bp2;
			bp2.setBackground(Color.CYAN);
			if(bp1.getBackground() == Color.CYAN)
				bp1.setBackground(Color.BLUE);
			if(bp3.getBackground() == Color.CYAN)
				bp3.setBackground(Color.BLUE);
			if(bp4.getBackground() == Color.CYAN)
				bp4.setBackground(Color.BLUE);
			if(bp5.getBackground() == Color.CYAN)
				bp5.setBackground(Color.BLUE);
			if(bp6.getBackground() == Color.CYAN)
				bp6.setBackground(Color.BLUE);
		}
		
		//See above comments
		else if(h.getSource() == bp3){
			current = 2;
			c = bp3;
			bp3.setBackground(Color.CYAN);
			if(bp2.getBackground() == Color.CYAN)
				bp2.setBackground(Color.BLUE);
			if(bp1.getBackground() == Color.CYAN)
				bp1.setBackground(Color.BLUE);
			if(bp4.getBackground() == Color.CYAN)
				bp4.setBackground(Color.BLUE);
			if(bp5.getBackground() == Color.CYAN)
				bp5.setBackground(Color.BLUE);
			if(bp6.getBackground() == Color.CYAN)
				bp6.setBackground(Color.BLUE);
		}
		
		//See above comments
		else if(h.getSource() == bp4){
			current = 3;
			c = bp4;
			bp4.setBackground(Color.CYAN);
			if(bp2.getBackground() == Color.CYAN)
				bp2.setBackground(Color.BLUE);
			if(bp3.getBackground() == Color.CYAN)
				bp3.setBackground(Color.BLUE);
			if(bp1.getBackground() == Color.CYAN)
				bp1.setBackground(Color.BLUE);
			if(bp5.getBackground() == Color.CYAN)
				bp5.setBackground(Color.BLUE);
			if(bp6.getBackground() == Color.CYAN)
				bp6.setBackground(Color.BLUE);
		}
		
		//See above comments
		else if(h.getSource() == bp5){
			current = 4;
			c = bp5;
			bp5.setBackground(Color.CYAN);
			if(bp2.getBackground() == Color.CYAN)
				bp2.setBackground(Color.BLUE);
			if(bp3.getBackground() == Color.CYAN)
				bp3.setBackground(Color.BLUE);
			if(bp4.getBackground() == Color.CYAN)
				bp4.setBackground(Color.BLUE);
			if(bp1.getBackground() == Color.CYAN)
				bp1.setBackground(Color.BLUE);
			if(bp6.getBackground() == Color.CYAN)
				bp6.setBackground(Color.BLUE);
		}
		
		//See above comments
		else if(h.getSource() == bp6){
			current = 5;
			c = bp6;
			bp6.setBackground(Color.CYAN);
			if(bp2.getBackground() == Color.CYAN)
				bp2.setBackground(Color.BLUE);
			if(bp3.getBackground() == Color.CYAN)
				bp3.setBackground(Color.BLUE);
			if(bp4.getBackground() == Color.CYAN)
				bp4.setBackground(Color.BLUE);
			if(bp5.getBackground() == Color.CYAN)
				bp5.setBackground(Color.BLUE);
			if(bp1.getBackground() == Color.CYAN)
				bp1.setBackground(Color.BLUE);
		}
		
		//If the correct answer button is clicked...
		if(h.getSource() == btnA){
			
			//...and if current button is not null and current is not 6...
			//(meaning a player has been selected to answer the question)
			if(c != null && current!=6)
			{
				//...then next now equals current because the current player
				//got the answer right
				next = current;
				
				//Set score change to the (positive) point value of this question
				scoreChange[current] = points;
				
				//Call screen2 method with the correct JLabel added
				screen2(correct);
				
				//Set background of this JButton to green
				btnA.setBackground(Color.GREEN);
				
				//Set background of the selected player to green
				c.setBackground(Color.GREEN);
			}
			//Otherwise, call screen2 with the whichPlayer JLabel
			//This means a player was not selected to answer the question
			else
				screen2(whichPlayer);
		}
		
		//Otherwise, an incorrect answer was selected...
		else if(h.getSource() == btnB){
			
			//...and if current button is not null and current is not 6...
			//(meaning a player has been selected to answer the question)
			if(c != null && current!=6)
			{
				//Set score change to the (negative) point value of this question
				scoreChange[current] = -1*points;
				
				//Call screen2 method with incorrect JLabel added
				screen2(incorrect);
				
				//Set background of this JButton to red
				btnB.setBackground(Color.RED);
				
				//Set background of the selected player to red
				c.setBackground(Color.RED);
			}
			//Otherwise, call screen2 with the whichPlayer JLabel
			//This means a player was not selected to answer the question
			else
				screen2(whichPlayer);
		}
		
		//See above comments
		else if(h.getSource() == btnC){
			if(c != null && current!=6)
			{
				scoreChange[current] = -1*points;
				screen2(incorrect);
				btnC.setBackground(Color.RED);
				c.setBackground(Color.RED);
			}
			else
				screen2(whichPlayer);
		}
		
		//See above comments
		else if(h.getSource() == btnD){
			if(c != null && current!=6)
			{
				scoreChange[current] = -1*points;
				screen2(incorrect);
				btnD.setBackground(Color.RED);
				c.setBackground(Color.RED);
			}
			else
				screen2(whichPlayer);
		}
		
		//If the close button is clicked
		if(h.getSource() == close)
		{
			//Call scoreChanges method
			scoreChanges();
			
			//Set ready to 1, meaning close was clicked
			ready = 1;
			
			//Set visibility to false
			this.setVisible(false);
		}
		
	}
	
	//notReady method sets ready to 0 and next to 6
	public void notReady()
	{
		ready = 0;
		next = 6;
	}
	
	//readyCheck method returns integer ready
	public int readyCheck()
	{
		return ready;
	}
}
