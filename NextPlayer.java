
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NextPlayer extends JFrame{
	
	JPanel pnlNext = new JPanel();
	JLabel nm = new JLabel();
	JLabel ins = new JLabel("Next player/team is ");
	
	public NextPlayer()
	{
		
	}
	
	public NextPlayer(String name)
	{
		pnlNext.setSize(500,500);
		pnlNext.setLayout(new GridLayout(1,2));
		nm.setText(name);
		pnlNext.add(ins);
		pnlNext.add(nm);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
