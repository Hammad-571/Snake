package snake;

import javax.swing.JFrame;

public class Frame extends JFrame{

	Frame()
	{	
		this.add(new Panel());			//create new panel 
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();					//adjust the size of windows according to child
		this.setVisible(true);
		this.setLocationRelativeTo(null);	
	}
}
