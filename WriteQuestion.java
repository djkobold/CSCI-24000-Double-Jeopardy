
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class WriteQuestion extends JFrame implements ActionListener {

	//This is the JPanel for writing a question
	JPanel quest = new JPanel();
	
	//String that holds the question
	String question;
	
	//String array that holds the answer choices
	String[] answer = new String[4];
	
	//Integer for the number of points the question is worth
	int points = 0;
	
	//String for the number of points the question is worth
	String ptS = "";
	
	//WriteBoard upBoard = new WriteBoard();
	
	//Preliminary instruction and blank JLabels for formatting
	JLabel qInst = new JLabel("Write your question here.");
	JLabel b1 = new JLabel("");
	JLabel b2 = new JLabel("");
	JLabel b3 = new JLabel("");
	
	//Point value instruction, JTextArea for text input, and blank JLabels for formatting
	JLabel pntInst = new JLabel("Point Value: (For 0 Points, type 0, don't leave blank)");
	JTextArea pntType = new JTextArea("");
	JLabel b4 = new JLabel("");
	JLabel b5 = new JLabel("");
	
	//JLabel for question, JTextArea for text input, and blank JLabels for formatting
	JLabel questInst = new JLabel("Question:");
	JTextArea questType = new JTextArea("");
	JLabel b6 = new JLabel("");
	JLabel b7 = new JLabel("");
	
	//JLabel for correct answer, JTextArea for text input, and blank JLabels for formatting
	JLabel a1Inst = new JLabel("Correct Answer:");
	JTextArea a1Type = new JTextArea("");
	JLabel b8 = new JLabel("");
	JLabel b9 = new JLabel("");
	
	//JLabel for incorrect answer, JTextArea for text input, and blank JLabels for formatting
	JLabel a2Inst = new JLabel("Wrong Answer 1:");
	JTextArea a2Type = new JTextArea("");
	JLabel b10 = new JLabel("");
	JLabel b11 = new JLabel("");
	
	//JLabel for incorrect answer, JTextArea for text input, and blank JLabels for formatting
	JLabel a3Inst = new JLabel("Wrong Answer 2:");
	JTextArea a3Type = new JTextArea("");
	JLabel b12 = new JLabel("");
	JLabel b13 = new JLabel("");
	
	//JLabel for incorrect answer, JTextArea for text input, and blank JLabels for formatting
	JLabel a4Inst = new JLabel("Wrong Answer 3:");
	JTextArea a4Type = new JTextArea("");
	JLabel b14 = new JLabel("");
	JLabel b15 = new JLabel("");
	
	//Blank JLabel for formatting, JButton to submit the question
	JLabel b16 = new JLabel("");
	JButton confirm = new JButton("Submit Question");
	
	
	/*public void receiveBoard(WriteBoard b)
	{
		//upBoard = b;
	}*/
	
	
	//WriteQuestion constructor (does nothing)
	public WriteQuestion()
	{
		
	}
	
	//setUpGUI method, sets up WriteQuestion GUI
	public void setUpGUI()
	{
		//Sets quest container to this content pane
		Container quest = this.getContentPane();
		
		//Sets JPanel layout to a large grid layout
		quest.setLayout(new GridLayout(15,2));
		
		//Sets JPanel background to blue
		quest.setBackground(Color.BLUE);
		
		//Sets all of the JLabels foreground (text) color to orange
		qInst.setForeground(Color.ORANGE);
		pntInst.setForeground(Color.ORANGE);
		questInst.setForeground(Color.ORANGE);
		a1Inst.setForeground(Color.ORANGE);
		a2Inst.setForeground(Color.ORANGE);
		a3Inst.setForeground(Color.ORANGE);
		a4Inst.setForeground(Color.ORANGE);
		
		//Sets the font for all JLabels and JTextAreas
		qInst.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 50));
		pntInst.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		pntType.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		questInst.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		questType.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		a1Inst.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		a1Type.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		a2Inst.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		a2Type.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		a3Inst.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		a3Type.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		a4Inst.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		a4Type.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 30));
		
		//Adds first instruction and one blank JLabel
		quest.add(qInst);
		quest.add(b1);
		
		//Adds blank JLabels for formatting
		quest.add(b2);
		quest.add(b3);
		
		//Adds JLabel for point value instruction and JTextArea for text entry
		quest.add(pntInst);
		quest.add(pntType);
		
		//Adds blank JLabels for formatting
		quest.add(b4);
		quest.add(b5);
		
		//Adds JLabel for question instruction and JTextArea for text entry
		quest.add(questInst);
		quest.add(questType);
		
		//Adds blank JLabels for formatting
		quest.add(b6);
		quest.add(b7);
		
		//Adds JLabel for answer 1 instruction and JTextArea for text entry
		quest.add(a1Inst);
		quest.add(a1Type);
		
		//Adds blank JLabels for formatting
		quest.add(b8);
		quest.add(b9);
		
		//Adds JLabel for answer 2 instruction and JTextArea for text entry
		quest.add(a2Inst);
		quest.add(a2Type);
		
		//Adds blank JLabels for formatting
		quest.add(b10);
		quest.add(b11);
		
		//Adds JLabel for answer 3 instruction and JTextArea for text entry
		quest.add(a3Inst);
		quest.add(a3Type);
		
		//Adds blank JLabels for formatting
		quest.add(b12);
		quest.add(b13);
		
		//Adds JLabel for answer 4 instruction and JTextArea for text entry
		quest.add(a4Inst);
		quest.add(a4Type);
		
		//Adds blank JLabels for formatting
		quest.add(b14);
		quest.add(b15);
		
		//Adds action listener to the confirm button
		confirm.addActionListener(this);
		
		//Adds blank JLabel for formatting and the confirm button to JPanel
		quest.add(b16);
		quest.add(confirm);
		
		//Sets default close operation, size of the JPanel, and visibility to true
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(2000,1200);
		setVisible(true);
		
	}
	
	//setQuest (set question) method with inputs of five strings
	public void setQuest(String q, String a, String b, String c, String d)
	{
		//Sets the strings used in file writing to the parameter strings given
		question = q;
		answer[0] = a;
		answer[1] = b;
		answer[2] = c;
		answer[3] = d;
		
		//Sets the editable JTextArea texts to the same strings from above
		//This is so, upon trying to edit the question, the already saved text appears
		pntType.setText("" + points);
		questType.setText(q);
		a1Type.setText(a);
		a2Type.setText(b);
		a3Type.setText(c);
		a4Type.setText(d);
	}
	
	//getQuest (get question) method returns question string
	public String getQuest()
	{
		return question;
	}
	
	//getAnswer method returns the a^th answer string for the given question
	public String getAnswer(int a)
	{
		return answer[a];
	}
	
	//setPoints method sets the integer point value to the given parameter integer
	public void setPoints(int pts)
	{
		points = pts;
	}
	
	//This method is no longer necessary
	/*public void setPoints(String st)
	{
		ptS = st;
	}*/
	
	//getPoints method returns the String representation of the point value of the given question
	public String getPoints()
	{
		ptS = "" + points;
		return ptS;
	}
	
	//actionPerformed method
	public void actionPerformed(ActionEvent q)
	{
		//If the confirm button is clicked
		if(q.getSource() == confirm)
		{
			//Sets point value to the parsed integer of the text typed into the pntType JTextArea
			//An error occurs if the user leaves this box blank, but the user is instructed
			//against leaving the point value box blank
			setPoints(Integer.parseInt(pntType.getText()));
			
			//Sets the question and answers to the text in the corresponding JTextAreas
			setQuest(questType.getText(), a1Type.getText(), a2Type.getText(), a3Type.getText(), a4Type.getText());
			
			//Sets visibility to false ("closes" the window)
			setVisible(false);
		}
	}
	
}
