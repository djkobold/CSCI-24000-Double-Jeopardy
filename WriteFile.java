//Daniel Kobold
//WriteFile.java

//Import statements
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class WriteFile extends JFrame implements ActionListener{

	//New file in the designated games folder
	File myFile = new File("E:/CSCI 24000/10. Final Project/Double Jeopardy/Games");
	
	//Makes list of files, listing all of the files in the "folder" looker above
	File[] listOfFiles = myFile.listFiles();
	
	int x = 0;
	int y = 0;
	
	//New WriteBoard object
	WriteBoard myBoard = new WriteBoard();
	
	//New JPanel for selection of the file to write/edit
	JPanel nameFile = new JPanel();
	
	//JPanel (sub-panel) for the text entry area
	JPanel subPanel = new JPanel();
	
	//Confirm button for confirming the typed title is correct
	JButton confirm = new JButton("Confirm Title");
	
	//Instruction below the text entry line
	JLabel typeInst = new JLabel("Type something like this: \"gameName\" (no need for .txt or the quotation marks)");
	
	//Instruction to type file name
	JLabel inst = new JLabel("Type your file name here:  ");
	
	//Instruction that is above the list of files
	JLabel fileListInst = new JLabel("Current list of files:");
	
	//JTextArea for the list of files
	JTextArea fileList = new JTextArea("");
	
	//JTextArea for typing the file name
	JTextArea type = new JTextArea("");
	
	//WriteFile constructor
	public WriteFile()
	{
		//Sets the nameFile container to this content pane
		Container nameFile = this.getContentPane();
		
		//Sets layout to a border layout
		nameFile.setLayout(new BorderLayout());
		
		//Sets sub-panel layout to a border layout
		subPanel.setLayout(new BorderLayout());
		
		
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
		}
					
		//Sets the foreground color (text color) of the fileList to white
		fileList.setForeground(Color.WHITE);
		
		//Sets the background color of the fileList to blue
		fileList.setBackground(Color.BLUE);
		
		//Sets the background of the instruction to blue and the text color to orange
		fileListInst.setBackground(Color.BLUE);
		fileListInst.setForeground(Color.ORANGE);
		
		//Sets the font of the instructions
		fileListInst.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));

		//Sets background of the JPanel to blue
		nameFile.setBackground(Color.BLUE);
		
		//Sets the font of the file list
		fileList.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 20));
		
		//Adds the file list instructions and file list to the JPanel
		nameFile.add(fileListInst, BorderLayout.NORTH);
		nameFile.add(fileList, BorderLayout.CENTER);
		
		//Sets the font of the text entry box
		type.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 30));
		
		//Sets the font of the text entry box instructions
		typeInst.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 30));
		
		//Sets the font of the instructions
		inst.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		
		//Sets the font of the confirm button
		confirm.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		
		//Adds an action listener to the confirm button
		confirm.addActionListener(this);
		
		//Adds instructions JLabel to the subPanel
		subPanel.add(inst, BorderLayout.WEST);
		
		//Adds the text entry JTextArea to the center of the sub-panel
		subPanel.add(type, BorderLayout.CENTER);
		
		//Adds the confirm JButton to the right side of the sub-panel
		subPanel.add(confirm, BorderLayout.EAST);
		
		//Adds other instructions to the sub-panel
		subPanel.add(typeInst, BorderLayout.SOUTH);
		
		//Adds the completed sub-panel to the bottom of the JPanel
		nameFile.add(subPanel, BorderLayout.SOUTH);
		
		//Sets the size of the JPanel
		setSize(2000, 1200);
		
		//Sets visibility to true
		setVisible(true);
		
		//Sets default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	/*This method is no longer needed, the real file writing occurs in WriteBoard.java
	//writeGame method takes a file and writes the entire game to that file
	public void writeGame(File file) throws IOException
	{
		//Try is needed in case of an IOException error
		try{
			//Makes a new file writer
			FileWriter fw = new FileWriter(file);
			
			//Makes a new buffered writer for the above file writer
			BufferedWriter bfw = new BufferedWriter(fw);
			
			
			bfw.write("Category,Category,Category,Category,Category,Category,");
			bfw.newLine();
			
			for(x = 0; x<6; x++)
			{
				y = 0;
				for(y=0; y<5; y++)
				{
					bfw.write("," + myBoard.getData(x,y));
					bfw.write("," + myBoard.getQuest(x,y));
					bfw.write("," + myBoard.getAns(x,y,0));
					bfw.write("," + myBoard.getAns(x,y,1));
					bfw.write("," + myBoard.getAns(x,y,2));
					bfw.write("," + myBoard.getAns(x,y,3) + ",");
					bfw.newLine();
				}
			}
			
			bfw.flush();
			
			bfw.close();
		}
		catch(IOException e)
		{
			System.out.println("Error writing to file.");
		}
		

		myBoard.readFile(type.getText() + ".txt");
		myBoard.loadBoard();
		myBoard.setUpGUI();
	}*/
	
	//writeDefault method writes a basic game to any new file when called
	public void writeDefault(File file) throws IOException
	{
		//Looked up how to write text files in java
		//Source: www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
		try{
			//New file writer
			FileWriter fw = new FileWriter(file);
			
			//New buffered writer for the file writer
			BufferedWriter bfw = new BufferedWriter(fw);
			
			//Writes generic category names
			bfw.write("Category,Category,Category,Category,Category,Category,");
			
			//Adds newline character
			bfw.newLine();
			
			//Loops four times and adds basic question information each time
			for(int a = 0; a<5; a++)
			{
				//Adds basic question information and adds a new line character after each line
				bfw.write(",200,Question,Right Answer,Wrong Answer,Wrong Answer,Wrong Answer,");
				bfw.newLine();
				bfw.write(",400,Question,Right Answer,Wrong Answer,Wrong Answer,Wrong Answer,");
				bfw.newLine();
				bfw.write(",600,Question,Right Answer,Wrong Answer,Wrong Answer,Wrong Answer,");
				bfw.newLine();
				bfw.write(",800,Question,Right Answer,Wrong Answer,Wrong Answer,Wrong Answer,");
				bfw.newLine();
				bfw.write(",1000,Question,Right Answer,Wrong Answer,Wrong Answer,Wrong Answer,");
				bfw.newLine();
			}
			//Adds basic question information and adds new line character after each line, except the last one
			bfw.write(",200,Question,Right Answer,Wrong Answer,Wrong Answer,Wrong Answer,");
			bfw.newLine();
			bfw.write(",400,Question,Right Answer,Wrong Answer,Wrong Answer,Wrong Answer,");
			bfw.newLine();
			bfw.write(",600,Question,Right Answer,Wrong Answer,Wrong Answer,Wrong Answer,");
			bfw.newLine();
			bfw.write(",800,Question,Right Answer,Wrong Answer,Wrong Answer,Wrong Answer,");
			bfw.newLine();
			bfw.write(",1000,Question,Right Answer,Wrong Answer,Wrong Answer,Wrong Answer,");
			
			//Flushes the buffered writer
			bfw.flush();
			
			//Closes the buffered writer
			bfw.close();
			
			//Closes the file writer
			fw.close();
		}
		//Catches IOExceptions
		catch(IOException e)
		{
			//Prints basic error message
			System.out.println("Error writing to file.");
		}
		
		//Now that the default game has been written to the file, sets up a new
		//WriteBoard for actually changing what is in the default game
		WriteBoard myBoard = new WriteBoard();
		
		//Calls WriteBoard's readFile method for the game name that was typed in
		myBoard.readFile(type.getText() + ".txt");
		
		//Calls loadBoard and setUpGUI to finish putting the screen together
		myBoard.loadBoard();
		myBoard.setUpGUI();
	}
	
	//actionPerformed method
	public void actionPerformed(ActionEvent w)
	{
		//If the user clicks the confirm button
		if(w.getSource() == confirm)
		{
			//Either makes a new file or sets myGame to the previously made file in the games folder
			File myGame = new File("E:/CSCI 24000/10. Final Project/Double Jeopardy/Games/"+type.getText()+".txt");
			
			//try is used because of the possibility of an IOException
			try{
				//If a new file is/was created
				if(myGame.createNewFile())
				{
					//Then make myBoard receive the new file
					myBoard.receiveFile(myGame);
					
					//Set this JPanel's visibility to false
					setVisible(false);
					
					//Calls writeDefault for this new file
					writeDefault(myGame);
					
					//Calls readFile method for this new file
					myBoard.readFile(type.getText() + ".txt");
					
					//Calls loadBoard and setUpGUI to set up the next screen
					myBoard.loadBoard();
					myBoard.setUpGUI();
					
					//Sets this window's visibility to false
					this.setVisible(false);
					
				}
				//Otherwise a new file was not made
				else
				{
					//Calls receiveFile method of WriteBoard
					myBoard.receiveFile(myGame);
					
					//Calls readFile method of WriteBoard
					myBoard.readFile(type.getText() + ".txt");
					
					//Calls loadBoard and setUpGUI to set up the next screen
					myBoard.loadBoard();
					myBoard.setUpGUI();
					
					//Sets this window's visibility to false
					this.setVisible(false);
				}	
			}
			//Catches IOException
			catch(IOException we)
			{
				System.out.println("IOException");
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		new WriteFile();	
		
	}

}
