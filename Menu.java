//Daniel Kobold
//Menu class - displays main menu with Play a Game and Write a File options

//Import statements
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
	
	//Strings to be added to JLabel or JButtons
	String title = "Double Jeopardy!";
	String play = "Play a Game";
	String write = "Make a Game";
	
	//New JLabel and JButtons
	JLabel jTitle = new JLabel(title);
	JButton jPlay = new JButton(play);
	JButton jWrite = new JButton(write);
		
	//New JPanel
	JPanel m = new JPanel();
	
	//Menu default constructor, calls setUpMenu() method
	public Menu()
	{
		setUpMenu();
	}
	
	//Sets up the main menu
	public void setUpMenu(){
		
		//Sets x-axis alignment to center for JLabel and JButtons
		jTitle.setAlignmentX(CENTER_ALIGNMENT);
		//jTitle.setAlignmentY(CENTER_ALIGNMENT);
		jPlay.setAlignmentX(CENTER_ALIGNMENT);
		//jPlay.setAlignmentY(CENTER_ALIGNMENT);
		jWrite.setAlignmentX(CENTER_ALIGNMENT);
		//jWrite.setAlignmentY(CENTER_ALIGNMENT);
		
		//Set the title to the specified font and orange text color
		jTitle.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 200));
		jTitle.setForeground(Color.ORANGE);
		
		//Set the title to the specified font and orange text color, and set background to blue
		jWrite.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
		jWrite.setForeground(Color.BLUE);
		jWrite.addActionListener(this);
		
		//Set the title to the specified font and orange text color, and set background to blue
		jPlay.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 72));
		jPlay.setForeground(Color.BLUE);
		jPlay.addActionListener(this);

		//Set up container m to this content pane
		Container m = this.getContentPane();
		
		
		//m.setLayout(new GridLayout(3, 1));
		
		//Set background to blue and layout to a box layout
		m.setBackground(Color.BLUE);
		m.setLayout(new BoxLayout(m, BoxLayout.Y_AXIS));
		
		//Add jTitle, jPlay, and jWrite to the JPanel
		m.add(jTitle);
		m.add(jPlay);
		m.add(jWrite);
		
		//Set default close operation, set visible to true, and set window size
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(2000, 1200);
	}
	
	//Method for actions performed (when buttons are clicked)
	public void actionPerformed(ActionEvent e){
		//If Play a Game button is clicked
		if(e.getSource() == jPlay){
			//setVisible(false);
			PlayGame game = new PlayGame();
		}
		//Otherwise if Write a File button is clicked
		else if(e.getSource() == jWrite){
			//setVisible(false);
			WriteFile write = new WriteFile();
		}
	}
}
