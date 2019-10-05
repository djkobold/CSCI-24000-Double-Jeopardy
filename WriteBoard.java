//Daniel Kobold
//WriteBoard.java

//Import libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;



public class WriteBoard extends JFrame implements ActionListener{

	//Sets up the arrays that will hold each questions point value, question, answer
	//choices, and the game's categories
	String[][] data = new String[6][5];
	String[][] quest = new String[6][5];
	String[][][] ans = new String[6][5][4];
	String[] category = new String[6];
	
	//New WriteQuestion object
	WriteQuestion q = new WriteQuestion();
	
	//File
	File myFile;
	
	//Blank string for holding the point value as a string
	String ptS = "";
	
	//Point value integer, initially 0
	int pnts = 0;
	
	int w = 0;
	int x = 0;
	int y = 0;
	int z = 0;
	
	//Boolean about whether this is the first time the WriteBoard is shown
	boolean first = true;
	
	
	boolean done = false;
	
	int m = 0;
	int n = 0;
	
	//Player object array (not needed)
	//Player[] players = new Player[6];
	
	//JTextAreas for the board's categories
	JTextArea catA = new JTextArea();
	JTextArea catB = new JTextArea();
	JTextArea catC = new JTextArea();
	JTextArea catD = new JTextArea();
	JTextArea catE = new JTextArea();
	JTextArea catF = new JTextArea();
	
	//JButtons for each question on the board
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
	
	//Close button for after the game has been submitted
	JButton close = new JButton("Close Game Maker");
	
	//JLabels that are really just blanks when a player is null
	JLabel b0 = new JLabel("");
	JLabel b1 = new JLabel("");
	JLabel b2 = new JLabel("");
	JLabel b3 = new JLabel("");
	JLabel b4 = new JLabel("");
	JLabel b5 = new JLabel("");
	
	//Two JLabels that show warning message
	//For some reason, the top left question sometimes becomes blank randomly
	JLabel warning = new JLabel("To avoid bugs, please fill in the top left");
	JLabel warning2 = new JLabel("question last.");
	
	//Refresh scores button
	JButton reload = new JButton("Refresh Scores");
	
	/*JLabel p1 = new JLabel();
	JLabel p2 = new JLabel();
	JLabel p3 = new JLabel();
	JLabel p4 = new JLabel();
	JLabel p5 = new JLabel();
	JLabel p6 = new JLabel();*/
	
	//Finish button for when the game is done being written
	JButton finish = new JButton("Save/Finish Game");
	

	//WriteBoard constructor (doesn't do anything, everything in this class is called manually)
	public WriteBoard()
	{
		//loadBoard();
		//setUpGUI();
	}
	
	//Get category method returns the z^th category
	public String getCat(int z)
	{
		return category[z];
	}
	
	//Set category method sets the z^th category to string set
	public void setCat(int z, String set)
	{
		category[z] = set;
	}
	
	//Get data method returns the point value of the x^th category, y^th question
	public String getData(int x, int y)
	{
		return data[x][y];
	}
	
	//Set data method sets the point value of the the x^th category, y^th question to string set
	public void setData(int x, int y, String set)
	{
		data[x][y] = set;
	}
	
	//Set question method sets the x^th category, y^th question to string que
	public void setQuest(int x, int y, String que)
	{
		quest[x][y] = que;
	}
	
	//Get question method returns the x^th category, y^th question's question string
	public String getQuest(int x, int y)
	{
		return quest[x][y];
	}
	
	//Set answer method sets the c^th answer of the a^th category, b^th question to string anw
	public void setAns(int a, int b, int c, String anw)
	{
		ans[a][b][c] = anw;
	}
	
	//Get answer method gets the z^th answer of the x^th category, y^th question
	public String getAns(int x, int y, int z)
	{
		return ans[x][y][z];
	}
	
	//Receive file method takes input of file and sets myFile to this file
	public void receiveFile(File file)
	{
		myFile = file;
	}
	
