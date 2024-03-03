package snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Key extends KeyAdapter
{
	private Snake s1;
	Key(Snake s1)
	{
		this.s1 = s1 ;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:		//if user press the left key then he can go left only if he is going up or down 
			if(s1.getDirection() != 'R') {
				s1.setDirection('L'); 
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(s1.getDirection() != 'L') {
				s1.setDirection('R'); 
			}
			break;
		case KeyEvent.VK_UP:
			if(s1.getDirection() != 'D') {
				s1.setDirection('U'); 
			}
			break;
		case KeyEvent.VK_DOWN:
			if(s1.getDirection()!= 'U') {
				s1.setDirection('D');
			}
			break;
		}
	}
}