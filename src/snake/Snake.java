package snake;

public class Snake {

	private int bodyParts ;			//length of snake
	private char direction ;		//direction where it's going
	private boolean running = false;		//if it's going or not
	
	Snake()
	{
		setBodyParts(5);
		setDirection('R');
		setRunning(true);
	}

	public int getBodyParts() {
		return bodyParts;
	}

	public void setBodyParts(int bodyParts) {
		this.bodyParts = bodyParts;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}