	//loadBoard method sets the JLabel and JButton text to the needed strings that were stored
	//in the game file
	public void loadBoard()
	{
		//If first is true (this is the first call of the loadBoard method)
		if(first)
		{
			//Sets the JLabel categories' text
			catA.setText(getCat(0));
			catB.setText(getCat(1));
			catC.setText(getCat(2));
			catD.setText(getCat(3));
			catE.setText(getCat(4));
			catF.setText(getCat(5));
		}
		//Sets the JButton question buttons' text
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
	}
	
	//setUpGUI method sets up the GUI for this JPanel
	public void setUpGUI()
	{
		//Sets pnlBoard Container to this content pane
	    Container pnlBoard = this.getContentPane();
	    
	    //Sets pnlBoard layout to grid layout
	    pnlBoard.setLayout(new GridLayout(7,6));
	    
	    //Adds the category JLabels
	    pnlBoard.add(catA);
	    pnlBoard.add(catB);
	    pnlBoard.add(catC);
	    pnlBoard.add(catD);
	    pnlBoard.add(catE);
	    pnlBoard.add(catF);
	    //pnlBoard.add(b0);
	    
	    //Adds the first value set of questions JButtons (default: 200 pts.)
	    pnlBoard.add(btnA1);
	    pnlBoard.add(btnB1);
	    pnlBoard.add(btnC1);
	    pnlBoard.add(btnD1);
	    pnlBoard.add(btnE1);
	    pnlBoard.add(btnF1);
	    //pnlBoard.add(b1);
	    
	    //Adds the second value set of question JButtons (default: 400 pts.)
	    pnlBoard.add(btnA2);
	    pnlBoard.add(btnB2);
	    pnlBoard.add(btnC2);
	    pnlBoard.add(btnD2);
	    pnlBoard.add(btnE2);
	    pnlBoard.add(btnF2);
	    //pnlBoard.add(b2);
	    
	    //Adds the third value set of question JButtons (default: 600 pts.)
	    pnlBoard.add(btnA3);
	    pnlBoard.add(btnB3);
	    pnlBoard.add(btnC3);
	    pnlBoard.add(btnD3);
	    pnlBoard.add(btnE3);
	    pnlBoard.add(btnF3);
	    //pnlBoard.add(b3);
	    
	    //Adds the fourth value set of question JButtons (default: 800 pts.)
	    pnlBoard.add(btnA4);
	    pnlBoard.add(btnB4);
	    pnlBoard.add(btnC4);
	    pnlBoard.add(btnD4);
	    pnlBoard.add(btnE4);
	    pnlBoard.add(btnF4);
	    //pnlBoard.add(b4);
	    
	    //Adds the final value set of question JButtons (default: 1000 pts.)
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
	    
	    //Sets font of the finish and reload buttons
	    finish.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
	    reload.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
	    
	    //Adds the finish and reload buttons to the pnlBoard
	    pnlBoard.add(finish);
	    pnlBoard.add(reload);
	    
	    //Sets warning font color to orange
	    warning.setForeground(Color.ORANGE);
	    
	    //Sets warning font
	    warning.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
	    
	    //Sets second part of the warning font color to orange
	    warning2.setForeground(Color.ORANGE);
	    
	    //Sets second part of the warning font
	    warning2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
	    
	    //Adds both parts of the warning to the pnlBoard
	    pnlBoard.add(warning);
	    pnlBoard.add(warning2);
	    
	    //Adds action listener to the close button
	    close.addActionListener(this);
	    
	    //If the writing is done (the finish button has been clicked)
	    if(done)
	    {
	    	//Sets font of the close button
	    	close.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
	    	
	    	//Adds close button to pnlBoard
	    	pnlBoard.add(close);
	    }
	    	
	    //Sets background color of pnlBoard to blue
	    pnlBoard.setBackground(Color.BLUE);
	    
	    //Sets category text color to orange and sets the fonts of the category labels
	    catA.setForeground(Color.ORANGE);
	    catA.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    catB.setForeground(Color.ORANGE);
	    catB.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    catC.setForeground(Color.ORANGE);
	    catC.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    catD.setForeground(Color.ORANGE);
	    catD.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    catE.setForeground(Color.ORANGE);
	    catE.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    catF.setForeground(Color.ORANGE);
	    catF.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
    	if(btnA1.getBackground() != Color.GRAY)
    		btnA1.setBackground(Color.BLUE);
	    btnA1.setForeground(Color.ORANGE);
	    btnA1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnA2.getBackground() != Color.GRAY)
	    	btnA2.setBackground(Color.BLUE);
	    btnA2.setForeground(Color.ORANGE);
	    btnA2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnA3.getBackground() != Color.GRAY)
	    	btnA3.setBackground(Color.BLUE);
	    btnA3.setForeground(Color.ORANGE);
	    btnA3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnA4.getBackground() != Color.GRAY)
	    	btnA4.setBackground(Color.BLUE);
	    btnA4.setForeground(Color.ORANGE);
	    btnA4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnA5.getBackground() != Color.GRAY)
	    	btnA5.setBackground(Color.BLUE);
	    btnA5.setForeground(Color.ORANGE);
	    btnA5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnB1.getBackground() != Color.GRAY)
	    	btnB1.setBackground(Color.BLUE);
	    btnB1.setForeground(Color.ORANGE);
	    btnB1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnB2.getBackground() != Color.GRAY)
	    	btnB2.setBackground(Color.BLUE);
	    btnB2.setForeground(Color.ORANGE);
	    btnB2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnB3.getBackground() != Color.GRAY)
	    	btnB3.setBackground(Color.BLUE);
	    btnB3.setForeground(Color.ORANGE);
	    btnB3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnB4.getBackground() != Color.GRAY)
	    	btnB4.setBackground(Color.BLUE);
	    btnB4.setForeground(Color.ORANGE);
	    btnB4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnB5.getBackground() != Color.GRAY)
	    	btnB5.setBackground(Color.BLUE);
	    btnB5.setForeground(Color.ORANGE);
	    btnB5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnC1.getBackground() != Color.GRAY)
	    	btnC1.setBackground(Color.BLUE);
	    btnC1.setForeground(Color.ORANGE);
	    btnC1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnC2.getBackground() != Color.GRAY)
	    	btnC2.setBackground(Color.BLUE);
	    btnC2.setForeground(Color.ORANGE);
	    btnC2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnC3.getBackground() != Color.GRAY)
	    	btnC3.setBackground(Color.BLUE);
	    btnC3.setForeground(Color.ORANGE);
	    btnC3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnC4.getBackground() != Color.GRAY)
	    	btnC4.setBackground(Color.BLUE);
	    btnC4.setForeground(Color.ORANGE);
	    btnC4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnC5.getBackground() != Color.GRAY)
	    	btnC5.setBackground(Color.BLUE);
	    btnC5.setForeground(Color.ORANGE);
	    btnC5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnD1.getBackground() != Color.GRAY)
	    	btnD1.setBackground(Color.BLUE);
	    btnD1.setForeground(Color.ORANGE);
	    btnD1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnD2.getBackground() != Color.GRAY)
	    	btnD2.setBackground(Color.BLUE);
	    btnD2.setForeground(Color.ORANGE);
	    btnD2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnD3.getBackground() != Color.GRAY)
	    	btnD3.setBackground(Color.BLUE);
	    btnD3.setForeground(Color.ORANGE);
	    btnD3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnD4.getBackground() != Color.GRAY)
	    	btnD4.setBackground(Color.BLUE);
	    btnD4.setForeground(Color.ORANGE);
	    btnD4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnD5.getBackground() != Color.GRAY)
	    	btnD5.setBackground(Color.BLUE);
	    btnD5.setForeground(Color.ORANGE);
	    btnD5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnE1.getBackground() != Color.GRAY)
	    	btnE1.setBackground(Color.BLUE);
	    btnE1.setForeground(Color.ORANGE);
	    btnE1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnE2.getBackground() != Color.GRAY)
	    	btnE2.setBackground(Color.BLUE);
	    btnE2.setForeground(Color.ORANGE);
	    btnE2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnE3.getBackground() != Color.GRAY)
	    	btnE3.setBackground(Color.BLUE);
	    btnE3.setForeground(Color.ORANGE);
	    btnE3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnE4.getBackground() != Color.GRAY)
	    	btnE4.setBackground(Color.BLUE);
	    btnE4.setForeground(Color.ORANGE);
	    btnE4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnE5.getBackground() != Color.GRAY)
	    	btnE5.setBackground(Color.BLUE);
	    btnE5.setForeground(Color.ORANGE);
	    btnE5.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnF1.getBackground() != Color.GRAY)
	    	btnF1.setBackground(Color.BLUE);
	    btnF1.setForeground(Color.ORANGE);
	    btnF1.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnF2.getBackground() != Color.GRAY)
	    	btnF2.setBackground(Color.BLUE);
	    btnF2.setForeground(Color.ORANGE);
	    btnF2.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnF3.getBackground() != Color.GRAY)
	    	btnF3.setBackground(Color.BLUE);
	    btnF3.setForeground(Color.ORANGE);
	    btnF3.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
	    if(btnF4.getBackground() != Color.GRAY)
	    	btnF4.setBackground(Color.BLUE);
	    btnF4.setForeground(Color.ORANGE);
	    btnF4.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
	    
	    //If the button is not already gray, set the background to blue
	    //Then, set text color to orange and set the font
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


	    //Adds action listeners to all the buttons
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
	    
	    //Adds action listeners to finish and reload buttons
	    finish.addActionListener(this);
	    reload.addActionListener(this);

	}
	
	
	//Given the fileName (which was already selected) this reads the file and "loads" each
	//part of the file into the appropriate field of the game
	public void readFile(String fileName)
	{
		//Sets the container pnlPlay to a new JPanel
		Container pnlPlay = new JPanel();
		
		//Sets the container to this content pane
		pnlPlay = this.getContentPane();
		
		//Declares line string, which is used to store each line of the file upon reading
		String line;
	
		//Sets layout of the pnlPlay panel to a BoxLayout centered on the Y-axis
		pnlPlay.setLayout(new BoxLayout(pnlPlay, BoxLayout.Y_AXIS));
		
		//Sets the file input stream fin to null (initially)
		FileInputStream fin = null;
		
		//Try is used in case a fileNotFound exception is thrown, this generally will
		//occur if a file name is entered and a file of that name does not exist in the
		//destination folder listed for File "chosen"
		try{			
			//File chosen is set to the file in the folder listed below, and the fileName that
			//was the parameter of this method
			//NOTE: THE FOLDER SECTION MAY NEED TO BE CHANGED FOR THIS PROGRAM TO FIND FILES
			//ON DEVICES OTHER THAN MY PERSONAL COMPUTER.
			File chosen = new File("E:/CSCI 24000/10. Final Project/Double Jeopardy/Games/" + fileName);
			
			//Sets up a new scanner for the "chosen" file, using a comma as a delimiter
			Scanner scanner = new Scanner(chosen).useDelimiter(",");
			
			//I originally used this loop to make sure the entire file was read, but ultimately
			//decided to ensure the files were formatted exactly right and manually (using loops)
			//read through each part of the file and load to the appropriate place in the game
			//while(scanner.hasNextLine()){
			
				//This while loop is used to set the categories of the game to the
				//first six strings included in the specially formatted file being read
				while(z<6)
				{
					//Sets the line string to the next string (up to comma delimiter)
					//from Scanner named scanner
					line = scanner.next();
					
					//Sets the z^th category to the string stored in line
					this.setCat(z, line);
					
					//Increments z
					z++;
					
					//Used for reference, printing all of the category names
					//System.out.println("Category:" + line);
				}
				//While x<6 loops through each category of the game board while setting
				//each question's data, using the setData method.
				//"x" was chosen because, on the game board, categories are displayed
				//along the "x-axis" of the board.
				while(x<6)
				{
					//Resets y (the question looping variable) to zero
					y=0;
					
					//While y<5 loops through each question of each category of the game
					//board while setting each question's data, using the setData method.
					//"y" was chosen because, on the game board, categories are displayed
					//along the "y-axis" of the board.
					while(y<5)
					{	
						//Resets w (the answer choice looping variable) to zero
						w=0;
						
						//Sets line to the next comma separated string
						//This string is not used, as it is just a newline character, "\n"
						line = scanner.next();
						
						//Sets line to the next comma separated string
						//This string will be the point value of the question
						line = scanner.next();
						
						//Sets the question data for the y^th question of category x
						//to the point value specified in the file
						this.setData(x, y, line);
						
						//Used for reference.
						//System.out.println("PointValue:" + line);
						
						//Sets line to the next comma separated string
						line = scanner.next();
						
						//Sets the y^th question of category x to the line string
						this.setQuest(x, y, line);
						
						//Used for reference.
						//System.out.println("Question:" + line);
						
						//The following lines are repeated four times because each set
						//of lines represents "filling in" the four answer options
						//of one question
						
						//Sets line to the next comma separated string
						line = scanner.next();
						
						//Sets the answer number w of question y of category x
						//to the line string
						this.setAns(x, y, w, line);
						
						//Increments w
						w++;
						
						//Repeat above for second answer option
						line = scanner.next();
						this.setAns(x, y, w, line);
						w++;
						
						//Repeat above for third answer option
						line = scanner.next();
						this.setAns(x, y, w, line);
						w++;
						
						//Repeat above for fourth answer option
						line = scanner.next();
						this.setAns(x, y, w, line);
						w++;
						
						//Increment y (the question looping variable)
						y++;
					}
					//Increment x (the category looping variable)
					x++;
				}
				
			//See above note regarding previously used while loop
			//}
									
		}
		//Catches FileNotFoundException
		catch(FileNotFoundException n)
		{
			//Prints out "error message" to console window
			System.out.println("FILE NOT FOUND");
		}
				
		//pnlBoard.add(fileList);
		
		//Sets default close operation to exit on close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Sets pnlBoard's visibility to true
	    setVisible(true);
	    
	    //Sets the window size
	    setSize(2000,1200);
	}
	
	//Action performed method
	public void actionPerformed(ActionEvent p)
	{
		//setUpGUI();
		
		//q.receiveBoard(this);
		
		//If this is not the first button clicked
		if(!first)
		{
			//
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		
		
		//The following numerous lines of code do the same thing for each button, just for
		//the different questions that each corresponding button relates to.  To avoid
		//redundancy of comments, this explanation will explain what each block of code does.
		//The lines will be shown in the first block of code to be more specific to each line.
		
		//If the button is clicked...
		//...set the button's color to gray.
		//Set the m integer to the corresponding category
		//Set the n integer to the corresponding question number for that category
		//Set the pnts integer to the parsed string that is shown on the JButton clicked
		//Set the points of the WriteQuestion object to the string parsed above
		//Sets the question and answer strings to those stored in teh arrays in this class
		//Calls the setUpGUI method of the WriteQuestion class
		//The following "this..." statements are where the corresponding elements
		//of the String arrays in this class are adjusted for the new strings input
		//on the WriteQuestion class's JPanel
		
		//If the button is clicked...
		if(p.getSource() == btnA1){
			//...set the button's color to gray.
			btnA1.setBackground(Color.GRAY);
			
			//Set the m integer to the corresponding category
			m = 0;
			
			//Set the n integer to the corresponding question number for that category
			n = 0;
			
			//Set the pnts integer to the parsed string that is shown on the JButton clicked
			pnts = Integer.parseInt(btnA1.getText());
			
			//Set the points of the WriteQuestion object to the string parsed above
			q.setPoints(pnts);
			
			//Sets the question and answer strings to those stored in the arrays in this class
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			
			//Calls the setUpGUI method of the WriteQuestion class
			q.setUpGUI();
			
			//The following "this..." statements are where the corresponding elements
			//of the String arrays in this class are adjusted for the new strings input
			//on the WriteQuestion class's JPanel
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnA2){
			btnA2.setBackground(Color.GRAY);
			m = 0;
			n = 1;
			pnts = Integer.parseInt(btnA2.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnA3){
			btnA3.setBackground(Color.GRAY);
			m = 0;
			n = 2;
			pnts = Integer.parseInt(btnA3.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnA4){
			btnA4.setBackground(Color.GRAY);
			m = 0;
			n = 3;
			pnts = Integer.parseInt(btnA4.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnA5){
			btnA5.setBackground(Color.GRAY);
			m = 0;
			n = 4;
			pnts = Integer.parseInt(btnA5.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnB1){
			btnB1.setBackground(Color.GRAY);
			m = 1;
			n = 0;
			pnts = Integer.parseInt(btnB1.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnB2){
			btnB2.setBackground(Color.GRAY);
			m = 1;
			n = 1;
			pnts = Integer.parseInt(btnB2.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnB3){
			btnB3.setBackground(Color.GRAY);
			m = 1;
			n = 2;
			pnts = Integer.parseInt(btnB3.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnB4){
			btnB4.setBackground(Color.GRAY);
			m = 1;
			n = 3;
			pnts = Integer.parseInt(btnB4.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnB5){
			btnB5.setBackground(Color.GRAY);
			m = 1;
			n = 4;
			pnts = Integer.parseInt(btnB5.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnC1){
			btnC1.setBackground(Color.GRAY);
			m = 2;
			n = 0;
			pnts = Integer.parseInt(btnC1.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnC2){
			btnC2.setBackground(Color.GRAY);
			m = 2;
			n = 1;
			pnts = Integer.parseInt(btnC2.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnC3){
			btnC3.setBackground(Color.GRAY);
			m = 2;
			n = 2;
			pnts = Integer.parseInt(btnC3.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnC4){
			btnC4.setBackground(Color.GRAY);
			m = 2;
			n = 3;
			pnts = Integer.parseInt(btnC4.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnC5){
			btnC5.setBackground(Color.GRAY);
			m = 2;
			n = 4;
			pnts = Integer.parseInt(btnC5.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnD1){
			btnD1.setBackground(Color.GRAY);
			m = 3;
			n = 0;
			pnts = Integer.parseInt(btnD1.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnD2){
			btnD2.setBackground(Color.GRAY);
			m = 3;
			n = 1;
			pnts = Integer.parseInt(btnD2.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnD3){
			btnD3.setBackground(Color.GRAY);
			m = 3;
			n = 2;
			pnts = Integer.parseInt(btnD3.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnD4){
			btnD4.setBackground(Color.GRAY);
			m = 3;
			n = 3;
			pnts = Integer.parseInt(btnD4.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnD5){
			btnD5.setBackground(Color.GRAY);
			m = 3;
			n = 4;
			pnts = Integer.parseInt(btnD5.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnE1){
			btnE1.setBackground(Color.GRAY);
			m = 4;
			n = 0;
			pnts = Integer.parseInt(btnE1.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnE2){
			btnE2.setBackground(Color.GRAY);
			m = 4;
			n = 1;
			pnts = Integer.parseInt(btnE2.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnE3){
			btnE3.setBackground(Color.GRAY);
			m = 4;
			n = 2;
			pnts = Integer.parseInt(btnE3.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnE4){
			btnE4.setBackground(Color.GRAY);
			m = 4;
			n = 3;
			pnts = Integer.parseInt(btnE4.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnE5){
			btnE5.setBackground(Color.GRAY);
			m = 4;
			n = 4;
			pnts = Integer.parseInt(btnE5.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnF1){
			btnF1.setBackground(Color.GRAY);
			m = 5;
			n = 0;
			pnts = Integer.parseInt(btnF1.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnF2){
			btnF2.setBackground(Color.GRAY);
			m = 5;
			n = 1;
			pnts = Integer.parseInt(btnF2.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnF3){
			btnF3.setBackground(Color.GRAY);
			m = 5;
			n = 2;
			pnts = Integer.parseInt(btnF3.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnF4){
			btnF4.setBackground(Color.GRAY);
			m = 5;
			n = 3;
			pnts = Integer.parseInt(btnF4.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}
		else if(p.getSource() == btnF5){
			btnF5.setBackground(Color.GRAY);
			m = 5;
			n = 4;
			pnts = Integer.parseInt(btnF5.getText());
			q.setPoints(pnts);
			q.setQuest(quest[m][n], ans[m][n][0], ans[m][n][1], ans[m][n][2], ans[m][n][3]);
			q.setUpGUI();
			
			this.setData(m, n, q.getPoints());
			this.setQuest(m, n, q.getQuest());
			this.setAns(m, n, 0, q.getAnswer(0));
			this.setAns(m, n, 1, q.getAnswer(1));
			this.setAns(m, n, 2, q.getAnswer(2));
			this.setAns(m, n, 3, q.getAnswer(3));
		}	
		
		//If the reload button is clicked
		if(p.getSource() == reload){
			//Call this class's loadBoard and setUpGUI methods to reset the board screen
			loadBoard();
			setUpGUI();
		}
		
		//If the finish button is clicked
		if(p.getSource() == finish){
			//if(myFile != null)
			//{
			
			//try is used because of the possibility of an IOException
			try{
				//Makes new file writer
				FileWriter fw = new FileWriter(myFile);
				
				//Makes new buffered writer for the file writer
				BufferedWriter bfw = new BufferedWriter(fw);
				
				//Writes the categories and a comma after each to the file
				bfw.write(catA.getText() + ",");
				bfw.write(catB.getText() + ",");
				bfw.write(catC.getText() + ",");
				bfw.write(catD.getText() + ",");
				bfw.write(catE.getText() + ",");
				bfw.write(catF.getText() + ",");
				
				//Adds a new line character
				bfw.newLine();
				
				//Loops through each category and question and writes the point value,
				//question, and answer choices to the file and then adds a new line character
				for(x = 0; x<6; x++)
				{
					y = 0;
					for(y=0; y<5; y++)
					{
						//Adds the point value
						bfw.write("," + this.getData(x,y));
						
						//Adds the question
						bfw.write("," + this.getQuest(x,y));
						
						//Adds the answer choices
						bfw.write("," + this.getAns(x,y,0));
						bfw.write("," + this.getAns(x,y,1));
						bfw.write("," + this.getAns(x,y,2));
						bfw.write("," + this.getAns(x,y,3) + ",");
						
						//Adds the new line character
						bfw.newLine();
					}
				}
				
				//Flushes the buffered writer
				bfw.flush();
				
				//Closes the buffered writer and file writer
				bfw.close();
				fw.close();
				
				//Sets done to true (allows the close button to be added to
				//the panel upon the the next setUpGUI call)
				done = true;
				
				//Sets this JPanel's visibility to false
				setVisible(false);
				
				//Calls setUpGUI
				setUpGUI();
				
			}
			//Catches IOException
			catch(IOException e)
			{
				//Prints out a generic error line
				System.out.println("Error writing to file.");
			}
			
		}
		//}
		
		//If the close button is clicked
		if(p.getSource() == close)
		{
			//Set this window's visibility to false
			setVisible(false);
			//this.setVisible(false);
			//pnlBoard.setVisible(false);
		}
		
		//Set first to false
		first = false;
	}
	
	
	
}
