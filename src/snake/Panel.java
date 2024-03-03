package snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel implements ActionListener{

	private final int SCREEN_WIDTH = 1300;
	private final int SCREEN_HEIGHT = 750;
	private final int UNIT_SIZE = 50;						//pixel of height and width
	private final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	private final int DELAY = 175;
	private final int x[] = new int[GAME_UNITS];			//coordinate of snake 
	private final int y[] = new int[GAME_UNITS];
	private Timer timer;							//timer
	private Apple a1;								//apple 
	private Snake s1 ;								//snake
	private Border b1 ;
	
	Panel()
	{
		a1 = new Apple(SCREEN_WIDTH,SCREEN_HEIGHT,UNIT_SIZE);
		s1 = new Snake();	
		b1 = new Border(SCREEN_WIDTH, SCREEN_HEIGHT);
		timer = new Timer(DELAY,this);
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);		
		this.addKeyListener(new Key(s1));				
		timer.start();
	}
	//paint
	public void paintComponent(Graphics g) {
		//Overriding paint component 
		super.paintComponent(g);			//get the paint Component and draw on it		
		draw(g);
	}
	public void draw(Graphics g) 
	{
		if(s1.isRunning()) 
		{
			//creating an apple
			g.setColor(Color.red);		//red 
			g.fillOval(a1.getAppleX(), a1.getAppleY(), UNIT_SIZE, UNIT_SIZE);		//shape of an oval
		
			for(int i = 0; i< s1.getBodyParts();i++) {
				if(i == 0) 
				{
					g.setColor(new Color(15,125,15));			//dark green color for head
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);	//fill the rect with color
				}
				else 
				{
					g.setColor(Color.green);		//green color for body
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);	
				}			
			}
			//write the score on the top 
			g.setColor(Color.red);
			g.setFont( new Font("Ink Free",Font.BOLD, 40));
			g.drawString("Score: "+ a1.getApplesEaten() , 550, g.getFont().getSize());
		}
		else 
		{
			gameOver(g);	//if it isn't running
		}
	}
	public void move(){
		for(int i = s1.getBodyParts();i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(s1.getDirection()) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;			
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
		
	}
	public void checkApple() 
	{
		//check the if snake has eaten the apple
		if((x[0] == a1.getAppleX()) && (y[0] == a1.getAppleY())) {
			s1.setBodyParts(s1.getBodyParts()+1);
			a1.getApplesEaten();
			a1 = new Apple(SCREEN_WIDTH,SCREEN_HEIGHT,UNIT_SIZE);
			//to not to create an apple inside the body 
			for(int i = 0; i< s1.getBodyParts();i++) 
			{
				while(a1.getAppleX() == x[i] && a1.getAppleY() == y[i])	
				{
					a1 = new Apple(SCREEN_WIDTH,SCREEN_HEIGHT,UNIT_SIZE);
				}
			}
		}
	}
	
	public void checkCollision() {
		//checks if head collides with body
		for(int i = s1.getBodyParts();i>0;i--) 
		{
			if((x[0] == x[i])&& (y[0] == y[i])) {
				s1.setRunning(false);
			}
		}
		//check if head touches left border
		if(x[0] < 0) {
			s1.setRunning(false);
		}
		//check if head touches right border
		if(x[0] > b1.getWidth()) {
			s1.setRunning(false);
		}
		//check if head touches top border
		if(y[0] < 0) {
			s1.setRunning(false);
		}
		//check if head touches bottom border
		if(y[0] > b1.getHeight()) {
			s1.setRunning(false);
		}
		
		if(!s1.isRunning()) {
			timer.stop();
		}
	}
	public void gameOver(Graphics g) {
		//Score
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 40));
		g.drawString("Score: "+a1.getApplesEaten(), 550, g.getFont().getSize());
		//Game Over text
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 75));
		g.drawString("Game Over", 425, SCREEN_HEIGHT/2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(s1.isRunning()) {
			move();
			checkApple();
			checkCollision();
		}
		repaint();				//repaint the panel a method of component class
	}
		   
}
