//Daniel Kobold
//PlayerSelect.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayerSelect extends JFrame implements ActionListener{
	
	//int[] rand = {0, 1, 2, 3, 4, 5};
	
	//Makes new JPanel pnlPlayr
	JPanel pnlPlayr = new JPanel();
	
	//Makes new Board named game
	Board game = new Board();
	
	//Makes error JLabel (for use if an error occurs)
	JLabel error = new JLabel("ERROR");
	
	//Makes numerous blank JTextAreas, for use in separating the blank JTextAreas
	//which are used when entering player names
	JTextArea blank = new JTextArea("");
	JTextArea blank1a = new JTextArea("");
	JTextArea blank1b = new JTextArea("");
	JTextArea blank2a = new JTextArea("");
	JTextArea blank2b = new JTextArea("");
	JTextArea blank3a = new JTextArea("");
	JTextArea blank3b = new JTextArea("");
	JTextArea blank4a = new JTextArea("");
	JTextArea blank4b = new JTextArea("");
	JTextArea blank5a = new JTextArea("");
	JTextArea blank5b = new JTextArea("");
	JTextArea blank6a = new JTextArea("");
	JTextArea blank6b = new JTextArea("");
	
	//Array of player objects
	Player[] players = new Player[6];
	
	//New player objects to hold each player that is received
	Player plyr1 = new Player();
	Player plyr2 = new Player();
	Player plyr3 = new Player();
	Player plyr4 = new Player();
	Player plyr5 = new Player();
	Player plyr6 = new Player();
	
	int n = 0;
	
	//Various JLabels that tell the user instructions
	JLabel title = new JLabel("Player/Team Selection:");
	JLabel intro = new JLabel("Type player/team names into boxes on right.");
	JLabel introL = new JLabel("Player Number");
	JLabel introR = new JLabel("Name Entry (Leave unnecessary players blank)");
	
	//Additional JLabels that label where player/team names need to be entered
	JLabel p1 = new JLabel("Player/Team 1 (Will select question first)");
	JLabel p2 = new JLabel("Player/Team 2");
	JLabel p3 = new JLabel("Player/Team 3");
	JLabel p4 = new JLabel("Player/Team 4");
	JLabel p5 = new JLabel("Player/Team 5");
	JLabel p6 = new JLabel("Player/Team 6");
	
	//Empty JTextAreas for entering player/team names
	JTextArea p1Entry = new JTextArea("");
	JTextArea p2Entry = new JTextArea("");
	JTextArea p3Entry = new JTextArea("");
	JTextArea p4Entry = new JTextArea("");
	JTextArea p5Entry = new JTextArea("");
	JTextArea p6Entry = new JTextArea("");
	
	
	/*JTextArea ques = new JTextArea();
	JButton btnA = new JButton();
	JButton btnB = new JButton();
	JButton btnC = new JButton();
	JButton btnD = new JButton();*/
	
	//Confirm button - used when name entry is complete
	JButton confirm = new JButton();
	
	//receiveBoard method which takes the board from another method (PlayGame)
	public void receiveBoard(Board gam)
	{
		game = gam;
	}
	
	//PlayerSelect constructor calls the select method
	public PlayerSelect()
	{
		select();
	}
	
	/*public PlayerSelect(String a, String b, String c, String d, String e, String f)
	{
		players[0].setName(a);
		players[1].setName(b);	
		players[2].setName(c);	
		players[3].setName(d);	
		players[4].setName(e);	
		players[5].setName(f);	
	}*/
	
	//select method sets up the pnlPlayr JPanel
	public void select()
	{
		//Sets pnlPlayr container to this content pane
		Container pnlPlayr = this.getContentPane();
	    
		//Sets pnlPlayr layout to a grid layout
	    pnlPlayr.setLayout(new GridLayout(15,2));
	    
	    //Sets visibility to true
	    setVisible(true);
	    
	    //Sets size of window
	    setSize(2000, 1200);
	    
	    //Sets background of pnlPlayr to blue
	    pnlPlayr.setBackground(Color.BLUE);
	    
	    //Sets the backgrounds of all the blank JTextAreas to Blue
	    blank.setBackground(Color.BLUE);
	    blank1a.setBackground(Color.BLUE);
	    blank1b.setBackground(Color.BLUE);
	    blank2a.setBackground(Color.BLUE);
	    blank2b.setBackground(Color.BLUE);
	    blank3a.setBackground(Color.BLUE);
	    blank3b.setBackground(Color.BLUE);
	    blank4a.setBackground(Color.BLUE);
	    blank4b.setBackground(Color.BLUE);
	    blank5a.setBackground(Color.BLUE);
	    blank5b.setBackground(Color.BLUE);
	    blank6a.setBackground(Color.BLUE);
	    blank6b.setBackground(Color.BLUE);
	    
	    //Add introductory labels to pnlPlayr
	    pnlPlayr.add(title);
	    pnlPlayr.add(intro);
	    pnlPlayr.add(introL);
	    pnlPlayr.add(introR);
	    
	    //Add player 1 JLabel and JTextArea
	    pnlPlayr.add(p1);
	    pnlPlayr.add(p1Entry);
	    
	    //Add blank JTextAreas for a blank line
	    pnlPlayr.add(blank1a);
	    pnlPlayr.add(blank1b);
	    
	    //Add player 2 JLabel and JTextArea
	    pnlPlayr.add(p2);
	    pnlPlayr.add(p2Entry);
	    
	    //Add blank JTextAreas for a blank line
	    pnlPlayr.add(blank2a);
	    pnlPlayr.add(blank2b);
	    
	    //Add player 3 JLabel and JTextArea
	    pnlPlayr.add(p3);
	    pnlPlayr.add(p3Entry);
	    
	    //Add blank JTextAreas for a blank line
	    pnlPlayr.add(blank3a);
	    pnlPlayr.add(blank3b);
	    
	    //Add player 4 JLabel and JTextArea
	    pnlPlayr.add(p4);
	    pnlPlayr.add(p4Entry);
	    
	    //Add blank JTextAreas for a blank line
	    pnlPlayr.add(blank4a);
	    pnlPlayr.add(blank4b);
	    
	    //Add player 5 JLabel and JTextArea
	    pnlPlayr.add(p5);
	    pnlPlayr.add(p5Entry);
	    
	    //Add blank JTextAreas for a blank line
	    pnlPlayr.add(blank5a);
	    pnlPlayr.add(blank5b);
	    
	    //Add player 6 JLabel and JTextArea
	    pnlPlayr.add(p6);
	    pnlPlayr.add(p6Entry);
	    
	    //Add blank JTextAreas for a blank line
	    pnlPlayr.add(blank6a);
	    pnlPlayr.add(blank6b);
	    
	    //Add one more blank and the confirm button
	    pnlPlayr.add(blank);
	    pnlPlayr.add(confirm);
	    
	    
	    //Set introductory fonts and text colors
	    title.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 56));
		title.setForeground(Color.ORANGE);
		intro.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		intro.setForeground(Color.ORANGE);
		introL.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		introL.setForeground(Color.ORANGE);
		introR.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		introR.setForeground(Color.ORANGE);
		
		//Sets the fonts of the player labels, the text color to orange, and
		//the font of the user entry boxes
	    p1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
	    p1Entry.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		p1.setForeground(Color.ORANGE);
		p2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		p2Entry.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		p2.setForeground(Color.ORANGE);
		p3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		p3Entry.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		p3.setForeground(Color.ORANGE);
		p4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		p4Entry.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		p4.setForeground(Color.ORANGE);
		p5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		p5Entry.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		p5.setForeground(Color.ORANGE);
		p6.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		p6Entry.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		p6.setForeground(Color.ORANGE);
	    
		//Add action listener to confirm button
	    confirm.addActionListener(this);
	    
	    //Sets font of the confirm button
	    confirm.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    
	    //Sets text of the confirm button
	    confirm.setText("Confirm");	    
	    
	    //Set default close operation to exit on close
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	}
	
	//getPlayerName method returns player's name iff player is not null
	//Takes parameter of player number in the player array
	public String getPlayerName(int w)
	{
		//String name is initially blank
		String name = "";
		
		//If the player object at the parameter position is not null...
		if(players[w] != null)
		{
			//...sets name String to player name at the parameter location
			name = players[w].getName();
		}
		//Return name string
		return name;
	}
	
	//getPlayerScore method returns player score
	public int getPlayerScore(int x)
	{
		//int score is initially 0
		int score = 0;
		
		//Sets score to the player's score at the parameter location
		score = players[x].getScore();
		
		//Return score
		return score;
	}
	
	/*public String getNextPlayer()
	{
		Player nxtPlyr = null;
		n++;
		while(players[n] == null)
		{
			n++;
			if(n>5)
				n=0;
		}
		nxtPlyr = players[n];
		return nxtPlyr.getName();
	}*/
	
	//Action performed method
	public void actionPerformed(ActionEvent p)
	{
		//If the player clicks the confirm button...
		if(p.getSource() == confirm){
			//...and if p1Entry remains empty...
			if(p1Entry.getText().equals("")){
				//...set player at that array location to null
				players[0] = null;
			}
			//Otherwise the JTextArea is not empty
			else
			{
				//Sets players[0] to the plyr1 object
				players[0] = plyr1;
				
				//Sets the name of that player to the text in the JTextArea
				players[0].setName(p1Entry.getText());
			}
			
			//The following commands are the same as the above commands, just
			//for players 2, 3, 4, 5, and 6
			
			if(p2Entry.getText().equals("")){
				players[1] = null;
			}
			else
			{
				players[1] = plyr2;
				players[1].setName(p2Entry.getText());
			}
			if(p3Entry.getText().equals("")){
				players[2] = null;
			}
			else
			{
				players[2] = plyr3;
				players[2].setName(p3Entry.getText());
			}
			if(p4Entry.getText().equals("")){
				players[3] = null;
			}
			else
			{
				players[3] = plyr4;
				players[3].setName(p4Entry.getText());
			}
			if(p5Entry.getText().equals("")){
				players[4] = null;
			}
			else
			{
				players[4] = plyr5;
				players[4].setName(p5Entry.getText());
			}
			if(p6Entry.getText().equals("")){
				players[5] = null;
			}
			else
			{
				players[5] = plyr6;
				players[5].setName(p6Entry.getText());
			}

			//Calls closeWindow method
			closeWindow();
			
			//Calls the receivePlayers method of Board and "sends" the players array
			//to the Board named game
			game.receivePlayers(players);
			
			//Calls Board's loadBoard method
			game.loadBoard();						
		}
	}
	
	//closeWindow method simply sets visibility to false
	public void closeWindow()
	{
		setVisible(false);
	}
}
