//Daniel Kobold
//PlayGame.java

//Import libraries
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;


public class PlayGame extends JFrame implements ActionListener {

	//Makes file object that can "look" in the designated location below
	//NOTE: THIS FILE PATH SECTION MAY NEED TO BE CHANGED FOR THIS PROGRAM TO FIND FILES
	//ON DEVICES OTHER THAN MY PERSONAL COMPUTER.
	File folder = new File("E:/CSCI 24000/10. Final Project/Double Jeopardy/Games");
	
	//Makes list of files, listing all of the files in the "folder" looker above
	File[] listOfFiles = folder.listFiles();
	
	//Makes new instance of the PlayerSelect class
	PlayerSelect players = new PlayerSelect();
	
	//Makes new instance of Board class
	Board game = new Board();
	
	String a = "";
	String b = "";
	
	//This integer is used to loop through each answer choice of a question of a category
	//of the game while setting each question's data when reading the file
	int w = 0;
	
	//This integer is used to loop through each category of the game while setting
	//each question's data when reading the file
	int x = 0;
	
	//This integer is used to loop through each question of a category of the game while
	//setting each question's data when reading the file
	int y = 0;
	
	//This integer is used to set each category of the game
	int z = 0;
	
	
	String fileLine = null;
	
	JPanel subPanel = new JPanel();
	
	//Sets up a JTextArea where user will type the name of their file
	JTextArea select = new JTextArea(5,100);
	
	//Label that tells user instructions on how to select their file
	JLabel files = new JLabel("Type the file name in the box below. (Include .txt)");
	
	//String that will hold all of the file names
	String fileString;
	
	//JTextArea where files will be listed
	JTextArea fileList = new JTextArea();
	
	JButton current = new JButton();
	
	
	JPanel pnlChoose = new JPanel();
	
	//JButton that is clicked when file name has been typed
	JButton go = new JButton("Confirm Selection");
	//JButton play = new JButton("Start Game");
	
	//PlayGame() constructor, calls chooseFile() method for the "start" of the game
	public PlayGame()
	{
		//Calls chooseFile() method
		chooseFile();
	}
	
	//chooseFile() method, guides user through file selection
	public void chooseFile()
	{
		//Sets container pnlChoose to this content pane
		Container pnlChoose = this.getContentPane();
		
		//Sets layout to border layout
		pnlChoose.setLayout(new BorderLayout());
		
		//Sets default close operation to exit on close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Sets pnlChoose's visibility to true
		setVisible(true);
		
		//Sets window size
		setSize(2000, 1200);
		
		//Sets the font of the JLabel with instructions
		files.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 56));
		
		//Sets foreground (font color) to orange
		files.setForeground(Color.ORANGE);
		
		//Adds action listener to the go button
		go.addActionListener(this);
		
		//Sets the font of the go button
		go.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 36));
		
		//Sets the font of the actual list of files
		fileList.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 20));
		
		//Sets the select JTextArea (for inputting file name) editable property to true
		select.setEditable(true);
		
		//Sets font of the select JTextArea (typed characters will appear in this font)
		select.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 20));
		
		//The following lines prepare the subPanel which will be at the bottom of the
		//main panel.  This subPanel will include the selection JTextArea and a go
		//button which will allow user to progress to the next screen.
		
		//Sets the subPanel's layout to BorderLayout()
		subPanel.setLayout(new BorderLayout());
		
		//Adds the select JTextArea to the subPanel
		subPanel.add(select, BorderLayout.WEST);
		
		//Adds the "go button" to the east side of the subPanel
		subPanel.add(go, BorderLayout.EAST);
		
		//Sets the main panel's background color to blue
		pnlChoose.setBackground(Color.BLUE);
		
		//Sets the main panel's foreground color (font color) to orange
		pnlChoose.setForeground(Color.ORANGE);
		
		//Adds the "files" (instructions) JLabel to the top of the main panel
		pnlChoose.add(files, BorderLayout.NORTH);
		
		//Adds the subPanel (with JTextArea and go button) to the bottom of the main panel
		pnlChoose.add(subPanel, BorderLayout.SOUTH);
		
		//This loop systematically adds each file name to the fileList JTextArea, which
		//is then added to the main panel
		for(int a = 0; a<listOfFiles.length; a++)
		{
			//Checks if each element of the listOfFiles is actually a file
			if(listOfFiles[a].isFile()){
				
				//If it is a file, adds the name of the file to the fileList JTextArea
				fileList.append(listOfFiles[a].getName());
				
				//Adds a newline character to the JTextArea, to make the list look nicer
				fileList.append("\n");
				
				//Originally used for reference, when printing the file names to the
				//console window
				//fileString += listOfFiles[a].getName();
				//fileString += "\n";
				//System.out.println(listOfFiles[a].getName());
			}
						
			//Sets the foreground color (text color) of the fileList to white
			fileList.setForeground(Color.WHITE);
			
			//Sets the background color of the fileList to blue
			fileList.setBackground(Color.BLUE);
			
			//Adds the fileList to the main panel, in the center of the borderLayout
			pnlChoose.add(fileList, BorderLayout.CENTER);
		}		
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
			//NOTE: THIS FILE PATH SECTION MAY NEED TO BE CHANGED FOR THIS PROGRAM TO FIND FILES
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
					game.setCat(z, line);
					
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
						game.setData(x, y, line);
						
						//Used for reference.
						//System.out.println("PointValue:" + line);
						
						//Sets line to the next comma separated string
						line = scanner.next();
						
						//Sets the y^th question of category x to the line string
						game.setQuest(x, y, line);
						
						//Used for reference.
						//System.out.println("Question:" + line);
						
						//The following lines are repeated four times because each set
						//of lines represents "filling in" the four answer options
						//of one question
						
						//Sets line to the next comma separated string
						line = scanner.next();
						
						//Sets the answer number w of question y of category x
						//to the line string
						game.setAns(x, y, w, line);
						
						//Increments w
						w++;
						
						//Repeat above for second answer option
						line = scanner.next();
						game.setAns(x, y, w, line);
						w++;
						
						//Repeat above for third answer option
						line = scanner.next();
						game.setAns(x, y, w, line);
						w++;
						
						//Repeat above for fourth answer option
						line = scanner.next();
						game.setAns(x, y, w, line);
						w++;
						
						//Increment y (the question looping variable)
						y++;
					}
					//Increment x (the category looping variable)
					x++;
				}
				
			//See above note regarding previously used while loop
			//}
			
			//Calls the select method of the instance of PlayerSelect named players
			//This initiates the player name entry process
			players.select();						
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
	
	//Action performed method, for when the go button is clicked
	public void actionPerformed(ActionEvent g)
	{
		//If the go button is clicked
		if(g.getSource() == go){
			
			//Calls readFile method for the text the user typed into the "select"
			//JTextArea
			readFile(select.getText());
			
			//Sets the panel's visibility to false
			setVisible(false);
			
			//Calls the select method of the instance of PlayerSelect named players
			//This initiates the player name entry process
			players.select();
			
			//Calls the receiveBoard method of PlayerSelect to make players receive
			//the game board
			players.receiveBoard(game);			
		}
	}
	
	//Main method makes a new instance of the PlayGame class
	public static void main(String[] args) {
		new PlayGame();
	}

}
